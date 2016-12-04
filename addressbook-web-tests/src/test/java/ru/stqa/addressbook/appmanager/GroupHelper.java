package ru.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.model.GroupData;

import java.util.ArrayList;
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

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initDeleteGroup() {
    click(By.name("delete"));
  }

  public void createGroup(GroupData group) {
    initGroupPage();
    fillGroupTextFields(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
    return groups;
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
