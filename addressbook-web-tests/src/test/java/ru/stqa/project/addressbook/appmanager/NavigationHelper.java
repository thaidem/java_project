package ru.stqa.project.addressbook.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends BaseHelper {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void HomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    wd.get("http://localhost/addressbook/");
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }
}
