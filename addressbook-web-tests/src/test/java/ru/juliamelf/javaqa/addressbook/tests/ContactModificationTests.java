package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by korotkova on 6/3/2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if(!app.getContactHelper().isContactExists()) {
            app.getContactHelper().createContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "Company", "Arbat, 1", "test group"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(0);
        app.getContactHelper().fillContactForm(new ContactData("Petr", "Petrovich", "Petrov", "Petrov Company", "Lenina, 1", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }
}
