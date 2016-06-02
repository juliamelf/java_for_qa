package ru.juliamelf.javaqa.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.juliamelf.javaqa.addressbook.TestBase;

import static org.openqa.selenium.OutputType.*;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {

        gotoGroupPage();
        selectGroup();
        deleteGroup();
        returnToGroupPage();
    }


}
