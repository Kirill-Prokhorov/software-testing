package ru.stqa.software_testing.addressbook.appManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.software_testing.addressbook.model.ContactData;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {

    super(wd);

  }

  public void initContactCreation() {

    click(By.linkText("add new"));

  }

  public void fillContactForm(ContactData contactData) {

    firstName(contactData.getFirstname());
    middleName(contactData.getMiddleName());
    lastName(contactData.getLastname());

  }

  public void fillFullContactForm(ContactData contactData) {

    firstName(contactData.getFirstname());
    middleName(contactData.getMiddleName());
    lastName(contactData.getLastname());
    firstName(contactData.getFirstname());
    middleName(contactData.getMiddleName());
    lastName(contactData.getLastname());
    nick(contactData.getNick());
    title(contactData.getTitle());
    company(contactData.getCompany());
    companyAddress(contactData.getCompanyAddress());
    homePhone(contactData.getHomePhone());
    mobilePhone(contactData.getMobilePhone());
    workPhone(contactData.getWorkPhone());
    fax(contactData.getFax());
    email1(contactData.getEmail1());
    email2(contactData.getEmail2());
    email3(contactData.getEmail3());
    homepage(contactData.getHomepage());
    bDay(contactData.getDayOfMonth(), contactData.getMonth(), contactData.getYearBDay());
    aDay(contactData.getDayOfMonth(), contactData.getMonth(), contactData.getYearADay());
    addContactToGroup(contactData.getGroupContact());
    homeAddress(contactData.getHomeAddress());
    numberHouse(contactData.getHouseAddress());
    notes(contactData.getNotes());

  }

  public void selectContact() {

    click(By.name("selected[]"));

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


  public void initContactModification() {

    click(By.xpath("//img[@alt='Edit']"));

  }
  public void submitContactModification() {

    click(By.name("update"));
  }
}
