package ru.stqa.project.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.project.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().HomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }
}
