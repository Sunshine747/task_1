package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {

    app.goToAddNewContact();
    app.fillContactTextField(new ContactData("contact_first_name", "contact_middle_name", "contact_last_name", "nickname", "title", "company", "address", "home_phone_number", "mobile_phone_number"));
    app.submitAddNewContact();
    app.returnToHomePage();
  }

}
