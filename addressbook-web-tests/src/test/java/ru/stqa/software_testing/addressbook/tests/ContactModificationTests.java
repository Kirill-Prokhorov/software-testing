package ru.stqa.software_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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


    List<ContactData> before = application.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("Changed").withLastname("Changed Last");
    application.contact().modify(index, contact, false);
    application.goTo().homePage();
    List<ContactData> after = application.contact().list();
    Assert.assertEquals( after.size(), before.size());

    before.remove(index);
    before.add(index, contact);//after.get(0)
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);



  }

}
