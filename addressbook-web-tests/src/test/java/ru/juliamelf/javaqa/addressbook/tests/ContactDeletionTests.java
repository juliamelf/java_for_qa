package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by korotkova on 6/3/2016.
 */
public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().initContactDeletion();
        app.getNavigationHelper().gotoHomePage();
    }
}
