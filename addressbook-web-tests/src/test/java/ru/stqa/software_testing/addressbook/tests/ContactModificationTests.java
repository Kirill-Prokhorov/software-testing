package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.Contacts;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.io.File;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (application.db().contacts().size() == 0) {

      application.contact().create(new ContactData().withFirstname("First Name").withLastname("Last Name")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withCompanyAddress("  Elm st.  ")
              .withEmail1("Fred@ ").withEmail2(" Kruger@").withEmail3("Nightmare@"), true);
    }
  }

  @Test
  public void testContactModification() {

    Contacts before = application.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Changed")
            .withLastname("Changed Last").withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
            .withCompanyAddress("Elm st.").withEmail1("Fred@ ").withEmail2("Kruger@").withEmail3("Nightmare@").withPhoto(new File("src/test/Resources/Freddy.jpg"));
    application.contact().modify(contact, false);
    assertThat( application.contact().count(), equalTo(before.size()));
    Set<ContactData> after = application.db().contacts();
    assertThat(after, equalTo((before).withOut(modifiedContact).withAdded(contact)));

  }

}
