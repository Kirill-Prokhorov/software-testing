package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.Contacts;
import ru.stqa.software_testing.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    application.goTo().groupPage();
    if(application.group().set().size() == 0){
      application.group().create(new GroupData().withName("Test").withFooter("test3"));
    }
    application.goTo().homePage();
  }


  @Test
  public void testContactCreation() throws Exception {


    Contacts before = application.contact().set();
    ContactData contact = new ContactData().withFirstname("Created").withLastname("Contact");
    application.contact().create(contact, true);
    application.goTo().homePage();

    Contacts after = application.contact().set();
    assertEquals( after.size(), before.size()+1);

    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));

  }

}
