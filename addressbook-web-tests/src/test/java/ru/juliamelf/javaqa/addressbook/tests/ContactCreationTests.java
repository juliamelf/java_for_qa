package ru.juliamelf.javaqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        app.getContactHelper().createContact(new UserNameData("Ivan", "Ivanovich", "Ivanov", "ivan", "Mister"),
                new PhoneData("84991234578", "89627894512", "84996325878", "84996325877"),
                new EmailData("ivan@company.ru", "ivan2@company.ru", "ivan3@company.ru"),
                new BirthdayData("1995", By.xpath("//select[@name='bday']//option[10]"), By.xpath("//select[@name='bmonth']//option[10]")),
                new AnniversaryData("2015", By.xpath("//select[@name='aday']//option[10]"), By.xpath("//select[@name='amonth']//option[10]")),
                new ContactData("Company", "Arbat, 1", "ivan.ru", By.xpath("//select[@name='new_group']/option[1]"), "Street name, 222",
                        "84951232323", "comments"));

    }

}
