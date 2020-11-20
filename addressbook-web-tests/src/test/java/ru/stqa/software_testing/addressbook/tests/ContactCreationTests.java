package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import ru.stqa.software_testing.addressbook.model.ContactData;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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


    List<ContactData> before = application.contact().list();
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    ContactData contact = new ContactData().withFirstname("Created").withLastname("Contact");
    application.contact().create(contact, true);
    application.goTo().homePage();

    List<ContactData> after = application.contact().list();
    Assert.assertEquals( after.size(), before.size()+1);

    after.sort(byId);
    contact.withId(after.get(after.size()-1).getId());
    before.add(contact);//after.get(after.size()-1)

    before.sort(byId);
    Assert.assertEquals(before, after);

  }

}
