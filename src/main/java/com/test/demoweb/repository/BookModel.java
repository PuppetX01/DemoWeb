package com.test.demoweb.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
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

}