package com.test.demoweb.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loan_applications")
public class LoanModel {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name = "user")
    private Integer user;
    @Column(name = "id_user")
    private Integer id_user;
    @Column(name = "id_book")
    private Integer id_book;
    @Column(name = "status")
    private String status;
    @Column(name = "book")
    private String book;
    @Column(name = "date")
    private String date;
    @Column(name = "update_date")
    private String update_date;

}