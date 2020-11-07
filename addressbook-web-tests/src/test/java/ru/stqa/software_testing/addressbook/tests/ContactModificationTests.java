package ru.stqa.software_testing.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    application.getNavigationHelper().gotoHomePage();
    if (!application.getContactHelper().isThereAContact()) {

      application.getNavigationHelper().gotoGroupPage();
      application.getGroupHelper().createGroup(new GroupData("Test", "test2", null));
      application.getNavigationHelper().gotoHomePage();
      application.getContactHelper().contactCreation(new ContactData("First Name",
              "Last Name", "Test"), true);

    }
    application.getContactHelper().contactModification(new ContactData("Changed First Name",
            "Changed Last Name", null), false);
    application.getSessionHelper().logOut();

  }

}
