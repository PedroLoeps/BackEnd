package com.PhSystem.BackEnd.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @Column(name = "Username")
    private String name;

    @Column(name = "Passw")
    private String password;

    @Column(name = "Perm_level")
    private int perm_level;

    @Column(name = "Email")
    private String email;



    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermissions() {
        return perm_level;
    }

    public void setPermissions(int perm_level) {
        this.perm_level = perm_level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
