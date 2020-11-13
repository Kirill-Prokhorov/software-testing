package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.GroupData;


public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletion() throws Exception {

    application.getNavigationHelper().gotoGroupPage();
    int before = application.getGroupHelper().getGroupCount();
    if(! application.getGroupHelper().isThereAGroup()){
      application.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
    }
    application.getGroupHelper().deleteGroup(before - 1);
    int after = application.getGroupHelper().getGroupCount();
    Assert.assertEquals( after, before - 1);
    application.getSessionHelper().logOut();

  }

}