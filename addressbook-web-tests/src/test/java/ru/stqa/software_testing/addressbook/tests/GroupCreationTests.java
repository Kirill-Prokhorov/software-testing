package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import ru.stqa.software_testing.addressbook.model.GroupData;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    application.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = application.getGroupHelper().getGroupList();
    GroupData group = new GroupData("Test00", "test2", null);
    application.getGroupHelper().createGroup(group);
    List<GroupData> after = application.getGroupHelper().getGroupList();
    Assert.assertEquals( after.size(), before.size() + 1);


    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    after.sort(byId);
    group.setId(after.get(after.size() - 1).getId());
    before.add(group);
    before.sort(byId);
    //group.setId(after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId());
    //before.add(group);
    //Assert.assertEquals( new HashSet<>(before), new HashSet<>(after));
    Assert.assertEquals( before, after);
  }

}
