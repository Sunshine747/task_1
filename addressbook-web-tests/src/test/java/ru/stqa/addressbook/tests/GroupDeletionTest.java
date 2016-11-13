package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Администратор on 13.11.2016.
 */
public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initDeleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }
}
