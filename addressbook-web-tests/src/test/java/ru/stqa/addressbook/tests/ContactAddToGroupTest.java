package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.Contacts;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Администратор on 23.12.2016.
 */
public class ContactAddToGroupTest extends TestBase{

  private Contacts contacts;

  @BeforeMethod
  public void ensurePrecondition() {
    Contacts allContacts = app.db().contacts();
    Groups groups = app.db().groups();
    contacts = app.db().contactsInNotAllGroups(allContacts, groups.size());
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withFirstName("contact_first_name"));
    }
    if (groups.size() == 0 || contacts.size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("group_name"));
      groups = app.db().groups();
      contacts = app.db().contactsInNotAllGroups(allContacts, groups.size());
    }
  }

  @Test
  public void testAddContactToGroup() {
    ContactData contact = contacts.iterator().next();
    GroupData group = findGroupsForAdd(contact).iterator().next();
    app.goTo().homePage();
    app.contact().addToGroup(contact, group);
    ContactData contactForEq = app.db().contacts().stream()
            .filter(s -> s.getId() == contact.getId()).iterator().next();
    app.goTo().homePage();

    assertThat(contactForEq.getGroups().contains(group), equalTo(true));
  }

  private Groups findGroupsForAdd(ContactData contact) {
    Groups groups = app.db().groups();
    contact.getGroups().forEach(groups::remove);
    return groups;
  }
}
