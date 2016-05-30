package ru.juliamelf.javaqa.addressbook;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class ContactCreationTests extends AddressbookTests {

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

    private void gotoHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    private void submitContactAdd() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillNotesData(String notes) {
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(notes);
    }

    private void fillSecondPhoneData(String secondPhone) {
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(secondPhone);
    }

    private void fillSecondAddressData(String secondAddress) {
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(secondAddress);
    }

    private void fillBirthdayData() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[20]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[20]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
        }
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys("1990");
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[21]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[21]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[2]")).click();
        }
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys("1990");
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).click();
        }
    }

    private void fillHomepageData(String homepage) {
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(homepage);
    }

    private void fillEmailData(EmailData emailData) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(emailData.getFirstEmail());
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(emailData.getSecondEmail());
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(emailData.getThirdEmail());
    }

    private void fillFirstPhoneData(PhoneData firstPhoneData) {
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(firstPhoneData.getHomeNumber());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(firstPhoneData.getMobileNumber());
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(firstPhoneData.getWorkNumber());
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(firstPhoneData.getFaxNumber());
    }

    private void fillFirstAddressData(String firstAddress) {
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(firstAddress);
    }

    private void fillCompanyData(String company) {
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(company);
    }

    private void fillNameData(UserNameData userNameData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(userNameData.getFirstName());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(userNameData.getMiddleName());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(userNameData.getLastName());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(userNameData.getNickname());
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(userNameData.getTitle());
    }

    private void gotoContactAdd() {
        wd.findElement(By.linkText("add new")).click();
    }

}
