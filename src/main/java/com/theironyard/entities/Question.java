package com.theironyard.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue
    int id;

    @Column
    String title;

    @Column
    String type;

    @Column(nullable = false)
    String text;

    public Question(){

    }

    public Question(int id, String title, String type, String text) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.text = text;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

}
