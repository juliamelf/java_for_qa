package ru.juliamelf.javaqa.addressbook.model;

import org.openqa.selenium.By;

public class ContactData {
    private final String company;
    private final String firstAddress;
    private final String homepage;
    private final By groupName;
    private final String secondAddress;
    private final String secondPhone;
    private final String comments;

    public ContactData(String company, String firstAddress, String homepage, By groupName, String secondAddress, String secondPhone, String comments) {
        this.company = company;
        this.firstAddress = firstAddress;
        this.homepage = homepage;
        this.groupName = groupName;
        this.secondAddress = secondAddress;
        this.secondPhone = secondPhone;
        this.comments = comments;
    }

    public String getCompany() {
        return company;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public String getHomepage() {
        return homepage;
    }

    public By getGroupName() {
        return groupName;
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
}
