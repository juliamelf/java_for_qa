package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.ContactData;
import ru.juliamelf.javaqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("Ivan").withMiddleName("Ivanovich").withLastName("Ivanov")
                .withCompany("Company").withFirstAddress("Arbat, 1").withGroup("new test group")
                .withHomePhone("+7(495)4271112").withMobilePhone("7-962-995-44-55").withWorkPhone("499 456 23 12")
                .withFirstEmail("first@email.com").withSecondEmail("second@email.com").withThirdEmail("third@email.com");
        app.contact().create(contact, true);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }

    @Test
    public void testBadContactCreation() {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstName("Ivan'").withMiddleName("Ivanovich").withLastName("Ivanov")
                .withCompany("Company").withFirstAddress("Arbat, 1").withGroup("new test group");
        app.contact().create(contact, true);
        assertThat(app.contact().getContactCount(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

}
