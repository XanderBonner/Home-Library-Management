package com.Jeffs.Home.Library.Service;

import com.Jeffs.Home.Library.Entity.Author;
import com.Jeffs.Home.Library.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //find all authors
    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    //find author by id
    public Author findAuthorById(int authorID){
        Optional<Author> result = authorRepository.findById(authorID);
        Author author = null;
        //if value is present that we can retrieve
        if(result.isPresent()){
            author = result.get();
        } else {
            //we didn't find the author
            throw new RuntimeException("Did not find the employee id: " + authorID);
        }
        return author;
    }

    //save author
    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }

    //delete author
    public void deleteAuthorById(int authorID) {
        if (!authorRepository.existsById(authorID)) {
            throw new RuntimeException("Did not find author id: " + authorID);
        }
        authorRepository.deleteById(authorID);
    }
}
