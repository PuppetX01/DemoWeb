package com.test.demoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<BookModel, Integer> {

    public BookModel findByTitleAndCode(String title, String code);

}
