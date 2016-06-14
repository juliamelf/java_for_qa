package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {

        app.getNavigationHelper().gotoGroupPage();
        if(!app.getGroupHelper().isGroupExists()) {
            app.getGroupHelper().createGroup(new GroupData("test group", null, null));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);

    }


}
