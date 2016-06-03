package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.GroupData;

/**
 * Created by korotkova on 6/3/2016.
 */
public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("updated test group", "update test 1", "update test 2"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();

    }

}
