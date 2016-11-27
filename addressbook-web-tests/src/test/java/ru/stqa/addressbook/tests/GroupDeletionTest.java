package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;

/**
 * Created by Администратор on 13.11.2016.
 */
public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() {

    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("group_name", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initDeleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }
}
