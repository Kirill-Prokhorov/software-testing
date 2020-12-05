package ru.stqa.software_testing.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.software_testing.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneEmailAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    application.goTo().homePage();
    if (application.contact().set().size() == 0) {

      application.goTo().homePage();
      application.contact().create(new ContactData().withFirstname("First Name").withLastname("Last Name")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withCompanyAddress("  Elm st.  ")
              .withEmail1("Fred@ ").withEmail2(" Kruger@").withEmail3("Nightmare@"), true);
      application.goTo().homePage();
    }
  }

  @Test
  public void testContactPhones(){
    application.goTo().homePage();
    ContactData contact = application.contact().set().iterator().next();
    ContactData contactInfoFromEditForm = application.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getCompanyAddress(), equalTo(contactInfoFromEditForm.getCompanyAddress().trim()));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));



  }

  private String mergePhones(ContactData contact) {

    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals("")).map(ContactPhoneEmailAddressTests :: cleaned).collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone){

    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

  }

  private String mergeEmails(ContactData contact) {

    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals("")).map(String :: trim).collect(Collectors.joining("\n"));

  }

}
