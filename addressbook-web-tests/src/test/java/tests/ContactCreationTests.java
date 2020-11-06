package tests;

import model.ContactData;
import org.testng.annotations.*;
import tests.TestBase;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    application.getContactHelper().initContactCreation();
    application.getContactHelper().fillContactForm(new ContactData("Otshel", "Otshelovichc", "Otshelov"));
    application.getContactHelper().submitContactCreation();
    application.getNavigationHelper().gotoHomePage();
    application.getSessionHelper().logOut();
  }

}
