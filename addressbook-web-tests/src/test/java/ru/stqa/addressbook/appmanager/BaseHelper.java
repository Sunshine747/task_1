package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

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
        element.sendKeys(text);
      }
    }
  }

  protected void selectValue(By locator, String text) {
    new Select(wd.findElement(locator)).selectByVisibleText(text);
  }

  protected void attache(By locator, String file) {
    if (file != null) {
      wd.findElement(locator).sendKeys(file);
    }
  }

  protected WebElement find(By locator) {
    return wd.findElement(locator);
  }

  protected void confirmAlert() {
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

  public void scrollUP() {
    JavascriptExecutor js = ((JavascriptExecutor) wd);
    js.executeScript("window.scrollBy(0,450)", "");
  }
}
