package ru.stqa.project.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.project.addressbook.model.ContactData;
import ru.stqa.project.addressbook.model.GroupData;
import ru.stqa.project.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
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

    for (GroupData group : app.db().groups()) {
      Integer i = 0;
      for (ContactData contact : app.db().contacts()) {

        Groups before = contact.getGroups();
        if (!before.stream().filter(o -> o.getName().equals(group.getName())).findFirst().isPresent()) {
          app.contact().addToGroup(contact, group.getName());
          Groups after = app.contact().newInfoAboutGroupsIntoContact(contact.getId());
          assertThat(after.size(), equalTo(before.size() + 1));
          assertThat(after, equalTo(before.withAdded(group)));
          break;

        } else if (before.stream().filter(o -> o.getName().equals(group.getName())).findFirst().isPresent()
                && i.equals(app.db().contacts().size() - 1)) {
          ContactData newContact = new ContactData().withFirstname("John").withLastname("Lennon");
          app.contact().create(newContact, true);
          int newId = app.db().contacts().stream().mapToInt((c) -> c.getId()).max().getAsInt();

          Groups newBefore = newContact.getGroups();
          app.contact().addToGroup(newContact.withId(newId), group.getName());
          Groups newAfter = app.contact().newInfoAboutGroupsIntoContact(contact.getId());

          assertThat(newAfter.size(), equalTo(newBefore.size() + 1));
          assertThat(newAfter, equalTo(newBefore.withAdded(group)));
          break;
        }
        ++i;
      }
    }
  }

  @Test
  public void testContactsFromGroups() {
    app.goTo().homePage();

    for (GroupData group : app.db().groups()) {
      Integer i = 0;
      for (ContactData contact : app.db().contacts()) {

        Groups before = contact.getGroups();
        if (before.stream().filter(o -> o.getName().equals(group.getName())).findFirst().isPresent()) {
          app.contact().deleteFromGroup(contact, group.getName());
          Groups after = app.contact().newInfoAboutGroupsIntoContact(contact.getId());
          assertThat(after.size(), equalTo(before.size() - 1));
          assertThat(after, equalTo(before.without(group)));
          break;

        } else if (!before.stream().filter(o -> o.getName().equals(group.getName())).findFirst().isPresent()
                && i.equals(app.db().contacts().size() - 1)) {
          app.contact().addToGroup(contact, group.getName());
          app.contact().deleteFromGroup(contact, group.getName());
          Groups after = app.contact().newInfoAboutGroupsIntoContact(contact.getId());
          assertThat(after, equalTo(before));
          break;
        }
        ++i;
      }
    }
  }
}


