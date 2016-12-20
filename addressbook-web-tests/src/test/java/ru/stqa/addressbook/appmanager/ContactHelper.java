package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.Contacts;

import java.util.List;

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
      wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
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
      String lastName = element.findElements(By.tagName("td")).get(1).getText();
      String firstName = element.findElements(By.tagName("td")).get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCash.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return new Contacts(contactCash);
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCash = null;

}
