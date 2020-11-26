package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.Contacts;
import ru.stqa.software_testing.addressbook.model.GroupData;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    application.goTo().homePage();
    if (application.contact().set().size() == 0) {

      application.goTo().groupPage();
      application.group().create(new GroupData().withName("Test").withHeader("test2"));
      application.goTo().homePage();
      application.contact().create(new ContactData().withFirstname("First Name").withLastname("Last Name"), true);
    }
    application.goTo().homePage();
  }

  @Test
  public void testContactModification() {


    Contacts before = application.contact().set();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Changed").withLastname("Changed Last");
    application.contact().modify(contact, false);
    application.goTo().homePage();
    assertThat( application.contact().count(), equalTo(before.size()));
    Set<ContactData> after = application.contact().set();
    assertThat(after, equalTo((before).withOut(modifiedContact).withAdded(contact)));




  }

}
