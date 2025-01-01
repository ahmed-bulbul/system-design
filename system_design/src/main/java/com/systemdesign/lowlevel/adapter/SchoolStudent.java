package com.systemdesign.lowlevel.adapter;

public class SchoolStudent {
    private String firstName;
    private String lastName;
    private String emailAddress;

    public SchoolStudent(String name, String surname, String email) {
        this.firstName = name;
        this.lastName = surname;
        this.emailAddress = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
