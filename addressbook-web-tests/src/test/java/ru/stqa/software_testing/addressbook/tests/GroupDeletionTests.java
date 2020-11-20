package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.List;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    application.getNavigationHelper().gotoGroupPage();
    if(! application.getGroupHelper().isThereAGroup()){
      application.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
    }
  }


  @Test
  public void testGroupDeletion() throws Exception {

    List<GroupData> before = application.getGroupHelper().getGroupList();

    application.getGroupHelper().deleteGroup(before.size() - 1);
    List<GroupData> after = application.getGroupHelper().getGroupList();
    Assert.assertEquals( after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);



  }

}