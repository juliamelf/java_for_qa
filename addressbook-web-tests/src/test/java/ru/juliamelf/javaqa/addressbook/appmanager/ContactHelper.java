package ru.juliamelf.javaqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import ru.juliamelf.javaqa.addressbook.model.*;

/**
 * Created by korotkova on 6/2/2016.
 */
public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
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
        selectFromList(birthdayData.getBday());
        selectFromList(birthdayData.getBmonth());
        type(By.name("byear"), birthdayData.getByear());
    }

    public void fillAnniversaryData(AnniversaryData anniversaryData) {
        selectFromList(anniversaryData.getAday());
        selectFromList(anniversaryData.getAmonth());
        type(By.name("ayear"), anniversaryData.getAyear());

    }

    public void fillGroupData(By groupName, boolean creation) {
        if (creation) {
            selectFromList(groupName);
        } else {
            Assert.assertFalse(isElementPresent(groupName));
        }

        //selectFromList(groupName);
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
        click(By.xpath("//a[contains(@href, 'edit.php?id')]"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
    }

    public void initContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void selectContact() {
        click(By.xpath("//input[contains(@title, 'Select')]"));
    }

}
