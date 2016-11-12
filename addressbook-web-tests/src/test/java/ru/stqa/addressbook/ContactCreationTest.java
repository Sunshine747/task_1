package ru.stqa.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {

    goToAddNewContact();
    fillContactTextField(new ContactData("contact_first_name", "contact_middle_name", "contact_last_name", "nickname", "title", "company", "address", "home_phone_number", "mobile_phone_number"));
    submitAddNewContact();
    returnToHomePage();
  }

}
