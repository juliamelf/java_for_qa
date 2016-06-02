package ru.juliamelf.javaqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.juliamelf.javaqa.addressbook.model.EmailData;
import ru.juliamelf.javaqa.addressbook.model.PhoneData;
import ru.juliamelf.javaqa.addressbook.model.UserNameData;

/**
 * Created by korotkova on 6/2/2016.
 */
public class ContactHelper extends HelperBase{

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitContactAdd() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillNotesData(String notes) {
        type(By.name("notes"), notes);
    }

    public void fillSecondPhoneData(String secondPhone) {
        type(By.name("phone2"), secondPhone);
    }

    public void fillSecondAddressData(String secondAddress) {
        type(By.name("address2"), secondAddress);
    }

    public void fillBirthdayData() {
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

    }

    public void fillGroupData() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[5]//option[2]"));
        }
    }

    public void fillHomepageData(String homepage) {
        type(By.name("homepage"), homepage);
    }

    public void fillEmailData(EmailData emailData) {
        type(By.name("email"), emailData.getFirstEmail());
        type(By.name("email2"), emailData.getSecondEmail());
        type(By.name("email3"), emailData.getThirdEmail());
    }

    public void fillFirstPhoneData(PhoneData firstPhoneData) {
        type(By.name("home"), firstPhoneData.getHomeNumber());
        type(By.name("mobile"), firstPhoneData.getMobileNumber());
        type(By.name("work"), firstPhoneData.getWorkNumber());
        type(By.name("fax"), firstPhoneData.getFaxNumber());
    }

    public void fillFirstAddressData(String firstAddress) {
       type(By.name("address"), firstAddress);
    }

    public void fillCompanyData(String company) {
        type(By.name("company"), company);
    }

    public void fillNameData(UserNameData userNameData) {
        type(By.name("firstname"), userNameData.getFirstName());
        type(By.name("middlename"), userNameData.getMiddleName());
        type(By.name("lastname"), userNameData.getLastName());
        type(By.name("nickname"), userNameData.getNickname());
        type(By.name("title"), userNameData.getTitle());
    }
}
