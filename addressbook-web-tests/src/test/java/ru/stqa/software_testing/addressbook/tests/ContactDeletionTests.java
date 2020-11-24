package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.Contacts;
import ru.stqa.software_testing.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    application.goTo().homePage();
    if (application.contact().set().size() == 0) {

      application.goTo().groupPage();
      application.group().create(new GroupData().withName("Test").withHeader("test2"));
      application.goTo().homePage();
      application.contact().create(new ContactData().withFirstname("First Name").withLastname("Last Name"), true);
      application.goTo().homePage();
    }
  }


  @Test
  public void testContactDeletion() throws Exception {

    Contacts before = application.contact().set();
    ContactData deletedContact = before.iterator().next();
    application.contact().delete(deletedContact);
    application.goTo().homePage();
    Contacts after = application.contact().set();
    assertEquals( after.size(), before.size()-1);
    before.remove(deletedContact);
    assertEquals(before, after);
    assertThat(after, equalTo(before.withOut(deletedContact)));



  }

}

