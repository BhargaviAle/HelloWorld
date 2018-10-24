package com.example.saankhya.helloworldapp;

public class Contact {

    int id;
    String name;
    String password;
    String emailId;
    String mblNumber;

    public Contact()
    {

    }
    /*
     *Constructor overloading
     */
    public Contact(int id, String name, String password, String emailId, String mblNumber)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.emailId = emailId;
        this.mblNumber = mblNumber;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setMblNumber(String mblNumber) {
        this.mblNumber = mblNumber;
    }

    public String getMblNumber() {
        return mblNumber;
    }

}
