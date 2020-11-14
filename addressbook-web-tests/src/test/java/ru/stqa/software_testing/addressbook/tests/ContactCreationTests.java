package ru.stqa.software_testing.addressbook.tests;

import ru.stqa.software_testing.addressbook.model.ContactData;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    application.getNavigationHelper().gotoGroupPage();
    if(! application.getGroupHelper().isThereAGroup()){
      application.getGroupHelper().createGroup(new GroupData("Test", null, "test3"));
    }
    application.getNavigationHelper().gotoHomePage();
    application.getContactHelper().contactCreation(new ContactData("Otshel",
            "Otshelov", "[none]"), true);
    application.getSessionHelper().logOut();
  }

}
