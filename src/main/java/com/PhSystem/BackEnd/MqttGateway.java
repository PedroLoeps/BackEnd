package com.PhSystem.BackEnd;


import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "mqttOutputChannel")
public interface MqttGateway {

    void sentToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
}
