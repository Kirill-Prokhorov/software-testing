package ru.stqa.software_testing.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.Contacts;
import ru.stqa.software_testing.addressbook.model.GroupData;
import ru.stqa.software_testing.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @DataProvider
  public Iterator<Object[]> validContactsXML() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader("src/test/Resources/contacts.xml"))){
      String xml = "";
      String line = reader.readLine();
      while(line != null){
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }


  }

  @DataProvider
  public Iterator<Object[]> validContactsJson() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader("src/test/Resources/contacts.json"))){
      String json = "";
      String line = reader.readLine();
      while(line != null){
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

  }

  @BeforeMethod
  public void ensurePreconditions(){
    if(application.db().groups().size() == 0){
      application.group().create(new GroupData().withName("Test").withFooter("test3"));
    }
  }


  @Test (dataProvider = "validContactsXML")
  public void testContactCreation(ContactData contact) throws Exception {

    Groups allGroups = application.db().groups();
    File photo = new File("src/test/Resources/Freddy.jpg");
    contact.withPhoto(photo);
    Contacts before = application.db().contacts();
    application.contact().create(contact.inGroup(allGroups.iterator().next()), true);
    assertThat(application.contact().count(), equalTo(before.size() + 1));
    Contacts after = application.db().contacts();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));


  }
  /*
  @Test
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/Resources/Freddy.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
  */

}
