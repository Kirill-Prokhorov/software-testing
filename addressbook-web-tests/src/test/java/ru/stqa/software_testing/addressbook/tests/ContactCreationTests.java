package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import ru.stqa.software_testing.addressbook.model.ContactData;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    application.getNavigationHelper().gotoGroupPage();
    if(! application.getGroupHelper().isThereAGroup()){
      application.getGroupHelper().createGroup(new GroupData("Test", null, "test3"));
    }
    application.getNavigationHelper().gotoHomePage();


    List<ContactData> before = application.getContactHelper().getContactList();
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    ContactData contact = new ContactData( "Created  ",
            "Contact ");
    application.getContactHelper().contactCreation(contact, true);

    List<ContactData> after = application.getContactHelper().getContactList();
    Assert.assertEquals( after.size(), before.size()+1);

    after.sort(byId);
    before.add(after.get(after.size()-1));

    before.sort(byId);
    Assert.assertEquals(before, after);
    application.getSessionHelper().logOut();
  }

}
