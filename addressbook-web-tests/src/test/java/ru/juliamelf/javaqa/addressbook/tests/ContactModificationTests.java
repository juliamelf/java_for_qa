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
            app.contact().create(new ContactData("Ivan", "Ivanovich", "Ivanov", "Company", "Arbat, 1", "test group"), true);
        }
    }

    @Test
    public void testContactModification() {

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(), "Alex", "Alexandrovich", "Alexandrov", "Alex Company", "Lenina, 1", null);
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
