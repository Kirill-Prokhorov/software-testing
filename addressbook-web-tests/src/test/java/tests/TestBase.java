package tests;

import appManager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class TestBase {

  public ApplicationManager application = new ApplicationManager();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    application.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    application.stop();

  }

}
