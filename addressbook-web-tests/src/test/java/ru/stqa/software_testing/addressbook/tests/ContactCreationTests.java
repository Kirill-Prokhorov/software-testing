package ru.stqa.software_testing.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import ru.stqa.software_testing.addressbook.model.ContactData;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.Contacts;
import ru.stqa.software_testing.addressbook.model.GroupData;
import java.util.Set;
import java.util.function.ToIntFunction;

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


    //contact.withId(after.stream().mapToInt((ToIntFunction<? super ContactData>) after.stream().mapToInt(ContactData::getId)).max().getAsInt());
    //before.add(contact);
    //assertEquals(before, after);
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withAdded(contact.withId(after.stream()
            .mapToInt((ToIntFunction<? super ContactData>) after.stream().mapToInt(ContactData::getId)).max().getAsInt()))));

  }

}
