package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.GroupData;
import ru.stqa.software_testing.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if(application.db().groups().size() == 0){

      application.goTo().groupPage();
      application.group().create(new GroupData().withName("test1").withFooter("test3"));
      application.goTo().groupPage();

    }

  }

  @Test
  public void groupModification() {

    Groups before =  application.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("change1").withHeader("test").withFooter("change3");
    application.group().modify(group );
    assertThat(application.group().count(), equalTo(before.size()));
    Groups after = application.db().groups();
    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
    verifyGroupListInUI();

  }



}
