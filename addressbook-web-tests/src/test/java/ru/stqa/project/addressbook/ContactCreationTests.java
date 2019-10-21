package ru.stqa.project.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactData("John", "Lennon", "NY, Dacota", "1-212-123 45 67", "jl@gmail.com"));
    submitContactCreation();
    gotoHomePage();
  }

}
