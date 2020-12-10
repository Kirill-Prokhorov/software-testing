package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.GroupData;
import ru.stqa.software_testing.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if(application.db().groups().size() == 0){
      application.group().create(new GroupData().withName("test1").withFooter("test3"));
    }
  }


  @Test
  public void testGroupDeletion() throws Exception {

    Groups before =  application.db().groups();
    GroupData deletedGroup = before.iterator().next();
    application.group().delete(deletedGroup);
    assertThat(application.group().count(), equalTo(before.size()-1));
    Groups after = application.db().groups();
    assertThat(after, equalTo(before.withOut(deletedGroup)));
    verifyGroupListInUI();
  }

}