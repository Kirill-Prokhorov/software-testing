package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.GroupData;
import ru.stqa.software_testing.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    application.goTo().groupPage();
    if(application.group().set().size() == 0){
      application.group().create(new GroupData().withName("test1").withFooter("test3"));
    }
    application.goTo().groupPage();
  }


  @Test
  public void testGroupDeletion() throws Exception {

    Groups before =  application.group().set();
    GroupData deletedGroup = before.iterator().next();
    application.group().delete(deletedGroup);
    application.goTo().groupPage();
    Groups after = application.group().set();
    assertEquals( after.size(), before.size()-1);
    assertThat(after, equalTo(before.withOut(deletedGroup)));



  }

}