package ru.stqa.software_testing.addressbook.tests;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.software_testing.addressbook.appManager.ApplicationManager;




public class TestBase {

  public static final ApplicationManager application = new ApplicationManager("chrome");

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    application.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    application.stop();

  }

}
