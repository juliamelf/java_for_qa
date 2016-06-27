package ru.juliamelf.javaqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.juliamelf.javaqa.addressbook.model.GroupData;
import ru.juliamelf.javaqa.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        if(app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test group"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedGroup)));

    }

}
