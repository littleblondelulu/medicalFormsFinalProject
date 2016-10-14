package com.theironyard.entities;


public class FormPatientViewModel {

    Form form;

    Patient patient;

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

    public FormPatientViewModel(Form form, Patient patient) {
        this.form = form;
        this.patient = patient;
    }

}
