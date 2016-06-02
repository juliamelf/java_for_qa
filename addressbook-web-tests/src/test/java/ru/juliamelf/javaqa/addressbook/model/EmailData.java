package ru.juliamelf.javaqa.addressbook.model;

public class EmailData {
    private final String firstEmail;
    private final String secondEmail;
    private final String thirdEmail;

    public EmailData(String firstEmail, String secondEmail, String thirdEmail) {
        this.firstEmail = firstEmail;
        this.secondEmail = secondEmail;
        this.thirdEmail = thirdEmail;
    }

    public String getFirstEmail() {
        return firstEmail;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public String getThirdEmail() {
        return thirdEmail;
    }
}
