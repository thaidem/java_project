package ru.stqa.project.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void gotoHomePage() {
    wd.get("http://localhost/addressbook/");
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
}
