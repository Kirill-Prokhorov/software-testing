package ru.stqa.software_testing.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import ru.stqa.software_testing.addressbook.model.GroupData;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.Groups;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {


  @DataProvider
  public Iterator<Object[]> validGroupsXML() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader("src/test/Resources/groups.xml"))){
      String xml = "";
      String line = reader.readLine();
      while(line != null){
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
      return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

  }

  @DataProvider
  public Iterator<Object[]> validGroupsJson() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader("src/test/Resources/groups.json"))){
      String json = "";
      String line = reader.readLine();
      while(line != null){
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType());
      return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

  }


  @Test(dataProvider = "validGroupsJson")
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
