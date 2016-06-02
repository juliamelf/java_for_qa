package ru.juliamelf.javaqa.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        gotoContactAdd();
        fillNameData(new UserNameData("Ivan", "Ivanovich", "Ivanov", "ivan", "Mister"));
        fillCompanyData("Company");
        fillFirstAddressData("Arbat, 1");
        fillFirstPhoneData(new PhoneData("84991234578", "89627894512", "84996325878", "84996325877"));
        fillEmailData(new EmailData("ivan@company.ru", "ivan2@company.ru", "ivan3@company.ru"));
        fillHomepageData("ivan.ru");
        fillBirthdayData();
        fillSecondAddressData("Street name, 222");
        fillSecondPhoneData("84951232323");
        fillNotesData("comments");
        submitContactAdd();
        gotoHomePage();
    }

}
