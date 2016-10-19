package com.theironyard.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    Form form;

    @ManyToOne
    Patient patient;

    @OneToMany
    List<Answer> answers;

  //  @Column
    //int date;

    public Record() {

    }

    public Record(List<Answer> answers){}

    public Record(Form form, Patient patient, List<Answer> answers) {
        this.form = form;
        this.patient = patient;
        this.answers = answers;
    }

    public Record(int id, Form form, Patient patient, List<Answer> answers) {
        this.id = id;
        this.form = form;
        this.patient = patient;
        this.answers = answers;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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


//WILL NEED TO SET THE FIELDS BELOW TO WHAT I FOUND IN REPOSITORY

}
