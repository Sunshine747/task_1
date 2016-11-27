package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goToAddNewContact();
    app.getContactHelper().createContact(new ContactData("contact_first_name", null, null, null, null, null, null, null, null));
  }
}
