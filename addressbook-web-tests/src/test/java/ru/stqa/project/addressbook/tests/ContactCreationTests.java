package ru.stqa.project.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.project.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("John", "Lennon",
            "NY, Dacota","1-212-123 45 67", "jl@gmail.com", "test1");
    app.contact().create(contact, true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before, after);
  }
}
