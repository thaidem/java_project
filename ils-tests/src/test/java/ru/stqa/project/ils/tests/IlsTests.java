package ru.stqa.project.ils.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class IlsTests extends TestBase {


  @Test
  public void testIls() throws InterruptedException {
    app.wd.findElement(By.linkText("ILS Plan")).click();

    Actions action = new Actions(app.wd);
    WebElement project = app.wd.findElement(By.xpath("//td[@id='TGCell-0-AR1-Name_']"));
    action.doubleClick(project).perform();

    (new WebDriverWait(app.wd, 30))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("TGCell-0-P10948-Name_")));
    WebElement plan = app.wd.findElement(By.xpath("//td[contains(text(),'for_edit_')]"));
    System.out.println(plan.getText());
    Thread.sleep(10000);
    plan = app.wd.findElement(By.id("TGCell-0-P10948-Name_"));
    action.contextClick(plan).perform();
    app.wd.findElement(By.xpath("//*[.='Изменить название']")).click();

    WebElement editPlan = app.wd.findElement(By.id("TGInput-0"));
    String oldPlan = editPlan.getAttribute("value");
    System.out.println(oldPlan);
    String newPlan = "for_edit_" + (Integer.parseInt(oldPlan.substring(9)) + 1);
    System.out.println(newPlan);
    editPlan.sendKeys(newPlan + Keys.ENTER);
  }
}
