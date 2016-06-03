package ru.juliamelf.javaqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.appmanager.AnniversaryData;
import ru.juliamelf.javaqa.addressbook.appmanager.BirthdayData;
import ru.juliamelf.javaqa.addressbook.model.EmailData;
import ru.juliamelf.javaqa.addressbook.model.PhoneData;
import ru.juliamelf.javaqa.addressbook.model.UserNameData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactAdd();
        app.getContactHelper().fillNameData(new UserNameData("Ivan", "Ivanovich", "Ivanov", "ivan", "Mister"));
        app.getContactHelper().fillCompanyData("Company");
        app.getContactHelper().fillFirstAddressData("Arbat, 1");
        app.getContactHelper().fillFirstPhoneData(new PhoneData("84991234578", "89627894512", "84996325878", "84996325877"));
        app.getContactHelper().fillEmailData(new EmailData("ivan@company.ru", "ivan2@company.ru", "ivan3@company.ru"));
        app.getContactHelper().fillHomepageData("ivan.ru");
        app.getContactHelper().fillBirthdayData(new BirthdayData("1995", By.xpath("//select[@name='bday']//option[10]"), By.xpath("//select[@name='bmonth']//option[10]")));
        app.getContactHelper().fillAnniversaryData(new AnniversaryData("2015", By.xpath("//select[@name='bday']//option[10]"), By.xpath("//select[@name='bmonth']//option[10]")));
        app.getContactHelper().fillGroupData(By.xpath("//select[@name='new_group']/option[2]"));
        app.getContactHelper().fillSecondAddressData("Street name, 222");
        app.getContactHelper().fillSecondPhoneData("84951232323");
        app.getContactHelper().fillNotesData("comments");
        app.getContactHelper().submitContactAdd();
        app.getNavigationHelper().gotoHomePage();
    }

}
