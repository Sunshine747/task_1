package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.addressbook.model.GroupData;
import ru.stqa.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Администратор on 13.11.2016.
 */
public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (!app.group().isThereAGroup()) {
      app.goTo().addNewContact();
      app.group().create(new GroupData().withName("group_name"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertEquals(app.group().count(), before.size() - 1);
    Groups after = app.group().all();

    assertThat(after, equalTo(before.without(deletedGroup)));
  }
}
