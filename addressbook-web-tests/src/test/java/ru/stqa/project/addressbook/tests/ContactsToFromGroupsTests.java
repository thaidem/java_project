package ru.stqa.project.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.project.addressbook.model.ContactData;
import ru.stqa.project.addressbook.model.GroupData;
import ru.stqa.project.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsToFromGroupsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }

    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstname("John").withLastname("Lennon"), true);
    }
  }

  @Test
  public void testContactsToGroups() {
    app.goTo().homePage();
    Integer i = 0;
    GroupData group = app.db().groups().iterator().next();

    for (ContactData contact: app.db().contacts()) {
      Groups before = contact.getGroups();
      System.out.println(contact);
      System.out.println(group);
      System.out.println(before);
      if (group.getName() != before.) {
//        app.contact().addToGroup(contact, group.getName());
        System.out.println(group);

      } else if (before.contains(group) && i == app.db().contacts().size()) {
        app.contact().create(new ContactData().withFirstname("John").withLastname("Lennon"), true);
      }
      ++i;
    }



  }

  @Test
  public void testContactsFromGroups() {

  }
}
