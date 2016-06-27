package ru.juliamelf.javaqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.juliamelf.javaqa.addressbook.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void initContactModificationById(int id) {
        wd.findElements(By.xpath("//a[contains(@href, '"+ id +"')]")).get(1).click();
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

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id = '"+ id +"']")).click();
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

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        app.goTo().HomePage();
    }

    public void delete(int index) {
        selectContact(index);
        initContactDeletion();
        app.goTo().HomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
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
            ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withFirstAddress(firstAddress);
            contacts.add(contact);
        }
        return contacts;
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for(WebElement element: elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String firstAddress = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
            ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withFirstAddress(firstAddress);
            contacts.add(contact);
        }
        return contacts;
    }


}
