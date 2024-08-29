package com.Jeffs.Home.Library.Entity;

import jakarta.persistence.*;

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
