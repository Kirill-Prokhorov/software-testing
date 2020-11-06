package tests;

import model.GroupData;
import org.testng.annotations.*;



public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    application.getNavigationHelper().gotoGroupPage();
    application.getGroupHelper().initGroupCreation();
    application.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    application.getGroupHelper().submitGroupCreation();
    application.getGroupHelper().returnToGroupPage();
    application.getSessionHelper().logOut();
  }

}