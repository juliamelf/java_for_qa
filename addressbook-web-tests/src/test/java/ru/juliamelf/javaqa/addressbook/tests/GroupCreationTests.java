package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.GroupData;
import ru.juliamelf.javaqa.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new GroupData().withName("group1").withHeader("header1").withFooter("footer1")});
        list.add(new Object[] {new GroupData().withName("group2").withHeader("header2").withFooter("footer2")});
        list.add(new Object[] {new GroupData().withName("group3").withHeader("header3").withFooter("footer3")});
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
        app.goTo().GroupPage();
        Groups before = app.group().all();
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testBadGroupCreation() {
        app.goTo().GroupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test group'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }
}
