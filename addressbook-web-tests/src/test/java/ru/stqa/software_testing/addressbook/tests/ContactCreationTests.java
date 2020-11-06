package ru.stqa.software_testing.addressbook.tests;

import ru.stqa.software_testing.addressbook.model.ContactData;
import org.testng.annotations.*;

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
