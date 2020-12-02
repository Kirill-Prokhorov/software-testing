package ru.stqa.software_testing.addressbook.generators;

import ru.stqa.software_testing.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void main(String[] args) throws IOException {

    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContact(count);
    save(contacts, file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {

    Writer writer = new FileWriter(file);
    for(ContactData contact : contacts){
      writer.write(String.format("%s;%s;%s\n", contact.getFirstname(),contact.getLastname(), contact.getCompanyAddress()));
    }
    writer.close();
  }

  private static List<ContactData> generateContact(int count) {
    List<ContactData> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++){
      contacts.add(new ContactData().withFirstname(String.format("FirstName %s", i)).withLastname(String.format("LastName %s", i))
              .withCompanyAddress(String.format("Elm st, house № %s", i)));
    }
    return contacts;
  }
}
