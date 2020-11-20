package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    application.goTo().homePage();
    if (application.contact().list().size() == 0) {

      application.goTo().groupPage();
      application.group().create(new GroupData().withName("Test").withHeader("test2"));
      application.goTo().homePage();
      application.contact().create(new ContactData().withFirstname("First Name").withLastname("Last Name"), true);
      application.goTo().homePage();
    }
  }


  @Test
  public void testContactDeletion() throws Exception {

    List<ContactData> before = application.contact().list();
    ContactData deletedContact = before.iterator().next();
    application.contact().delete(deletedContact);
    application.goTo().homePage();
    List<ContactData> after = application.contact().list();
    Assert.assertEquals( after.size(), before.size()-1);
    before.remove(deletedContact);
    Assert.assertEquals(before, after);


  }

}

