package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

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
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().confirmContactDeletion();
    app.getNavigationHelper().goToHomePage();
  }
}
