package ru.juliamelf.javaqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.*;

/**
 * Created by korotkova on 6/3/2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if(!app.getContactHelper().isContactExists()) {
            app.getContactHelper().createContact(new UserNameData("Ivan", "Petrovich", "Sidorov", "ips", "Senior"),
                                                 new PhoneData("84991118822", "89622229955", "84999992211", "84997892345"),
                                                 new EmailData("sidorov@company.ru", "sidorov2@company.ru", "sidorov3@company.ru"),
                                                 new BirthdayData("1945", By.xpath("//select[@name='bday']//option[19]"), By.xpath("//select[@name='bmonth']//option[4]")),
                                                 new AnniversaryData("2005", By.xpath("//select[@name='aday']//option[19]"), By.xpath("//select[@name='amonth']//option[4]")),
                                                 new ContactData("Sidorov Company", "Lenina, 5", "sidorov.ru", By.xpath("//select[@name='new_group']/option[2]"), "Stalina, 222",
                                                                 "84957854444", "no comments"));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillNameData(new UserNameData("Petr", "Petrovich", "Petrov", "petr", "Sir"));
        app.getContactHelper().fillCompanyData("Petrov Company");
        app.getContactHelper().fillFirstAddressData("Arbat, 123");
        app.getContactHelper().fillFirstPhoneData(new PhoneData("84997778899", "89628889966", "84991112233", "84991112222"));
        app.getContactHelper().fillEmailData(new EmailData("petr@company.ru", "petr2@company.ru", "petr3@company.ru"));
        app.getContactHelper().fillHomepageData("petr.ru");
        app.getContactHelper().fillBirthdayData(new BirthdayData("1995", By.xpath("//select[@name='bday']//option[20]"), By.xpath("//select[@name='bmonth']//option[5]")));
        app.getContactHelper().fillAnniversaryData(new AnniversaryData("2015", By.xpath("//select[@name='aday']//option[20]"), By.xpath("//select[@name='amonth']//option[5]")));
        app.getContactHelper().fillGroupData(By.xpath("//select[@name='new_group']/option[2]"), false);
        app.getContactHelper().fillSecondAddressData("New Street name, 222");
        app.getContactHelper().fillSecondPhoneData("84957774411");
        app.getContactHelper().fillNotesData("new comments");
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }
}
