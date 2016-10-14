package com.theironyard.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column
    String password;

    @OneToMany
    List<Patient> patients = new ArrayList<>();

    public User() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Patient> getPatients() {
        return this.patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

