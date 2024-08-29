package com.Jeffs.Home.Library.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="author")
public class Author {

    //define instance fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AuthorID")
    private int authorID;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @OneToMany(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                                                CascadeType.DETACH, CascadeType.REFRESH}) //mapped by field refers to "author" property in "Book" class
    private List<Book> books;

    //Constructors
    //Jpa requires no parms constructor
    public Author(){}

    //with parms
    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //define getter and setters
    //id
    public int getAuthorID(){ return authorID;}

    public void setAuthorID(int authorID){
        this.authorID = authorID;
    }

    //firstName
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    //lastName
    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    //Book
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    //convenience methods for bi-directional relationships
    public void add(Book tempBook){
        if(books == null){
            books = new ArrayList<>();
        }

        books.add(tempBook);
        tempBook.setAuthor(this);
    }


//    // define toString
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "authorID=" + authorID +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                '}';
//    }

}
