package com.test.demoweb.dto;

public class Book {
    private Integer id;
    private String code, title, author, edition, description, image;

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
