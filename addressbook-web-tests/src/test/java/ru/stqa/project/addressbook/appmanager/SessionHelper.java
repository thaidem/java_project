package ru.stqa.project.addressbook.appmanager;

import org.openqa.selenium.By;

public class SessionHelper extends BaseHelper {

  public SessionHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.xpath("//input[@value='Login']"));
  }
}
