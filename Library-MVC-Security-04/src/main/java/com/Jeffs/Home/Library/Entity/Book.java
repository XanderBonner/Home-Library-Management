package com.Jeffs.Home.Library.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {

    //define instance fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID")
    private int bookID;

    @Column(name = "Title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "author_ID")
    private Author author;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "publisher_ID")
    private Publisher publisher;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "Bookcategory")
    private String bookCategory;

    //Constructors
    //no param constructor is required by Jpa
    public Book(){}

    //with params
    public Book(String title, String isbn, Integer publicationYear, String bookCategory) {
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.bookCategory = bookCategory;
    }

    //getter and setters
    //ID
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    //Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //Author
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    //Publisher
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    //ISBN
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //Pubyear
    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    //category
    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }
}
