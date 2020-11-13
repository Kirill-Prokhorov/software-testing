package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void groupModification() {

    application.getNavigationHelper().gotoGroupPage();
    if(! application.getGroupHelper().isThereAGroup()){
      application.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
    }
    List<GroupData> before = application.getGroupHelper().getGroupList();
    application.getGroupHelper().modificationGroup(new GroupData("change1", "test", "change3"), before.size() - 1);
    List<GroupData> after = application.getGroupHelper().getGroupList();
    Assert.assertEquals( after.size(), before.size());
    application.getSessionHelper().logOut();

  }

}
