package ru.stqa.project.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.project.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {


  @Test(enabled = false)
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("John", "Lennon", null,
              null, null, "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"John", "Lennon",
            "NY, Dacota","1-212-123 45 67", "jl@gmail.com", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().updateContactModification();
    app.goTo().HomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> ById = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before, after);
  }
}
