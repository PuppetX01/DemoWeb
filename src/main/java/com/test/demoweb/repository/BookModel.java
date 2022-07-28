package com.test.demoweb.repository;

import javax.persistence.*;

@Entity
public class BookModel {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "edition")
    private String edition;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;

    //id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    //code
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    //title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //author
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    //edition
    public String getEdition() {
        return edition;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }

    //description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //image
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

}
