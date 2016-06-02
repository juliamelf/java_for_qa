package ru.juliamelf.javaqa.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by korotkova on 6/2/2016.
 */
public class SessionHelper {

    private final BaseHelper baseHelper;

    public SessionHelper(FirefoxDriver wd) {
        baseHelper = new BaseHelper(wd);
    }

    public void login(String username, String password) {
        baseHelper.openApplication();
        baseHelper.fillUserName(username);
        baseHelper.fillPassword(password);
        baseHelper.clickLoginButton();
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }
}
