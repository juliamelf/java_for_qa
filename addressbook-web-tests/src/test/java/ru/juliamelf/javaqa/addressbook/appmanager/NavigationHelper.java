package ru.juliamelf.javaqa.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by korotkova on 6/2/2016.
 */
public class NavigationHelper {

    private final BaseHelper baseHelper;

    public NavigationHelper(FirefoxDriver wd) {

        baseHelper = new BaseHelper(wd);
    }

    public void gotoGroupPage() {
        baseHelper.openGroupsPage();
    }

    public void gotoHomePage() {
        baseHelper.openHomePage();
    }

    public void gotoContactAdd() {
        baseHelper.openAddContactPage();
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }
}
