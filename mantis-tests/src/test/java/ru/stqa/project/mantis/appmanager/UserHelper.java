package ru.stqa.project.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.project.mantis.model.UserData;
import ru.stqa.project.mantis.model.Users;

public class UserHelper extends BaseHelper {

  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void loginAdmin() {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), app.getProperty("web.adminLogin"));
    type(By.name("password"), app.getProperty("web.adminPass"));
    click(By.cssSelector("input[value='Login']"));
  }

  public void activateChangePassword(String user) {
    if (!isElementPresent(By.linkText("Manage Users"))) {
      click(By.linkText("Manage"));
    }
    click(By.linkText("Manage Users"));
    click(By.linkText(user));
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public UserData select(Users users) {
    UserData modifiedUser;
    do {
      modifiedUser = users.iterator().next();
    } while (modifiedUser.getUsername() == "administrator");
    return modifiedUser;
  }
}
