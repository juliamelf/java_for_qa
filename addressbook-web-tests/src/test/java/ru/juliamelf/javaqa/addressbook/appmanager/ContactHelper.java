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

    public void fillBirthdayData(BirthdayData birthdayData) {
        if (!wd.findElement(birthdayData.getBday()).isSelected()) {
            wd.findElement(birthdayData.getBday()).click();
        }
        if (!wd.findElement(birthdayData.getBmonth()).isSelected()) {
            wd.findElement(birthdayData.getBmonth()).click();
        }
        type(By.name("byear"), birthdayData.getByear());
    }

    public void fillAnniversaryData(AnniversaryData anniversaryData) {
        if (!wd.findElement(anniversaryData.getAday()).isSelected()) {
            wd.findElement(anniversaryData.getAday()).click();
        }
        if (!wd.findElement(anniversaryData.getAmonth()).isSelected()) {
            wd.findElement(anniversaryData.getAmonth()).click();
        }
        type(By.name("ayear"), anniversaryData.getAyear());

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

    public void initContactModification() {
        click(By.xpath("//a[@href='edit.php?id=2']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }
}
