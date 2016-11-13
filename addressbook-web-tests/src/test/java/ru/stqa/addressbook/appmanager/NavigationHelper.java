package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Администратор on 13.11.2016.
 */
public class NavigationHelper {

  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;

  }

  public void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void goToAddNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }
}
