package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    application.goTo().homePage();
    if (application.contact().list().size() == 0) {

      application.goTo().groupPage();
      application.group().create(new GroupData().withName("Test").withHeader("test2"));
      application.goTo().homePage();
      application.contact().create(new ContactData().withFirstname("First Name").withLastname("Last Name"), true);
    }
    application.goTo().homePage();
  }

  @Test
  public void testContactModification() {


    Set<ContactData> before = application.contact().set();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Changed").withLastname("Changed Last");
    application.contact().modify(contact, false);
    application.goTo().homePage();
    Set<ContactData> after = application.contact().set();
    Assert.assertEquals( after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);



  }

}
