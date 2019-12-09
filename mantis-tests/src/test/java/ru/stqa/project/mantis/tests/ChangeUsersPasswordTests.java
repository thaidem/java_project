package ru.stqa.project.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.project.mantis.model.MailMessage;
import ru.stqa.project.mantis.model.UserData;
import ru.stqa.project.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangeUsersPasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangeUsersPassword() throws IOException, MessagingException {
    String password = "password999";
    app.user().loginAdmin();
    Users users = app.db().users();
    UserData modifiedUser = app.user().select(users);
    String username = modifiedUser.getUsername();
    app.user().activateChangePassword(username);

    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, modifiedUser.getEmail());
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(username, password));
   }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
