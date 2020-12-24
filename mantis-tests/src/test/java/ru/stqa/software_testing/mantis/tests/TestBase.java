package ru.stqa.software_testing.mantis.tests;


import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.software_testing.mantis.appmanager.ApplicationManager;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;


public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/Resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");

  }
  public void skipIfNotFixed(int issueId) throws IOException, ServiceException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  public boolean isIssueOpen(int issueId) throws IOException, javax.xml.rpc.ServiceException {
    if (app.soap().issueStatus(issueId) != 80) {
      return true;
    }
    return false;
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.stop();

  }


}
