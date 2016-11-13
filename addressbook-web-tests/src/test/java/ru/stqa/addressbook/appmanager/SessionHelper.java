package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Администратор on 13.11.2016.
 */
public class SessionHelper extends HelperBase{

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void authorization(String username, String pass) {
    type(By.name("user"), username);
    type(By.name("pass"), pass);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
