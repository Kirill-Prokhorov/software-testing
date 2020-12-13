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

public class DeleteContactFromGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    application.navigationHelper.groupPage();
    Contacts contacts = application.db().contacts();
    Groups groups = application.db().groups();
    Set<GroupData> groupSet = new HashSet<>();
    if(groups.size() == 0){
      application.group().create(new GroupData().withName("Precondition"));
        }
    application.navigationHelper.groupPage();
    for (GroupData g : groups) {
      if (g.getContacts().size() != 0) {
        groupSet.add(g);
      }
    }
    application.navigationHelper.groupPage();
    if (groupSet.size() == 0 && contacts.size() != 0) {
      ContactData contact = contacts.iterator().next();
      GroupData group = groups.iterator().next();
      application.goTo().homePage();
      application.contact().addToGroup(contact, group);
    }

    if (contacts.size() < 1 ) {
      application.goTo().homePage();
      application.contact().create(new ContactData()
              .withFirstname("Precondition"),true);
    }

  }

  @Test
  public void testRemoveContactFromGroup() {
    Groups groups = application.db().groups();
    Set<GroupData> groupList = new HashSet<>();
    for (GroupData g : groups) {
      if (g.getContacts().size() != 0) {
        groupList.add(g);
      }
    }
    application.goTo().groupPage();
    GroupData group = groupList.iterator().next();
    Contacts beforeContacts = group.getContacts();
    ContactData contact = group.getContacts().iterator().next();
    Groups beforeGroups = contact.getGroups();
    application.goTo().homePage();
    application.contact().removeFromGroup(group, contact);
    Contacts afterContacts = application.db().group(group.getId()).getContacts();
    Groups afterGroups = application.db().contact(contact.getId()).getGroups();
    assertThat(afterContacts, equalTo(beforeContacts.withOut(contact)));
    assertThat(afterGroups, equalTo(beforeGroups.withOut(group)));
  }
}
