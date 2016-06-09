package ru.juliamelf.javaqa.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String company;
    private final String firstAddress;
    private String group;

    // private final String homepage;
   // private final String secondAddress;
   // private final String secondPhone;
   // private final String comments;

    public ContactData(String firstName, String middleName, String lastName, String company, String firstAddress, String group) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.company = company;
        this.firstAddress = firstAddress;
        //this.homepage = homepage;
        //this.secondAddress = secondAddress;
        //this.secondPhone = secondPhone;
        //this.comments = comments;
        this.group = group;
    }


    public String getFirstName() { return firstName; }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public String getGroup() { return group; }

    /*
    public String getHomepage() {
        return homepage;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public String getComments() {
        return comments;
    }

    */
}
