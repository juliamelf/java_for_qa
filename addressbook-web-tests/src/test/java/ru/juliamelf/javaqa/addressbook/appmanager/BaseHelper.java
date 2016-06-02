package ru.juliamelf.javaqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.juliamelf.javaqa.addressbook.model.GroupData;

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

    protected void clickEnterButton() {
        wd.findElement(By.name("submit")).click();
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

    protected void clickNewGroup() {
        wd.findElement(By.name("new")).click();
    }

    protected void clickDeleteButton() {
        wd.findElement(By.name("delete")).click();
    }

    protected void selectGroup() {
        if (!wd.findElement(By.name("selected[]")).isSelected()) {
            wd.findElement(By.name("selected[]")).click();
        }
    }
}
