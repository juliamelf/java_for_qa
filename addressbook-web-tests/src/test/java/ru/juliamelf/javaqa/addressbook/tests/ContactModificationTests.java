package ru.juliamelf.javaqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.AnniversaryData;
import ru.juliamelf.javaqa.addressbook.model.BirthdayData;
import ru.juliamelf.javaqa.addressbook.model.EmailData;
import ru.juliamelf.javaqa.addressbook.model.PhoneData;
import ru.juliamelf.javaqa.addressbook.model.UserNameData;

/**
 * Created by korotkova on 6/3/2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillNameData(new UserNameData("Petr", "Petrovich", "Petrov", "petr", "Sir"));
        app.getContactHelper().fillCompanyData("Petrov Company");
        app.getContactHelper().fillFirstAddressData("Arbat, 123");
        app.getContactHelper().fillFirstPhoneData(new PhoneData("84997778899", "89628889966", "84991112233", "84991112222"));
        app.getContactHelper().fillEmailData(new EmailData("petr@company.ru", "petr2@company.ru", "petr3@company.ru"));
        app.getContactHelper().fillHomepageData("petr.ru");
        app.getContactHelper().fillBirthdayData(new BirthdayData("1995", By.xpath("//select[@name='bday']//option[20]"), By.xpath("//select[@name='bmonth']//option[5]")));
        app.getContactHelper().fillAnniversaryData(new AnniversaryData("2015", By.xpath("//select[@name='aday']//option[20]"), By.xpath("//select[@name='amonth']//option[5]")));
        app.getContactHelper().fillSecondAddressData("New Street name, 222");
        app.getContactHelper().fillSecondPhoneData("84957774411");
        app.getContactHelper().fillNotesData("new comments");
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }
}
