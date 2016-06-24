package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

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

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData().withId(before.get(index).getId())
                .withFirstName("Alex").withMiddleName("Alexandrovich").withLastName("Alexandrov")
                .withCompany("Alex Company").withFirstAddress("Lenina, 1");
        app.contact().modify(contact, index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> ById = ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);

    }


}
