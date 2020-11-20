package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    application.goTo().groupPage();
    if(! application.group().isThereAGroup()){
      application.group().create(new GroupData().withName("test1").withFooter("test3"));
    }
    application.goTo().groupPage();
  }


  @Test
  public void testGroupDeletion() throws Exception {

    Set<GroupData> before = application.group().set();
    GroupData deletedGroup = before.iterator().next();
    application.group().delete(deletedGroup);
    application.goTo().groupPage();
    Set<GroupData> after = application.group().set();
    Assert.assertEquals( after.size(), before.size() - 1);

    before.remove(deletedGroup);
    Assert.assertEquals(before, after);



  }

}