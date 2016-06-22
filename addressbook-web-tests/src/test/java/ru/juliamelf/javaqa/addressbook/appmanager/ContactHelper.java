package ru.juliamelf.javaqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.juliamelf.javaqa.addressbook.model.*;

import java.util.ArrayList;
import java.util.List;

import static ru.juliamelf.javaqa.addressbook.tests.TestBase.app;

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

    public void initContactModification(int index) {
        wd.findElements(By.xpath("//a[contains(@href, 'edit.php?id')]")).get(index).click();
    }

    public void submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
    }

    public void initContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void selectContact(int index) {
        wd.findElements(By.xpath("//input[contains(@title, 'Select')]")).get(index).click();
    }

    public boolean isContactExists() {
        return isElementPresent(By.xpath("//input[contains(@title, 'Select')]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getFirstAddress());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void create(ContactData contactData, boolean creation) {
        app.goTo().ContactAdd();
        fillContactForm(contactData, creation);
        submitContactAdd();
        app.goTo().HomePage();
    }

    public void modify(ContactData contact, int index) {
        initContactModification(index);
        fillContactForm(contact, false);
        submitContactModification();
        app.goTo().HomePage();
    }

    public void delete(int index) {
        selectContact(index);
        initContactDeletion();
        app.goTo().HomePage();
    }

    public int getContactCount() {
        return wd.findElements(By.xpath("//input[contains(@title, 'Select')]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for(WebElement element: elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String firstAddress = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
            ContactData contact = new ContactData(id, firstName, null, lastName, null, firstAddress, null);
            contacts.add(contact);
        }
        return contacts;
    }

    /* OLD METHODS
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

     */
}
