package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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

    List<ContactData> before = application.getContactHelper().getContactList();
   // Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    application.getContactHelper().deleteContact();
    application.getNavigationHelper().gotoHomePage();
    List<ContactData> after = application.getContactHelper().getContactList();
    Assert.assertEquals( after.size(), before.size()-1);
    before.remove(0);
    Assert.assertEquals(before, after);
    application.getSessionHelper().logOut();

  }

}

