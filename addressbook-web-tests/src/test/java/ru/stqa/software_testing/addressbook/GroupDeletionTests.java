package ru.stqa.software_testing.addressbook;

import org.testng.annotations.*;


public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDelition() throws Exception {

    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    gotoGroupPage();

  }

}