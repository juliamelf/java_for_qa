package ru.juliamelf.javaqa.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test group", "test 1", "test 2"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
