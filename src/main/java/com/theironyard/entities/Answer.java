package com.theironyard.entities;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    Question question;

    @Column(nullable = false)
    String text;

    public Answer(){};

    public Answer(Question question, String answer) {
        this.question = question;
        this.text = text;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
