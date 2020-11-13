package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import ru.stqa.software_testing.addressbook.model.GroupData;
import org.testng.annotations.*;

import java.util.List;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    application.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = application.getGroupHelper().getGroupList();
    application.getGroupHelper().createGroup(new GroupData("Test", "test2", null));
    List<GroupData> after = application.getGroupHelper().getGroupList();
    Assert.assertEquals( after.size(), before.size() + 1);
  }

}
