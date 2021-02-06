package com.example.sprink.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String title;

    private String content;

    public String idUser;

    public String color;

    public Nota(String title, String content, String idUser, String color) {
        this.title = title;
        this.content = content;
        this.idUser = idUser;
        this.color = color;
    }

    public Nota() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
