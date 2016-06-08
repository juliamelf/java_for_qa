package ru.juliamelf.javaqa.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.juliamelf.javaqa.addressbook.appmanager.ApplicationManager;

/**
 * Created by korotkova on 5/30/2016.
 */
public class TestBase {

    public final static ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }


}
