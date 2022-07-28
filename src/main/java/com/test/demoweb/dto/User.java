package com.test.demoweb.dto;

public class User {

    private Integer id;
    private String name;
    private String last_name;
    private String email;
    private String password;
    private String type;
    private String address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id
                = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name
                = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email
                = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
