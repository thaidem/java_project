package ru.stqa.project.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.project.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
  }
}
