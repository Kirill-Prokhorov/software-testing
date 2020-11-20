package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import ru.stqa.software_testing.addressbook.model.ContactData;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    application.goTo().groupPage();
    if(application.group().list().size() == 0){
      application.group().create(new GroupData().withName("Test").withFooter("test3"));
    }
    application.goTo().homePage();
  }


  @Test
  public void testContactCreation() throws Exception {


    Set<ContactData> before = application.contact().set();
    ContactData contact = new ContactData().withFirstname("Created").withLastname("Contact");
    application.contact().create(contact, true);
    application.goTo().homePage();

    Set<ContactData> after = application.contact().set();
    Assert.assertEquals( after.size(), before.size()+1);


    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

  }

}
