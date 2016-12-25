package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.Contacts;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Администратор on 25.12.2016.
 */
public class ContactDeletionFromGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    Contacts allContacts = app.db().contacts();
    Groups groups = app.db().groups();
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withFirstName("contact_first_name"));
    }
    if (groups.size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("group_name"));
    }
    if (app.db().contactsInGroups(allContacts).size() == 0) {
      app.goTo().homePage();
      app.contact().addToGroup(app.db().contacts().stream().iterator().next(),
              app.db().groups().stream().iterator().next());
    }
  }

  @Test
  public void testAddContactToGroup() {
    Contacts contacts = app.db().contactsInGroups(app.db().contacts());
    ContactData contact = contacts.stream().iterator().next();
    app.goTo().homePage();
    GroupData group = contact.getGroups().iterator().next();
    app.contact().deleteFromGroup(contact, group);
    ContactData contactForEq = app.db().contacts().stream()
            .filter(s -> s.getId() == contact.getId()).iterator().next();
    app.goTo().homePage();

    assertThat(contactForEq.getGroups().contains(group), equalTo(false));
  }
}
