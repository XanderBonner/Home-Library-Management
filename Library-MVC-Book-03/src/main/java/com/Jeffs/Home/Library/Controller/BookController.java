package com.Jeffs.Home.Library.Controller;

import com.Jeffs.Home.Library.Entity.Book;
import com.Jeffs.Home.Library.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api") //base mapping
public class BookController {

    private final BookService bookService;

    //Constructor injection for Service
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //GET Mapping for return a "list"
    @GetMapping("/books")
    public String findAllBooks(Model theModel){

        //get books from the db
        List<Book> theBooks = bookService.findAllBooks();
        //add to the spring model
        theModel.addAttribute("books", theBooks);

        return "Book/list-books"; //Since we are using Thymeleaf this will send it to the html page. Need to look into Book directory in templates.
    }

    //GET Request for CREATING a book
    @GetMapping("/books/showBookFormForAdd")
    public String showBookFormForAdd(Model theModel){

        //create model attribute to bind form data
        Book theBook = new Book();

        theModel.addAttribute("book", theBook);

        return "Book/book-form";
    }

    //GET Request, for updating a book
    @GetMapping("books/showBookFormForUpdate")
    public String showBookFormForUpdate(@RequestParam("bookID") int theID, Model theModel){

        //get the book from the service
        Book theBook = bookService.findBookById(theID);
        //set book in the model to prepopulate the form
        theModel.addAttribute("book", theBook);
        //send over to our updateform
        return "Book/book-form";
    }

    //POST Request, CREATE a new book
    @PostMapping("/books/save")
    public String addBook(@ModelAttribute("book") Book theBook) { //we know the request body will bind the JSON to the given book object

        //save the book
        bookService.saveBook(theBook);

        //use a redirect to prevent duplicate submissions
        return "redirect:/api/books";
    }


    //DELETE Request, will delete an existing book
    @GetMapping("/books/deleteBook")
    public String deleteBook(@RequestParam("bookID") int theID){

        //delete the book
        bookService.deleteBookById(theID);

        //redirect to books url
        return "redirect:/api/books";
    }
}
