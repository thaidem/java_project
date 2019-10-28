package ru.stqa.project.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.project.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("John", "Lennon", "NY, Dacota",
              "1-212-123 45 67", "jl@gmail.com", "test4"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationHelper().gotoHomePage();
  }
}
