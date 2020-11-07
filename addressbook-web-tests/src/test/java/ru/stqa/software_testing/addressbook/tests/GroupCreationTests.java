package ru.stqa.software_testing.addressbook.tests;

import ru.stqa.software_testing.addressbook.model.GroupData;
import org.testng.annotations.*;



public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    application.getNavigationHelper().gotoGroupPage();
    application.getGroupHelper().initGroupCreation();
    application.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
    application.getGroupHelper().submitGroupCreation();
    application.getGroupHelper().returnToGroupPage();
    application.getSessionHelper().logOut();
  }

}
