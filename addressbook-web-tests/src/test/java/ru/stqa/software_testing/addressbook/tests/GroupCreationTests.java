package ru.stqa.software_testing.addressbook.tests;

import ru.stqa.software_testing.addressbook.model.GroupData;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[] {new GroupData().withName("test1").withHeader("Header 1").withFooter("Footer 1")});
    list.add(new Object[] {new GroupData().withName("test2").withHeader("Header 2").withFooter("Footer 2")});
    list.add(new Object[] {new GroupData().withName("test3").withHeader("Header 3").withFooter("Footer 3")});
    return list.iterator();
  }


  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {

      application.goTo().groupPage();
      Groups before = application.group().set();
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
