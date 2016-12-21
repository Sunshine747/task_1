package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.Contacts;
import ru.stqa.addressbook.tests.ContactDetailsPageTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Администратор on 13.11.2016.
 */
public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    if (!isElementPresent(By.xpath("//*[@id=\"content\"]/form[2]/div[1]/input"))) {
      click(By.linkText("home page"));
    }
  }

  public void submitAddNewContact() {
    click(By.name("submit"));
  }

  public void fillContactTextField(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhoneNumber());
    type(By.name("mobile"), contactData.getMobilePhoneNumber());
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void initContactModification(int id) {
    if (!isElementPresent(By.name("update")) && !isElementPresent(By.xpath("//*[@id=\"content\"]/h1"))) {
      wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
      //wd.findElement(By.xpath("//input[value='%s']/../../td[8]/a")).click();

    }
  }

  public void initContactModificationById(int id) {
    if (!isElementPresent(By.name("update")) && !isElementPresent(By.xpath("//*[@id=\"content\"]/h1"))) {
      WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
      WebElement row = checkbox.findElement(By.xpath("./../.."));
      List<WebElement> cells = row.findElements(By.tagName("td"));
      cells.get(7).findElement(By.tagName("a")).click();
    }
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void initContactDeletion() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
  }

  public void confirmContactDeletion() {
    confirmAlert();
  }

  public void create(ContactData contact) {
    fillContactTextField(contact);
    submitAddNewContact();
    contactCash = null;
    returnToHomePage();
  }

  public ContactData modify(ContactData contact) {
    initContactModification(contact.getId());
    fillContactTextField(contact);
    submitContactModification();
    contactCash = null;
    returnToHomePage();
    return contact;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    initContactDeletion();
    confirmContactDeletion();
    contactCash = null;
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
  }

  public Contacts all() {
    if (contactCash != null) {
      return new Contacts(contactCash);
    }
    contactCash = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
      contactCash.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
              .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
    }
    return new Contacts(contactCash);
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCash = null;

  public ContactData infoFromEditContact(ContactData contact) {
    initContactModification(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
            .withHomePhoneNumber(home).withMobilePhoneNumber(mobile)
            .withEmail1(email1).withEmail2(email2).withEmail3(email3)
            .withAddress(address);
  }

  public void viewDetalPageFromContact(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
  }

  public ContactData infoFromDetailsPage(ContactData contact) {
    viewDetalPageFromContact(contact.getId());
    ContactData contactRet = new ContactData();
    String bodyText = wd.findElement(By.id("content")).getText();
    List<WebElement> emailText = wd.findElements(By.xpath("a[href='mailto']"));
    List<String> emails = new ArrayList<String>();
    for (WebElement email : emailText) {
      emails.add(email.getText());
    }
    bodyText = bodyText.replaceAll("\n", " ");
    String t = emails.stream().map(Object::toString)
            .collect(Collectors.joining(", "));
    String text = Arrays.asList(bodyText, t)
            .stream().filter(s -> !s.equals(""))
            .map(ContactDetailsPageTest::cleaned)
            .collect(Collectors.joining(""));
    wd.navigate().back();
    return contactRet.withAllContact(text);
  }
}
