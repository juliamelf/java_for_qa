package ru.juliamelf.javaqa.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.juliamelf.javaqa.mantis.appmanager.ApplicationManager;

/**
 * Created by korotkova on 5/30/2016.
 */
public class TestBase {

    public final static ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}
