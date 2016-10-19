package com.theironyard.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="forms")
public class Form {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String name;

    @Column(nullable = false, length = 1000)
    String description;

    @OneToMany
    List<Question> questions;

    public Form(){}

    public Form(String title, String name, String description, List<Question> questions) {
        this.title = title;
        this.name = name;
        this.description = description;
        this.questions = questions;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
