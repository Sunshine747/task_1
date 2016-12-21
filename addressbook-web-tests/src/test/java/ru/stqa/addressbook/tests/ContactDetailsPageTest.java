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
public class ContactDetailsPageTest extends TestBase {


  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (!app.contact().isThereAContact()) {
      app.goTo().addNewContact();
      app.contact().create(new ContactData().withFirstName("contact_first_name").withHomePhoneNumber("1234"));
    }
  }

  @Test
  public void testContactDetailsPage() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditContact(contact);

    assertThat(contactInfoFromDetailsPage.getAllContact(),
            equalTo((mergeInfo(contactInfoFromEditForm))));
  }

  private String mergeInfo(ContactData contact) {
    return Arrays.asList(contact.getFirstName(), contact.getLastName(),
            contact.getAddress(), contact.getHomePhoneNumber(), contact.getMobilePhoneNumber(),
            contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter(s -> !s.equals(""))
            .map(ContactDetailsPageTest::cleaned)
            .collect(Collectors.joining(""));
  }

  public static String cleaned(String info) {
    return info.replaceAll("\\n", "").replaceAll(" ", "")
            .replaceAll("H:|M:", "");
  }
}
