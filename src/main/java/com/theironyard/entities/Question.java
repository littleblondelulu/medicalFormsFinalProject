package com.theironyard.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue
    int id;

    @Column
    int formID;

    @Column
    String title;

    @Column
    String type;

    @Column(nullable = false)
    String text;

    @Column
    String answer;

    public Question(){};

    public Question(int id, int formID, String title, String type, String text, String answer) {
        this.id = id;
        this.formID = formID;
        this.title = title;
        this.type = type;
        this.text = text;
        this.answer = answer;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFormID() {
        return this.formID;
    }

    public void setFormID(int formID) {
        this.formID = formID;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
