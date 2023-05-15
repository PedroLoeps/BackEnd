package com.PhSystem.BackEnd;


import com.PhSystem.BackEnd.Models.Alarm;
import com.PhSystem.BackEnd.Models.Log;
import com.PhSystem.BackEnd.Models.Sensor;
import com.PhSystem.BackEnd.Repo.AlarmRepo;
import com.PhSystem.BackEnd.Repo.ClientRepo;
import com.PhSystem.BackEnd.Repo.LogRepo;
import com.PhSystem.BackEnd.Repo.SensorRepo;
import com.PhSystem.BackEnd.Service.EmailService;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Configuration
public class MqttHandler {

    @Autowired
    private LogRepo logRepo;

    @Autowired
    private AlarmRepo alarmRepo;

    @Autowired
    private SensorRepo sensorRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private EmailService emailService;

    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();

        options.setServerURIs(new String[] {"tcp://52.47.198.222:1883"});
        //options.setUserName();
        //options.setPassword();
        options.setCleanSession(true);

        factory.setConnectionOptions(options);

        return factory;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }


    @Bean
    public MessageProducer inbound(){
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("serverIn",
                mqttClientFactory(), "#");

        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }


    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler mqttInHandler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();

                System.out.println(topic);

                //TODO Receive Payload in bytes
                String payload = message.getPayload().toString();

                System.out.println("Payload " + payload);

                String[] para = payload.split("\\s");

                for(String a: para)
                {
                    System.out.println(a);
                }

                if(topic.equals("sensor/alarm"))
                {
                    Alarm alarm = new Alarm(para[0], Integer.parseInt(para[1]), new Date());
                    String clientId = sensorRepo.findById(para[0]).get().getClient();
                    String email = clientRepo.findById(clientId).get().getEmail();
                    emailService.sendEmail(email, "Alarm", "Alarm Detected");
                    alarmRepo.save(alarm);
                }
                else if(topic.equals("sensor/log"))
                {
                    int logs = Integer.parseInt(para[1]);
                    System.out.println(logs);
                    //TODO Handle the time of the logs
                    LocalDateTime curr_Time = LocalDateTime.now();
                    LocalDateTime time;
                    Date d;
                    for(int i=0; i<logs; i++)
                    {
                        time = curr_Time.withSecond(curr_Time.getSecond()-10*i);
                        d = Date.from(time.toInstant(ZoneOffset.ofHours(0)));
                        Log log = new Log(para[0], Integer.parseInt(para[2+2*i]), Float.parseFloat(para[3+2*i]), Float.parseFloat(para[3+2*i])+2, d);
                        logRepo.save(log);
                    }
                }

                System.out.println("Saved with success");

            }
        };
    }

    @Bean
    public MessageChannel mqttOutputChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutputChannel")
    public MessageHandler mqttOutHandler() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("serverOut", mqttClientFactory());

        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic("#");
        return messageHandler;
    }


}
