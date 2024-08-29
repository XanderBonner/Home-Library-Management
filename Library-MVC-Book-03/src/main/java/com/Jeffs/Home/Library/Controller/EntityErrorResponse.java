package com.Jeffs.Home.Library.Controller;

public class EntityErrorResponse {

    //pojo

    //instance variables
    private int status;
    private String message;
    private long timeStamp;

    //need constructor with no args
    public EntityErrorResponse(){
    }

    //constructor with args
    public EntityErrorResponse(int stauts, String message, long timeStamp) {
        this.status = stauts;
        this.message = message;
        this.timeStamp = timeStamp;
    }
    //need getter and setters

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
