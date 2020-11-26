package ru.stqa.software_testing.addressbook.tests;

import ru.stqa.software_testing.addressbook.model.GroupData;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    application.goTo().groupPage();
    Groups before = application.group().set();
    GroupData group = new GroupData().withName("Test00").withHeader("test2");
    application.group().create(group);
    application.goTo().groupPage();
    assertThat(application.group().count(), equalTo(before.size()+1));
    Groups after = application.group().set();
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt()))));
  }

  @Test
  public void testGroupBadCreation() throws Exception {

    application.goTo().groupPage();
    Groups before = application.group().set();
    GroupData group = new GroupData().withName("Bad'").withHeader("test2");
    application.group().create(group);
    application.goTo().groupPage();
    assertThat( application.group().count(), equalTo(before.size()));
    Groups after = application.group().set();
    assertThat(after, equalTo(before));
  }

}
