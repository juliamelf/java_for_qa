package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by korotkova on 6/3/2016.
 */
public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if(!app.getGroupHelper().isGroupExists()) {
            app.getGroupHelper().createGroup(new GroupData("test group", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size() - 1).getId(), "new test group", "new test 1", "new test 2");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Comparator<? super GroupData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);

    }

}
