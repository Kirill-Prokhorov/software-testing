package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.GroupData;
import ru.stqa.software_testing.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    application.goTo().groupPage();
    if(application.group().set().size() == 0){
      application.group().create(new GroupData().withName("test1").withFooter("test3"));
    }
    application.goTo().groupPage();
  }

  @Test
  public void groupModification() {



    Groups before =  application.group().set();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("change1").withHeader("test").withFooter("change3");
    application.group().modify(group );
    application.goTo().groupPage();
    Groups after = application.group().set();
    assertEquals( after.size(), before.size());
    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));


  }

}
