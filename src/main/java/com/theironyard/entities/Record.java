package com.theironyard.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue
    int id;

    @Column
    String name;

    @ManyToOne
    Form form;

    @ManyToOne
    Patient patient;

    @OneToMany
    List<Answer> answers;

    @Column
    int date;

    public Record(List<Answer> answers){}

    public Record(String name, Form form, Patient patient, List<Answer> answers, int date) {
        this.name = name;
        this.form = form;
        this.patient = patient;
        this.answers = answers;
        this.date = date;
    }

    public Record(int id, String name, Form form, Patient patient, List<Answer> answers, int date) {
        this.id = id;
        this.name = name;
        this.form = form;
        this.patient = patient;
        this.answers = answers;
        this.date = date;
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

    public Form getForm() {
        return this.form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getDate() {
        return this.date;
    }

    public void setDate(int date) {
        this.date = date;
    }

//WILL NEED TO SET THE FIELDS BELOW TO WHAT I FOUND IN REPOSITORY

}
