package ru.stqa.project.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.project.addressbook.model.ContactData;
import ru.stqa.project.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/cat.jpg");
    ContactData contact = new ContactData().withFirstname("John").withLastname("Lennon").withPhoto(photo).withGroup("test1");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
