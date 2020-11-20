package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.List;


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

    List<GroupData> before = application.group().list();
    int index = before.size() - 1;
    application.group().delete(index);
    application.goTo().groupPage();
    List<GroupData> after = application.group().list();
    Assert.assertEquals( after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);



  }

}