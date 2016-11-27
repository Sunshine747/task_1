package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.addressbook.model.ContactData;

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

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    if (!isElementPresent(By.name("update")) && !isElementPresent(By.xpath("//*[@id=\"content\"]/h1"))) {
      click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
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

  public void createContact(ContactData contact) {
    fillContactTextField(contact);
    submitAddNewContact();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
  }
}
