package ru.stqa.project.ils.appmanager;

import org.openqa.selenium.By;

public class SessionHelper extends BaseHelper {

  public SessionHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    type(By.name("l"), username);
    type(By.name("p"), password);

    click(By.xpath("//input[@value='Войти']"));
  }
}
