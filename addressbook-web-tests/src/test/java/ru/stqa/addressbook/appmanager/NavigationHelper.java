package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Администратор on 13.11.2016.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (!isElementPresent(By.name("new"))) {
      click(By.linkText("groups"));
    }
  }

  public void addNewContact() {
    if (!isElementPresent(By.name("submit")) && !isElementPresent(By.xpath("\"//*[@id=\\\"content\\\"]/h1\""))) {
      click(By.linkText("add new"));
    }
  }

  public void homePage() {
    if (!isElementPresent(By.xpath("//*[@id=\"content\"]/form[2]/div[1]/input"))) {
      click(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a"));
    }
  }
}
//