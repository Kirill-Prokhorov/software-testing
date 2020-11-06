package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){

    application.getNavigationHelper().gotoHomePage();
    application.getContactHelper().initContactModification();
    application.getContactHelper().fillContactForm(new ContactData("Changed First Name", "Changed Middle Name", "Changed Last Name"));
    application.getContactHelper().submitContactModification();
    application.getContactHelper().returnToHomePage();

  }

}
