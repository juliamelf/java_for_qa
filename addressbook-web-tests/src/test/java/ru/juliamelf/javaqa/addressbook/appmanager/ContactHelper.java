package ru.juliamelf.javaqa.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import ru.juliamelf.javaqa.addressbook.model.EmailData;
import ru.juliamelf.javaqa.addressbook.model.PhoneData;
import ru.juliamelf.javaqa.addressbook.model.UserNameData;

/**
 * Created by korotkova on 6/2/2016.
 */
public class ContactHelper {

    private final BaseHelper baseHelper;
    private FirefoxDriver wd;

    public ContactHelper(FirefoxDriver wd) {
        baseHelper = new BaseHelper(wd);
    }

    public void submitContactAdd() {
        baseHelper.clickEnterContactButton();
    }

    public void fillNotesData(String notes) {
        baseHelper.enterNotes(notes);
    }

    public void fillSecondPhoneData(String secondPhone) {
        baseHelper.enterSecondPhone(secondPhone);
    }

    public void fillSecondAddressData(String secondAddress) {
        baseHelper.enterSecondAddress(secondAddress);
    }

    public void fillBirthdayData() {
        baseHelper.selectBirthDay();
        baseHelper.selectBirthMonth();
        baseHelper.enterBirthYear();
        baseHelper.selectAnniversaryDay();
        baseHelper.selectAnniversaryMonth();
        baseHelper.SelectAnniversaryYear();
    }

    public void fillGroup() {
        baseHelper.selectContactGroup();
    }

    public void fillHomepageData(String homepage) {
        baseHelper.enterHomepage(homepage);
    }

    public void fillEmailData(EmailData emailData) {
        baseHelper.enterFirstEmail(emailData);
        baseHelper.enterSecondEmail(emailData);
        baseHelper.enterThirdEmail(emailData);
    }

    public void fillFirstPhoneData(PhoneData firstPhoneData) {
        baseHelper.enterHomeNumber(firstPhoneData);
        baseHelper.enterMobileNumber(firstPhoneData);
        baseHelper.enterWorkNumber(firstPhoneData);
        baseHelper.enterFaxNumber(firstPhoneData);
    }

    public void fillFirstAddressData(String firstAddress) {
        baseHelper.enterAddress(firstAddress);
    }

    public void fillCompanyData(String company) {
        baseHelper.enterCompany(company);
    }

    public void fillNameData(UserNameData userNameData) {
        baseHelper.enterFirstName(userNameData);
        baseHelper.enterMiddleName(userNameData);
        baseHelper.enterLastName(userNameData);
        baseHelper.enterNickName(userNameData);
        baseHelper.enterTitle(userNameData);
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }
}
