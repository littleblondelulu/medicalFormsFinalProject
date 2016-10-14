package com.theironyard.entities;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    int questionId;

    @Column(nullable = false)
    String answer;

    public Answer(){};

    public Answer(int questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswerResponse() {
        return this.answer;
    }

    public void setAnswerResponse(String answerResponse) {
        this.answer = answer;
    }
}
