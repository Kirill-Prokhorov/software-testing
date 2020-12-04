package ru.stqa.software_testing.addressbook.tests;


import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.software_testing.addressbook.appManager.ApplicationManager;


public class TestBase {

  protected static final ApplicationManager application = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    application.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    application.stop();

  }

}
