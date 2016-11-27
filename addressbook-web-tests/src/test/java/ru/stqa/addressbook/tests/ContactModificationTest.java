package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;

/**
 * Created by Администратор on 13.11.2016.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().goToAddNewContact();
      app.getContactHelper().createContact(new ContactData("contact_first_name", null, null, null, null, null, null, null, null));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactTextField(new ContactData("contact_first_name_mod", "contact_middle_name_mod", "contact_last_name_mod", "nickname_mod", "title_mod", "company_mod", "address_mod", "home_phone_number_mod", "mobile_phone_number_mod"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
