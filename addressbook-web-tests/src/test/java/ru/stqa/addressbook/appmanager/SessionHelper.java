package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Администратор on 13.11.2016.
 */
public class SessionHelper extends BaseHelper {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void authorization(String username, String pass) {
    type(By.name("user"), username);
    type(By.name("pass"), pass);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
