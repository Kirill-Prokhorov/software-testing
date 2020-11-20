package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import ru.stqa.software_testing.addressbook.model.GroupData;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    application.goTo().groupPage();
    List<GroupData> before = application.group().list();
    GroupData group = new GroupData().withName("Test00").withHeader("test2");
    application.group().create(group);
    application.goTo().groupPage();
    List<GroupData> after = application.group().list();
    Assert.assertEquals( after.size(), before.size() + 1);


    Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
    after.sort(byId);
    group.withId(after.get(after.size() - 1).getId());
    before.add(group);
    before.sort(byId);
    Assert.assertEquals( before, after);
  }

}
