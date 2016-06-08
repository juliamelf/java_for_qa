package ru.juliamelf.javaqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.*;

/**
 * Created by korotkova on 6/3/2016.
 */
public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        if(!app.getContactHelper().isContactExists()) {
            app.getContactHelper().createContact(new UserNameData("Ivan", "Petrovich", "Sidorov", "ips", "Senior"),
                    new PhoneData("84991118822", "89622229955", "84999992211", "84997892345"),
                    new EmailData("sidorov@company.ru", "sidorov2@company.ru", "sidorov3@company.ru"),
                    new BirthdayData("1945", By.xpath("//select[@name='bday']//option[19]"), By.xpath("//select[@name='bmonth']//option[4]")),
                    new AnniversaryData("2005", By.xpath("//select[@name='aday']//option[19]"), By.xpath("//select[@name='amonth']//option[4]")),
                    new ContactData("Sidorov Company", "Lenina, 5", "sidorov.ru", By.xpath("//select[@name='new_group']/option[2]"), "Stalina, 222",
                            "84957854444", "no comments"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDeletion();
        app.getNavigationHelper().gotoHomePage();
    }
}
