package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Администратор on 13.11.2016.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    click(By.linkText("groups"));
  }

  public void goToAddNewContact() {
    click(By.linkText("add new"));
  }
}
