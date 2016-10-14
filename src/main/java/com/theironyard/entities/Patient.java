package com.theironyard.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue
    int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToMany
    List<Record> records;

    public Patient(String firstName, String lastName, List<Record> records) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.records = records;
    }

    public Patient(){};



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public List<Record> getRecords() {
        return this.records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
