package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.addressbook.model.GroupData;

/**
 * Created by Администратор on 13.11.2016.
 */
public class GroupHelper extends BaseHelper {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    if (!isElementPresent(By.name("new"))) {
      click(By.linkText("group page"));
    }
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupTextFields(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupPage() {
    if (!isElementPresent(By.name("submit"))) {
      click(By.name("new"));
    }
  }

  public void initGroupModification() {
    if (!isElementPresent(By.name("update"))) {
      click(By.name("edit"));
    }
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initDeleteGroup() {
    click(By.name("delete"));
  }
}
