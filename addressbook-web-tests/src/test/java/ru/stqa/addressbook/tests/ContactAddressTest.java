package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Администратор on 20.12.2016.
 */
public class ContactAddressTest extends TestBase {


  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (!app.contact().isThereAContact()) {
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withFirstName("contact_first_name").withAddress("1234"));
    }
  }

  @Test
  public void testContactAddress() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditContact(contact);

    assertThat(cleaned(contact.getAddress()),
            equalTo(mergeAddress(contactInfoFromEditForm)));
  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getAddress())
            .stream().filter(s -> !s.equals(""))
            .map(ContactAddressTest::cleaned)
            .collect(Collectors.joining(""));
  }

  public static String cleaned(String address) {
    return address.replaceAll("\\n", "").replaceAll(" ", "");
  }
}
