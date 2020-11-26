package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    application.goTo().homePage();
    if (application.contact().set().size() == 0) {

      application.goTo().homePage();
      application.contact().create(new ContactData().withFirstname("First Name").withLastname("Last Name")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333"), true);
      application.goTo().homePage();
    }
  }

  @Test
  public void testContactPhones(){
    application.goTo().homePage();
    ContactData contact = application.contact().set().iterator().next();
    ContactData contactInfoFromEditForm = application.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

  }

  private String mergePhones(ContactData contact) {

    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals("")).map(ContactPhoneTests :: cleaned).collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone){

    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

  }

}
