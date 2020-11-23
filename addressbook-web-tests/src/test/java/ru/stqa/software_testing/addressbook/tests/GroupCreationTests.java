package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import ru.stqa.software_testing.addressbook.model.GroupData;
import org.testng.annotations.*;
import java.util.Set;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    application.goTo().groupPage();
    Set<GroupData> before = application.group().set();
    GroupData group = new GroupData().withName("Test00").withHeader("test2");
    application.group().create(group);
    application.goTo().groupPage();
    Set<GroupData> after = application.group().set();
    Assert.assertEquals( after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals( before, after);
  }

}
