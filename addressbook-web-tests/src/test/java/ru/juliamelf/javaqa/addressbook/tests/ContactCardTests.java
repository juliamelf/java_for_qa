package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Julia on 6/28/2016.
 */
public class ContactCardTests extends  TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.db().contacts().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("Ivan").withMiddleName("Ivanovich").withLastName("Ivanov")
                    .withCompany("Company").withFirstAddress("Arbat, 1").withGroup("test group"), true);
        }
    }

    @Test
    public void testContactCard() {
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromCardForm = app.contact().infoFromCardForm(contact);
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(cleaned(contactInfoFromCardForm.getAllData()), equalTo((merged(contactInfoFromEditForm))));
    }

    public String merged (ContactData contact) {
        return Arrays.asList(
                contact.getFirstName(), contact.getMiddleName(), contact.getLastName(),
                contact.getCompany(), contact.getFirstAddress(),
                contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
                contact.getFirstEmail(), contact.getSecondEmail(), contact.getThirdEmail())
                .stream()
                .map(ContactCardTests::cleaned)
                .collect(Collectors.joining(""));
    }

    public static String cleaned(String contactData) {
        return contactData
                .replaceAll("H:", "").replaceAll("M:", "").replaceAll("W:", "")
                .replaceAll("(www.email.com)", "").replaceAll("[()]", "")
                .replaceAll("\n", "").replaceAll("\\s", "");
    }
}
