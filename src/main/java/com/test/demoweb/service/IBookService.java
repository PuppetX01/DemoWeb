package com.test.demoweb.service;

import com.test.demoweb.dto.BasicResponse;
import com.test.demoweb.dto.Book;

import java.util.List;

public interface IBookService {

    public List<Book> getListBooks() throws Exception;

    public Book getBookById(Integer id) throws Exception;

    public BasicResponse addBook(Book book) throws Exception;

    public BasicResponse updateBook(Integer id, Book book) throws Exception;

    public BasicResponse deleteBooks(Integer id) throws Exception;

}
