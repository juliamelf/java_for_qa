package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.ContactData;
import ru.juliamelf.javaqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by korotkova on 6/3/2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Ivan").withMiddleName("Ivanovich").withLastName("Ivanov")
                    .withCompany("Company").withFirstAddress("Arbat, 1").withGroup("test group"), true);
        }
    }

    @Test
    public void testContactModification() {

        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId())
                .withFirstName("Petr").withMiddleName("Petrovich").withLastName("Petrov")
                .withCompany("Petr Company").withFirstAddress("Lesnaya, 1")
                .withHomePhone("123 123 456").withMobilePhone("+499 12345678").withWorkPhone("789451200");
        app.contact().modify(contact);
        assertThat(app.contact().getContactCount(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }

}
