package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Администратор on 13.11.2016.
 */
public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (!app.contact().isThereAContact()) {
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withFirstName("contact_first_name"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("test_contact_mod").withLastName("").withAddress("");
    app.contact().modify(contact);
    assertEquals(before.size(), app.contact().count());
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
