package com.test.demoweb.controller;

import com.test.demoweb.dto.BasicResponse;
import com.test.demoweb.dto.Book;
import com.test.demoweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){

        try{
            List<Book> books = bookService.getListBooks();
            return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404",e);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) throws ResponseStatusException {

        try{
            Book book = bookService.getBookById(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }catch (Exception e){
            if (e.getMessage().equals("Book not found")){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
            }else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error",e);
            }
        }
    }

    @PostMapping("/books")
    public ResponseEntity<BasicResponse> addBook(@RequestBody Book newBook){

        try {
            BasicResponse ms = bookService.addBook(newBook);
            return new ResponseEntity<BasicResponse>(ms,HttpStatus.CREATED);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error",e);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BasicResponse> updateBook(@PathVariable("id") Integer id, @RequestBody Book newBook){

        try {
            BasicResponse ms = bookService.updateBook(id, newBook);
            return new ResponseEntity<BasicResponse>(ms,HttpStatus.OK);
        }catch (Exception e){
            if (e.getMessage().equals("Book not found")){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
            }else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error",e);
            }
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<BasicResponse> deleteBook(@PathVariable(value = "id") int id) {

        try{
            BasicResponse books = bookService.deleteBooks(id);
            return new ResponseEntity<BasicResponse>(books,HttpStatus.OK);
        }catch (Exception e){
            if (e.getMessage().equals("Book not found")){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
            }else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error",e);
            }
        }
    }


    public List<Book> getListBooks(){
        List<Book> books = new ArrayList<>();

            Book libro1 = new Book();
            Book libro2 = new Book();

            books.add(libro1);
            books.add(libro2);

            libro1.setId(1);
            libro1.setCode("111");
            libro1.setTitle("Ghost");
            libro1.setAuthor("Mathiaz");
            libro1.setEdition("2");
            libro1.setDescription("Ta chido");
            libro1.setImage("Url.com");

            libro2.setId(2);
            libro2.setCode("222");
            libro2.setTitle("Girl");
            libro2.setAuthor("Malzieu");
            libro2.setEdition("3");
            libro2.setDescription("Ta chido x2");
            libro2.setImage("Url.com");

        return books;
    }

    public int numero(){
        int num = 1;
        return num;
    }

    public String nombre(){
        String nom = "Hol";
        return nom;
    }

    @GetMapping("/basic")
    public BasicResponse getBasic(){
        BasicResponse basic = new BasicResponse();
        //book.setId(1);
        //book.setName("Ghost");
        return basic;
    }

}
