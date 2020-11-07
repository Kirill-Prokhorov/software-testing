package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {

    application.getNavigationHelper().gotoHomePage();
    if (!application.getContactHelper().isThereAContact()) {

      application.getNavigationHelper().gotoGroupPage();
      application.getGroupHelper().createGroup(new GroupData("Test", "test2", null));
      application.getNavigationHelper().gotoHomePage();
      application.getContactHelper().contactCreation(new ContactData("First Name",
              "Last Name", "Test"), true);

    }
    application.getContactHelper().deleteContact();
    application.getSessionHelper().logOut();

  }

}

