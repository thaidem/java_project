package ru.stqa.project.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.project.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {


  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Vladimir", "Lenin", "MSK, Red Square", "+7-999-999 99 99", "vl@gmail.com"));
    app.getContactHelper().updateContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
