package tests;

import org.testng.annotations.*;
import model.GroupData;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    application.gotoGroupPage();
    application.initGroupCreation();
    application.fillGroupForm(new GroupData("test1", "test2", "test3"));
    application.submitGroupCreation();
    application.returnToGroupPage();
    application.logOut();
  }

}
