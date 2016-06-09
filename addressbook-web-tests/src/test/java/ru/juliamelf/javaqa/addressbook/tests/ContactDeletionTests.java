package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.ContactData;

/**
 * Created by korotkova on 6/3/2016.
 */
public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        if(!app.getContactHelper().isContactExists()) {
            app.getContactHelper().createContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "Company", "Arbat, 1", "test group"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDeletion();
        app.getNavigationHelper().gotoHomePage();
    }
}
