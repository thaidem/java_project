package ru.stqa.project.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import javax.xml.rpc.ServiceException;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.project.mantis.appmanager.ApplicationManager;

import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
  }

  boolean isIssueOpen(int issueId) throws MalformedURLException, RemoteException, ServiceException {
    MantisConnectPortType mc = new MantisConnectLocator().getMantisConnectPort(new URL(app.getProperty("web.soapUrl")));
    IssueData issue = mc.mc_issue_get
            (app.getProperty("web.adminLogin"), app.getProperty("web.adminPass"), BigInteger.valueOf(issueId));
    return !issue.getStatus().getName().equals("resolved");
  }

  public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() throws Exception {
    app.ftp().restore("config_inc.php.bak","config_inc.php");
    app.stop();
  }

}
