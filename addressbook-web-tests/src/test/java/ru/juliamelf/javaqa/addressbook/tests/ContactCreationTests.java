package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.EmailData;
import ru.juliamelf.javaqa.addressbook.model.PhoneData;
import ru.juliamelf.javaqa.addressbook.model.UserNameData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.gotoContactAdd();
        app.fillNameData(new UserNameData("Ivan", "Ivanovich", "Ivanov", "ivan", "Mister"));
        app.fillCompanyData("Company");
        app.fillFirstAddressData("Arbat, 1");
        app.fillFirstPhoneData(new PhoneData("84991234578", "89627894512", "84996325878", "84996325877"));
        app.fillEmailData(new EmailData("ivan@company.ru", "ivan2@company.ru", "ivan3@company.ru"));
        app.fillHomepageData("ivan.ru");
        app.fillBirthdayData();
        app.fillSecondAddressData("Street name, 222");
        app.fillSecondPhoneData("84951232323");
        app.fillNotesData("comments");
        app.submitContactAdd();
        app.gotoHomePage();
    }

}
