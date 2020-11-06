package tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testUntitledTestCase() throws Exception {

    application.getNavigationHelper().gotoHomePage();
    application.getContactHelper().selectContact();
    application.getContactHelper().deleteSelectedContact();
    application.getNavigationHelper().gotoHomePage();
    application.getSessionHelper().logOut();

  }

}

