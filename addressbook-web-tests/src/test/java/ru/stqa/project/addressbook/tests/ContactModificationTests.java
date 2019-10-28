package ru.stqa.project.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.project.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {


  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("John", "Lennon", "NY, Dacota",
              "1-212-123 45 67", "jl@gmail.com", "test4"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Vladimir", "Lenin",
            "MSK, Red Square", "+7-999-999 99 99", "vl@gmail.com", null), false);
    app.getContactHelper().updateContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
