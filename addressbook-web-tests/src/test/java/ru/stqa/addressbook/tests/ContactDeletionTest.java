package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Администратор on 13.11.2016.
 */
public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {

    app.goTo().goToHomePage();
    if (!app.contact().isThereAContact()) {
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withFirstName("contact_first_name"));
    }
    List<ContactData> before = app.contact().list();
    app.contact().selectContact(before.size() - 1);
    app.contact().initContactDeletion();
    app.contact().confirmContactDeletion();
    app.goTo().goToHomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
    }
}
