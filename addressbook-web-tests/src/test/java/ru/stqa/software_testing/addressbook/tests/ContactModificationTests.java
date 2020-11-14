package ru.stqa.software_testing.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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
    List<ContactData> before = application.getContactHelper().getContactList();
    ContactData contact = new ContactData(  "Changed First Name",
            "Changed Last Name");
    application.getContactHelper().contactModification(contact, false);
    List<ContactData> after = application.getContactHelper().getContactList();
    Assert.assertEquals( after.size(), before.size());

    before.remove(0);
    before.add(0, contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    application.getSessionHelper().logOut();

  }

}
