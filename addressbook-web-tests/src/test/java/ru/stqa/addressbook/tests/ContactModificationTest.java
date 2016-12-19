package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Администратор on 13.11.2016.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {

    app.goTo().goToHomePage();
    if (!app.contact().isThereAContact()) {
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withFirstName("contact_first_name"));
    }
    List<ContactData> before = app.contact().list();
    app.contact().initContactModification(before.size() - 1);
    ContactData contact = new ContactData().withFirstName("test_contact_mod");
    app.contact().fillContactTextField(contact);
    app.contact().submitContactModification();
    app.contact().returnToHomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(before.size(), after.size());

    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.remove(before.size() - 1);
    contact.withId(before.stream().max(byId).get().getId());
    before.add(contact);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);


  }
}
