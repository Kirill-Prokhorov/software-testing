package ru.stqa.software_testing.addressbook.tests;

import ru.stqa.software_testing.addressbook.model.GroupData;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/Resources/groups.csv")));
    String line = reader.readLine();
    while(line != null){
      String[] split = line.split(";");
      list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      line = reader.readLine();
    }
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
