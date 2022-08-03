package com.test.demoweb.dto;

public class Loan {

    private Integer id, user, id_user, id_book;

    private String status, book, date, update_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_book() {
        return id_book;
    }

    public void setId_book(Integer id_book) {
        this.id_book = id_book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }
}