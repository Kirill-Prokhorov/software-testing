package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.Contacts;
import ru.stqa.software_testing.addressbook.model.GroupData;
import ru.stqa.software_testing.addressbook.model.Groups;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddContactToGroupTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {

    Contacts contacts = application.db().contacts();
    Groups groups = application.db().groups();
    Set<ContactData> contactListOutOfGroups = new HashSet<>();
    for (ContactData c : contacts) {
      if (c.getGroups().size() != groups.size()) {
        contactListOutOfGroups.add(c);
      }
    }
    if (contactListOutOfGroups.size() == 0) {
      application.contact().create(new ContactData().withFirstname("PreconditionContact"), true);

    }
    if (groups.size() == 0) {
      application.group().create(new GroupData().withName("PreconditionGroup"));
    }
  }

  @Test
  public void testAddContactToGroup() {
    Contacts contacts = application.db().contacts();
    Groups groups = application.db().groups();
    Set<ContactData> contactListOutOfAllGroups = new HashSet<>();
    for (ContactData c : contacts) {
      if (c.getGroups().size() != groups.size()) {
        contactListOutOfAllGroups.add(c);
      }
    }
    ContactData contact = contactListOutOfAllGroups.iterator().next();
    Set<GroupData> groupListOutOfThisContacts = new HashSet<>();
    for (GroupData g : groups) {
      if (!g.getContacts().contains(contact)) {
        groupListOutOfThisContacts.add(g);
      }
    }
    GroupData group = groupListOutOfThisContacts.iterator().next();
    Contacts beforeContacts = group.getContacts();
    Groups beforeGroups = contact.getGroups();
    application.goTo().homePage();
    application.contact().addToGroup(contact, group);
    Contacts afterContacts = application.db().group(group.getId()).getContacts();
    Groups afterGroups = application.db().contact(contact.getId()).getGroups();
    assertThat(afterContacts, equalTo(beforeContacts.withAdded(contact)));
    assertThat(afterGroups, equalTo(beforeGroups.withAdded(group) ));

  }

}
