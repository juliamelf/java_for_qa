package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.GroupData;
import ru.juliamelf.javaqa.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by korotkova on 6/3/2016.
 */
public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.group().create(new GroupData().withName("test group"));
        }
    }

    @Test
    public void testGroupModification() {
        app.goTo().GroupPage();
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("new test group").withHeader("new test 1").withFooter("new test 2");
        app.group().modify(group);
        assertEquals(app.group().count(), before.size());
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    }



}
