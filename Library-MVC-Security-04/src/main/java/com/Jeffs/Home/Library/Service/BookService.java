package com.Jeffs.Home.Library.Service;

import com.Jeffs.Home.Library.Entity.Book;
import com.Jeffs.Home.Library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //find all books
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    //find book by id
    public Book findBookById(int bookID){
        Optional<Book> result = bookRepository.findById(bookID);
        Book book = null;
        //if value is present that we can retrieve
        if(result.isPresent()){
            book = result.get();
        } else {
            //we didn't find the book
            throw new RuntimeException("Did not find the book id: " + bookID);
        }
        return book;
    }

    //save book
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    //delete book
    public void deleteBookById(int bookID) {
        if (!bookRepository.existsById(bookID)) {
            throw new RuntimeException("Did not find book id: " + bookID);
        }
        bookRepository.deleteById(bookID);
    }
}
