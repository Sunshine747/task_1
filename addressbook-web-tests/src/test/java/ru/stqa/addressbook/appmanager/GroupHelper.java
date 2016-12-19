package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.model.Groups;

import java.util.List;

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

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
  }

  public void initDeleteGroup() {
    click(By.name("delete"));
  }

  public void create(GroupData group) {
    initGroupPage();
    fillGroupTextFields(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupTextFields(group);
    submitGroupModification();
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    initDeleteGroup();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public Groups all() {
    Groups groups = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
