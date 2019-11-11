package ru.stqa.project.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.project.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    Set<GroupData> before = app.group().all();
    GroupData modifyGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifyGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifyGroup);
    before.add(group);
    Assert.assertEquals(before, after);
  }
}
