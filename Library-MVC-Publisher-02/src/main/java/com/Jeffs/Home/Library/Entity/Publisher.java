package com.Jeffs.Home.Library.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PublisherID")
    private int publisherID;

    @Column(name="Name")
    private String name;

    @Column(name="Address")
    private String address;

    @Column(name="Phone")
    private String phone;

    //Constructors
    //Jpa requires no parms constructor
    public Publisher(){}

    //with parms
    public Publisher(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    //define getter and setters
    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //publisher id
    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    //address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
