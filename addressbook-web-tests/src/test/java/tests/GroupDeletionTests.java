package tests;

import org.testng.annotations.*;


public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDelition() throws Exception {

    application.gotoGroupPage();
    application.selectGroup();
    application.deleteSelectedGroups();
    application.gotoGroupPage();

  }

}