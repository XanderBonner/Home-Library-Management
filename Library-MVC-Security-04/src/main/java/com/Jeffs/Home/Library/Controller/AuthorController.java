package com.Jeffs.Home.Library.Controller;

import com.Jeffs.Home.Library.Entity.Author;
import com.Jeffs.Home.Library.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api") //base mapping
public class AuthorController {

    private final AuthorService authorService;

    //Constructor injection for Service
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    //GET Mapping for return a "list"
    @GetMapping("/authors")
    public String findAllAuthors(Model theModel){

        //get authors from the db
        List<Author> theAuthors = authorService.findAllAuthors();
        //add to the spring model
        theModel.addAttribute("author", theAuthors);

        return "Author/list-authors"; //Since we are using Thymeleaf this will send it to the html page. Need to look into Author directory in templates.
    }

    //GET Request for CREATING an author
    @GetMapping("/authors/showAuthorFormForAdd")
    public String showAuthorFormForAdd(Model theModel){

        //create model attribute to bind form data
        Author theAuthor = new Author();

        theModel.addAttribute("author", theAuthor);

        return "Author/author-form";
    }

    //GET Request, for updating an author
    @GetMapping("authors/showAuthorFormForUpdate")
    public String showAuthorFormForUpdate(@RequestParam("authorID") int theID, Model theModel){

        //get the author from the service
        Author theAuthor = authorService.findAuthorById(theID);
        //set author in the model to prepopulate the form
        theModel.addAttribute("author", theAuthor);
        //send over to our updateform
        return "Author/author-form";
    }

    //return an author by id
//    @GetMapping("/authors/{authorID}")
//    public Author getAuthor(@PathVariable int authorID){
//        Author author = authorService.findAuthorById(authorID);
//        //if author is null than author did not exist
//        if(author == null){
//            throw new EntityNotFoundException("Author id not found: " + authorID);
//        }
//        return author;
//    }

    //POST Request, CREATE a new author
    @PostMapping("/authors/save")
    public String addAuthor(@ModelAttribute("author") Author theAuthor) { //we know the request body will bind the JSON to the given author object

        //save the author
        authorService.saveAuthor(theAuthor);

        //use a redirect to prevent duplicate submissions
        return "redirect:/api/authors";
    }


    //DELETE Request, will delete an existing author
    @GetMapping("/authors/deleteAuthor")
    public String deleteAuthor(@RequestParam("authorID") int theID){

        //delete the author
        authorService.deleteAuthorById(theID);

        //redirect to authors url
        return "redirect:/api/authors";
    }
}
