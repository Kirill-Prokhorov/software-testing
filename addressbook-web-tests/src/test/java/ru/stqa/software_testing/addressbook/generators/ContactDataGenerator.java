package ru.stqa.software_testing.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.software_testing.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();

    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }
    catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();


  }
  private void run() throws IOException {
    List<ContactData> contacts = generateContact(count);
    save(contacts, new File(file));

  }


  private void save(List<ContactData> contacts, File file) throws IOException {

    Writer writer = new FileWriter(file);
    for(ContactData contact : contacts){
      writer.write(String.format("%s;%s;%s\n", contact.getFirstname(),contact.getLastname(), contact.getCompanyAddress()));
    }
    writer.close();
  }

  private List<ContactData> generateContact(int count) {
    List<ContactData> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++){
      contacts.add(new ContactData().withFirstname(String.format("FirstName %s", i)).withLastname(String.format("LastName %s", i))
              .withCompanyAddress(String.format("Elm st, house № %s", i)));
    }
    return contacts;
  }
}
