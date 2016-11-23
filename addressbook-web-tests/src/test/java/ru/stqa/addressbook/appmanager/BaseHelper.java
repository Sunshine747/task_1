package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.*;

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
    if (text != null) {
      String existingText = find(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        element.clear();
        element.sendKeys(text);}
      }

  }

  protected WebElement find(By locator) {
    return wd.findElement(locator);
  }

  protected void confirmAlert(){
    wd.switchTo().alert().accept();
  }

  protected boolean isElementPresent(By locator) {
    try {
      find(locator);
      return true;
    } catch (NoSuchElementException ex) {
        return false;
    }
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
