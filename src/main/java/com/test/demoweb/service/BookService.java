package com.test.demoweb.service;

import com.test.demoweb.dto.BasicResponse;
import com.test.demoweb.dto.Book;
import com.test.demoweb.repository.BookModel;
import com.test.demoweb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookService implements IBookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getListBooks() throws Exception {
        //List<BookModel> booksModels = bookRepository.findAll();
        //System.out.println(booksModels);
        List<Book> books = getBooks();
        return books;
    }

    @Override
    public Book getBookById(Integer id) throws Exception {
        for (Book book: getBooks()){
            if (id==book.getId()){
                return book;
            }
        }
        throw new Exception("Book not found");
    }

    @Override
    public BasicResponse addBook(Book book) throws Exception {
        List<Book> books = getBooks();

        System.out.println(books);
        books.add(book);
        System.out.println(books);

        BasicResponse ms = new BasicResponse();
        ms.setMessage("Libro agregado");
        return ms;
    }

    @Override
    public BasicResponse updateBook(Integer id, Book book) throws Exception {
        List<Book> books = getBooks();

        int index = -1;
        for (int i = 0; i < books.size() ; i++){
            if (id==books.get(i).getId()) {
                index = i;
                break;
            }
        }

        if (index == -1){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book Not Found");
        }

        books.remove(index);
        books.add(book);

        BasicResponse ms = new BasicResponse();
        ms.setMessage("Libro actualizado");
        return ms;
    }

    @Override
    public BasicResponse deleteBooks(Integer id) throws Exception {
        List<Book> books = getBooks();

        System.out.println(books);
        int index = -1;
        for (int i = 0; i < books.size() ; i++){
            if (id==books.get(i).getId()) {
                index = i;
                break;
            }
        }

        if (index == -1){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book Not Found");
        }
        books.remove(index);

        System.out.println(books);

        BasicResponse ms = new BasicResponse();
        ms.setMessage("Libro borrado");
        return ms;
    }



    private List<Book> getBooks(){
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
}
