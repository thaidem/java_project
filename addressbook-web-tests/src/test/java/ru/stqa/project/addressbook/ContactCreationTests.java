package ru.stqa.project.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests {
  private WebDriver wd;


  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    gotoHomePage();
    login("admin", "secret");
  }

  private void gotoHomePage() {
    wd.get("http://localhost/addressbook/");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactData("John", "Lennon", "NY, Dacota", "1-212-123 45 67", "jl@gmail.com"));
    submitContactCreation();
    gotoHomePage();
  }

  private void submitContactCreation() {
    wd.findElement(By.name("submit")).click();
  }

  private void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  private void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }


  @AfterMethod
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
