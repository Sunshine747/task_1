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
public class GroupModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.goTo().addNewContact();
      app.group().create(new GroupData().withName("group_name"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("group_name_mod").withFooter("text_group_footer_mod").withHeader("text_group_header_mod");
    app.group().modify(group);
    assertEquals(before.size(), app.group().count());
    Groups after = app.group().all();

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }
}
