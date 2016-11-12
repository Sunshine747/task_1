package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goToGroupPage();
    app.getGroupHelper().initGroupPage();
    app.getGroupHelper().fillGroupTextFields(new GroupData("group_name", "text_group_header", "text_group_footer"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}
