package ru.stqa.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.addressbook.appmanager.ApplicationManager;

/**
 * Created by Администратор on 13.11.2016.
 */
public class TestBase {


  protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
