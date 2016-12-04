package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Администратор on 13.11.2016.
 */
public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();

    if (!app.getGroupHelper().isThereAGroup()) {
      app.getNavigationHelper().goToAddNewContact();
      app.getGroupHelper().createGroup(new GroupData("group_name", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupTextFields(new GroupData("group_name_mod", "text_group_header_mod", "text_group_footer_mod"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(), after.size());
  }
}
