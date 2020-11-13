package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import ru.stqa.software_testing.addressbook.model.GroupData;
import org.testng.annotations.*;



public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    application.getNavigationHelper().gotoGroupPage();
    int before = application.getGroupHelper().getGroupCount();
    application.getGroupHelper().createGroup(new GroupData("Test", "test2", null));
    int after = application.getGroupHelper().getGroupCount();
    Assert.assertEquals( after, before + 1);
  }

}
