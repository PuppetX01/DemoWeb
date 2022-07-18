package com.test.demoweb.controller;

import com.test.demoweb.dto.BasicResponse;
import com.test.demoweb.dto.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.RemoteEndpoint;

@RestController
public class BookController {

    @GetMapping("/books")
    public Book getBook(){
        Book book = new Book();
        //book.setId(1);
        //book.setName("Ghost");
        return book;
    }

    @GetMapping("/basic")
    public BasicResponse getBasic(){
        BasicResponse basic = new BasicResponse();
        //book.setId(1);
        //book.setName("Ghost");
        return basic;
    }



}
