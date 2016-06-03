package ru.juliamelf.javaqa.addressbook.model;

import org.openqa.selenium.By;

public class AnniversaryData {
    private final String ayear;
    private final By aday;
    private final By amonth;

    public AnniversaryData(String ayear, By aday, By amonth) {
        this.ayear = ayear;
        this.aday = aday;
        this.amonth = amonth;
    }

    public String getAyear() {
        return ayear;
    }

    public By getAday() {
        return aday;
    }

    public By getAmonth() {
        return amonth;
    }
}
