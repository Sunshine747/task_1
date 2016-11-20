package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Администратор on 13.11.2016.
 */
public class BaseHelper {
  protected WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    find(locator).click();
  }

  protected void type(By locator, String text) {
    WebElement element = wd.findElement(locator);
    element.clear();
    element.sendKeys(text);
  }

  private WebElement find(By locator) {
    return wd.findElement(locator);
  }

  protected void confirmAlert(){
    wd.switchTo().alert().accept();
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
