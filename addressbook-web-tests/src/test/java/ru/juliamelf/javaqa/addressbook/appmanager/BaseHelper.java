package ru.juliamelf.javaqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.juliamelf.javaqa.addressbook.model.EmailData;
import ru.juliamelf.javaqa.addressbook.model.GroupData;
import ru.juliamelf.javaqa.addressbook.model.PhoneData;
import ru.juliamelf.javaqa.addressbook.model.UserNameData;

/**
 * Created by korotkova on 6/2/2016.
 */
public class BaseHelper {
    protected FirefoxDriver wd;

    public BaseHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    protected void clickLoginButton() {
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    protected void fillPassword(String password) {
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
    }

    protected void fillUserName(String username) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
    }

    protected void openApplication() {
        wd.get("http://localhost/addressbook/");
    }

    protected void openGroupsPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    protected void clickEnterGroupButton() {
        wd.findElement(By.name("submit")).click();
    }

    protected void clickNewGroup() {
        wd.findElement(By.name("new")).click();
    }

    protected void enterGroupFooter(GroupData groupData) {
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    protected void enterGroupHeader(GroupData groupData) {
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    }

    protected void enterGroupName(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    }

    protected void clickDeleteButton() {
        wd.findElement(By.name("delete")).click();
    }

    protected void selectGroup() {
        if (!wd.findElement(By.name("selected[]")).isSelected()) {
            wd.findElement(By.name("selected[]")).click();
        }
    }

    protected void openHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    protected void openAddContactPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    protected void clickEnterContactButton() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    protected void enterNotes(String notes) {
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(notes);
    }

    protected void enterSecondPhone(String secondPhone) {
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(secondPhone);
    }

    protected void enterSecondAddress(String secondAddress) {
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(secondAddress);
    }

    protected void selectContactGroup() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).click();
        }
    }

    protected void SelectAnniversaryYear() {
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys("1990");
    }

    protected void selectAnniversaryMonth() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[2]")).click();
        }
    }

    protected void selectAnniversaryDay() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[21]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[21]")).click();
        }
    }

    protected void enterBirthYear() {
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys("1990");
    }

    protected void selectBirthMonth() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
        }
    }

    protected void selectBirthDay() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[20]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[20]")).click();
        }
    }

    protected void enterHomepage(String homepage) {
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(homepage);
    }

    protected void enterThirdEmail(EmailData emailData) {
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(emailData.getThirdEmail());
    }

    protected void enterSecondEmail(EmailData emailData) {
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(emailData.getSecondEmail());
    }

    protected void enterFirstEmail(EmailData emailData) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(emailData.getFirstEmail());
    }

    protected void enterFaxNumber(PhoneData firstPhoneData) {
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(firstPhoneData.getFaxNumber());
    }

    protected void enterWorkNumber(PhoneData firstPhoneData) {
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(firstPhoneData.getWorkNumber());
    }

    protected void enterMobileNumber(PhoneData firstPhoneData) {
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(firstPhoneData.getMobileNumber());
    }

    protected void enterHomeNumber(PhoneData firstPhoneData) {
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(firstPhoneData.getHomeNumber());
    }

    protected void enterAddress(String firstAddress) {
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(firstAddress);
    }

    protected void enterCompany(String company) {
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(company);
    }

    protected void enterTitle(UserNameData userNameData) {
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(userNameData.getTitle());
    }

    protected void enterNickName(UserNameData userNameData) {
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).sendKeys(userNameData.getNickname());
    }

    protected void enterLastName(UserNameData userNameData) {
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(userNameData.getLastName());
    }

    protected void enterMiddleName(UserNameData userNameData) {
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(userNameData.getMiddleName());
    }

    protected void enterFirstName(UserNameData userNameData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(userNameData.getFirstName());
    }
}
