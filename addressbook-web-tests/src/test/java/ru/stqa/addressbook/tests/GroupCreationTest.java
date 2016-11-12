package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goToGroupPage();
    app.initGroupPage();
    app.fiilGroupTextFields(new GroupData("group_name", "text_group_header", "text_group_footer"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
