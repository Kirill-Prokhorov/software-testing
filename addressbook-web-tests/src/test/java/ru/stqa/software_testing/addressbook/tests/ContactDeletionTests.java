package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.*;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {

    application.getNavigationHelper().gotoHomePage();
    application.getContactHelper().selectContact();
    application.getContactHelper().deleteSelectedContact();
    application.getNavigationHelper().gotoHomePage();
    application.getSessionHelper().logOut();

  }

}

