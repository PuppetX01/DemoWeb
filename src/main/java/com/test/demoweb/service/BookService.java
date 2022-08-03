package com.test.demoweb.service;

import com.test.demoweb.dto.BasicResponse;
import com.test.demoweb.dto.Book;
import com.test.demoweb.repository.BookModel;
import com.test.demoweb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RestController
public class BookService implements IBookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getListBooks() throws Exception {
        List<BookModel> booksModels = bookRepository.findAll();
        List<Book> books = new ArrayList<>();
        for (BookModel bookModel:booksModels) {
            Book newBook = convertModelToDTO(bookModel);
            books.add(newBook);
        }
        return books;
    }

    @Override
    public Book getBookById(Integer id) throws Exception {
        Optional<BookModel> bookModel = bookRepository.findById(id);

        if (!bookModel.isPresent()){
             throw new Exception("Book not found");
        }

        BookModel temp = bookRepository.findByTitleAndCode("Juego de tronos","1234");
        System.out.println(temp);

        Book book = convertModelToDTO(bookModel.get());
        return book;
    }

    @Override
    public BasicResponse addBook(Book book) throws Exception {
        BookModel newBookModel = convertDTOtoModel(book);
        BookModel bookSave;

        try {
            bookSave = bookRepository.save(newBookModel);
            BasicResponse ms = new BasicResponse();
            ms.setMessage("Libro agregado con id: "+bookSave.getId());
            return ms;
        }catch (Exception e){
            throw new Exception("Book not save");
        }
    }

    @Override
    public BasicResponse updateBook(Integer id, Book book) throws Exception {
        Optional<BookModel> bookModel = bookRepository.findById(id);

        if (!bookModel.isPresent()){
            throw new Exception("Book not found");
        }

        BookModel newBook = bookModel.get();
        newBook.setCode(book.getCode());
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        newBook.setEdition(book.getEdition());
        newBook.setDescription(book.getDescription());
        newBook.setImage(book.getImage());

        BookModel bookSave;

        try {
            bookSave = bookRepository.save(newBook);
            BasicResponse ms = new BasicResponse();
            ms.setMessage("Libro actualizado con id: "+bookSave.getId());
            return ms;
        }catch (Exception e){
            throw new Exception("Book no actualizado");
        }
    }

    @Override
    public BasicResponse deleteBooks(Integer id) throws Exception {
        Optional<BookModel> bookModel = bookRepository.findById(id);

        if (!bookModel.isPresent()){
            throw new Exception("Book not found");
        }

        try {
            bookRepository.deleteById(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al borrar");
        }

        BasicResponse ms = new BasicResponse();
        ms.setMessage("Libro borrado");
        return ms;
    }

    private Book convertModelToDTO(BookModel bookModel){

        Book book = new Book();
        book.setId(bookModel.getId());
        book.setCode(bookModel.getCode());
        book.setTitle(bookModel.getTitle());
        book.setAuthor(bookModel.getAuthor());
        book.setEdition(bookModel.getEdition());
        book.setDescription(bookModel.getDescription());
        book.setImage(bookModel.getImage());

        return book;
    }

    private BookModel convertDTOtoModel(Book book){

        BookModel bookModel = new BookModel();

        bookModel.setCode(book.getCode());
        bookModel.setTitle(book.getTitle());
        bookModel.setAuthor(book.getAuthor());
        bookModel.setEdition(book.getEdition());
        bookModel.setDescription(book.getDescription());
        bookModel.setImage(book.getImage());

        return bookModel;

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
