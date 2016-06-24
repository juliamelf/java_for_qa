package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by korotkova on 6/3/2016.
 */
public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Ivan").withMiddleName("Ivanovich").withLastName("Ivanov")
                    .withCompany("Company").withFirstAddress("Arbat, 1").withGroup("test group"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(after, before);
    }

}
