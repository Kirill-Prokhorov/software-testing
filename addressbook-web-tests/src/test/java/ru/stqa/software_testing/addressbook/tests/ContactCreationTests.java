package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.Contacts;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts(){
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[] {"FirstName 1", "LastName 1", "Elm st. 1"});
    list.add(new Object[] {"FirstName 2", "LastName 2", "Elm st. 2"});
    list.add(new Object[] {"FirstName 3", "LastName 3", "Elm st. 3"});
    return list.iterator();
  }

  @BeforeMethod
  public void ensurePreconditions(){
    application.goTo().groupPage();
    if(application.group().set().size() == 0){
      application.group().create(new GroupData().withName("Test").withFooter("test3"));
    }
    application.goTo().homePage();
  }


  @Test (dataProvider = "validContacts")
  public void testContactCreation(String firstName, String lastName, String companyAddress) throws Exception {

      File photo = new File("src/test/Resources/Freddy.jpg");
      ContactData contact = new ContactData().withFirstname(firstName).withLastname(lastName).withHomePhone("111")
              .withMobilePhone("222").withWorkPhone("333").withCompanyAddress(companyAddress)
              .withEmail1("Fred@ ").withEmail2(" Kruger@").withEmail3("Nightmare@").withPhoto(photo);
      Contacts before = application.contact().set();
      application.contact().create(contact, true);
      application.goTo().homePage();
      assertThat(application.contact().count(), equalTo(before.size() + 1));
      Contacts after = application.contact().set();
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
