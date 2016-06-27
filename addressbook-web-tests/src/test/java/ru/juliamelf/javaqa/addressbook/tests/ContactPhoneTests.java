package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.ContactData;

/**
 * Created by Julia on 6/27/2016.
 */
public class ContactPhoneTests extends TestBase {

    @Test(enabled = false)
    public void testContactPhones() {
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();

    }
}
