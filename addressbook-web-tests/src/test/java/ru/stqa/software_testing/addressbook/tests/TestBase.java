package ru.stqa.software_testing.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import ru.stqa.software_testing.addressbook.appManager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

  public ApplicationManager application = new ApplicationManager("chrome");

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    application.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    application.stop();

  }

}
