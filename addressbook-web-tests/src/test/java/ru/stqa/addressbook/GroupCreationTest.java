package ru.stqa.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    goToGroupPage();
    initGroupPage();
    fiilGroupTextFields(new GroupData("group_name", "text_group_header", "text_group_footer"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
