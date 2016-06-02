package ru.juliamelf.javaqa.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import ru.juliamelf.javaqa.addressbook.model.GroupData;

/**
 * Created by korotkova on 6/2/2016.
 */
public class GroupHelper {

    private final BaseHelper baseHelper;

    public GroupHelper(FirefoxDriver wd) {

        baseHelper = new BaseHelper(wd);
    }

    public void initGroupCreation() {
        baseHelper.clickNewGroup();
    }

    public void fillGroupForm(GroupData groupData) {
        baseHelper.enterGroupName(groupData);
        baseHelper.enterGroupHeader(groupData);
        baseHelper.enterGroupFooter(groupData);
    }

    public void submitGroupCreation() {

        baseHelper.clickEnterGroupButton();
    }

    public void returnToGroupPage() {

        baseHelper.openGroupsPage();
    }

    public void selectGroups() {
        baseHelper.selectGroup();
    }

    public void deleteGroup() {
        baseHelper.clickDeleteButton();
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }
}
