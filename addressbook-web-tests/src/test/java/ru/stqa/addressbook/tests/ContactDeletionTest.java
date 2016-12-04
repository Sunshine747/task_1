package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Администратор on 13.11.2016.
 */
public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {

    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().goToAddNewContact();
      app.getContactHelper().createContact(new ContactData("contact_first_name", null, null, null, null, null, null, null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().confirmContactDeletion();
    app.getNavigationHelper().goToHomePage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(before.size(), after.size() - 1);
  }
}
