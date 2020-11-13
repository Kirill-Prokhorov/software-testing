package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void groupModification() {

    application.getNavigationHelper().gotoGroupPage();
    if(! application.getGroupHelper().isThereAGroup()){
      application.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
    }
    List<GroupData> before = application.getGroupHelper().getGroupList();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "change1", "test", "change3");
    application.getGroupHelper().modificationGroup( group, before.size() - 1 );
    List<GroupData> after = application.getGroupHelper().getGroupList();
    Assert.assertEquals( after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals( new HashSet<>(before), new HashSet<>(after));
    application.getSessionHelper().logOut();

  }

}
