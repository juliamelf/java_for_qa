package ru.juliamelf.javaqa.addressbook.appmanager;

import org.openqa.selenium.By;

public class BirthdayData {
    private final String byear;
    private final By bday;
    private final By bmonth;

    public BirthdayData(String byear, By bday, By bmonth) {
        this.byear = byear;
        this.bday = bday;
        this.bmonth = bmonth;
    }

    public String getByear() {
        return byear;
    }

    public By getBday() {
        return bday;
    }

    public By getBmonth() {
        return bmonth;
    }
}
