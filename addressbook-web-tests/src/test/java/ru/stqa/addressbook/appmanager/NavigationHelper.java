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

  public void goToGroupPage() {
    click(By.linkText("groups"));
  }

  public void goToAddNewContact() {
    click(By.linkText("add new"));
  }

  public void goToHomePage() {
    click(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a"));
  }
}
