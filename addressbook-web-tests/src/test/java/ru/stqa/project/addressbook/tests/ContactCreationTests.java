package ru.stqa.project.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.project.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("John", "Lennon", "NY, Dacota", "1-212-123 45 67", "jl@gmail.com"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }

}
