package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by korotkova on 6/3/2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Ivan").withMiddleName("Ivanovich").withLastName("Ivanov")
                    .withCompany("Company").withFirstAddress("Arbat, 1").withGroup("test group"), true);
        }
    }

    @Test
    public void testContactModification() {

        Set<ContactData> before = app.contact().all();
        ContactData modifiedGroup = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedGroup.getId())
                .withFirstName("Alex").withMiddleName("Alexandrovich").withLastName("Alexandrov")
                .withCompany("Alex Company").withFirstAddress("Lenina, 1");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);
        before.add(contact);
        Assert.assertEquals(before, after);

    }


}
