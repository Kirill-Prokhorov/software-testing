package ru.stqa.software_testing.addressbook.appManager;

import org.openqa.selenium.*;
import org.testng.Assert;
import ru.stqa.software_testing.addressbook.model.ContactData;
import ru.stqa.software_testing.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {

    super(wd);

  }

  public void initContactCreation() {

    click(By.linkText("add new"));

  }

  public void fillContactForm(ContactData contactData, boolean creation) {

    firstName(contactData.getFirstname());
    lastName(contactData.getLastname());
    mobilePhone(contactData.getMobilePhone());
    homePhone(contactData.getHomePhone());
    workPhone(contactData.getWorkPhone());
    companyAddress(contactData.getCompanyAddress());
    email1(contactData.getEmail1());
    email2(contactData.getEmail2());
    email3(contactData.getEmail3());


    if(creation){
      addContactToGroup(contactData.getGroupContact());
    }
    else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }



  public void deleteSelectedContact() {

    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();

  }

  public void notes(String text) {

    type(By.name("notes"), text);

  }

  public void numberHouse(String houseNumber) {

    type(By.name("phone2"), houseNumber);

  }

  public void homeAddress(String address) {

    type(By.name("address2"), address);

  }

  public void addContactToGroup(String groupName) {


    findAndSelect(By.name("new_group"), groupName);

  }

  public void aDay(String dayOfMonth, String month, String yearADay) {

    click(By.name("aday"));
    findAndSelect(By.name("aday"), dayOfMonth);
    click(By.name("aday"));
    click(By.name("amonth"));
    findAndSelect(By.name("amonth"), month);
    click(By.name("amonth"));
    type(By.name("ayear"), yearADay);

  }

  public void bDay(String dayOfMonth, String month, String yearBDay) {

    click(By.name("bday"));
    findAndSelect(By.name("bday"), dayOfMonth);
    click(By.name("bday"));
    click(By.name("bmonth"));
    findAndSelect(By.name("bmonth"), month);
    click(By.name("bmonth"));
    type(By.name("byear"), yearBDay);

  }

  public void returnToHomePage() {

    click(By.linkText("home page"));

  }

  public void homepage(String homepage) {

    type(By.name("homepage"), homepage);

  }

  public void email3(String email3) {

    type(By.name("email3"), email3);

  }

  public void email2(String email2) {

    type(By.name("email2"), email2);

  }

  public void email1(String email1) {

    type(By.name("email"), email1);

  }

  public void firstName(String fname) {

    type(By.name("firstname"), fname);

  }

  public void fax(String fax) {

    type(By.name("fax"), fax);

  }

  public void workPhone(String workPhone) {

    type(By.name("work"), workPhone);

  }

  public void mobilePhone(String mobilePhone) {

    type(By.name("mobile"), mobilePhone);

  }

  public void homePhone(String homePhone) {

    type(By.name("home"), homePhone);

  }

  public void companyAddress(String companyAddress) {

    type(By.name("address"), companyAddress);

  }

  public void company(String company) {

    type(By.name("company"), company);

  }

  public void title(String title) {

    type(By.name("title"), title);

  }

  public void nick(String nick) {

    type(By.name("nickname"), nick);

  }

  public void lastName(String lName) {

    type(By.name("lastname"), lName);

  }

  public void middleName(String mName) {

    type(By.name("middlename"), mName);

  }

  public void submitContactCreation() {

    click(By.xpath("(//input[@name='submit'])[2]"));
  }

    public void initContactModification(int index) {

    wd.findElements(By.cssSelector("[alt = Edit]")).get(index).click();

  }

  public void initContactModificationById(int id) {

   wd.findElement(By.cssSelector("a[href='edit.php?id="+ id +"")).click();
   //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();


  }
  public void submitContactModification() {

    click(By.name("update"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//img[@alt='Edit']"));
  }

  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact, b);
    submitContactCreation();
    contactsCache = null;

  }

  public void modify(ContactData contact, boolean b) {
    initContactModificationById(contact.getId());
    fillContactForm(contact, b);
    submitContactModification();
    contactsCache = null;
    returnToHomePage();
  }

  private Contacts contactsCache = null;

  public Contacts set() {

    if(contactsCache != null){
      return new Contacts(contactsCache);
    }
    contactsCache = new Contacts();
    List<WebElement> elementsTR = wd.findElements(By.cssSelector("[name = entry]"));//xpath(//tr[@name = 'entry'])
    for (WebElement element : elementsTR){

      List<WebElement> elementsTD = element.findElements(By.cssSelector("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = elementsTD.get(1).getText();
      String firstname = elementsTD.get(2).getText();
      String companyAddress = elementsTD.get(3).getText();
      String allEmails = elementsTD.get(4).getText();
      String allPhones = elementsTD.get(5).getText();

      contactsCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones).withCompanyAddress(companyAddress).withAllEmails(allEmails));

    }
    return new Contacts(contactsCache);
  }
  public int count (){
    return wd.findElements(By.name("selected[]")).size();

  }

  public void selectContact(int index) {

    wd.findElements(By.name("selected[]")).get(index).click();

  }
  public void selectContactById(int id) {

    wd.findElement(By.cssSelector("input[ value = '" + id + "'")).click();

  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactsCache = null;
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContact();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String companyAddress = wd.findElement(By.name("address")).getText();
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(homePhone)
            .withMobilePhone(mobilePhone).withWorkPhone(workPhone).withEmail1(email1)
            .withEmail2(email2).withEmail3(email3).withCompanyAddress(companyAddress);

  }
}
