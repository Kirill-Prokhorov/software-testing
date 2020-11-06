package appManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import model.ContactData;

import static org.testng.Assert.assertTrue;

public class ContactHelper {

  public WebDriver wd;
  public boolean acceptNextAlert = true;

  public ContactHelper(WebDriver wd) {

    this.wd = wd;
  }

  public void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
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
    wd.findElement(By.name("selected[]")).click();
  }

  public void deleteSelectedContact() {
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    wd.findElement(By.name("MainForm")).click();
  }

  public void notes(String text) {
    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys(text);
  }

  public void numberHouse(String houseNumber) {
    wd.findElement(By.name("phone2")).click();
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys(houseNumber);
  }

  public void homeAddress(String address) {
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys(address);
  }

  public void addContactToGroup(String groupName) {
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupName);
  }

  public void aDay(String dayOfMonth, String month, String yearADay) {
    wd.findElement(By.name("aday")).click();
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText(dayOfMonth);
    wd.findElement(By.name("aday")).click();
    wd.findElement(By.name("amonth")).click();
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(month);
    wd.findElement(By.name("amonth")).click();
    wd.findElement(By.name("ayear")).click();
    wd.findElement(By.name("ayear")).clear();
    wd.findElement(By.name("ayear")).sendKeys(yearADay);
  }

  public void bDay(String dayOfMonth, String month, String yearBDay) {
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(dayOfMonth);
    wd.findElement(By.name("bday")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(month);
    wd.findElement(By.name("bmonth")).click();
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(yearBDay);
  }

  public void homepage(String homepage) {
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys(homepage);
  }

  public void email3(String email3) {
    wd.findElement(By.name("email3")).click();
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(email3);
  }

  public void email2(String email2) {
    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(email2);
  }

  public void email1(String email1) {
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(email1);
  }

  public void firstName(String fname) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(fname);
  }

  public void fax(String fax) {
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(fax);
  }

  public void workPhone(String workPhone) {
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(workPhone);
  }

  public void mobilePhone(String mobilePhone) {
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(mobilePhone);
  }

  public void homePhone(String homePhone) {
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(homePhone);
  }

  public void companyAddress(String companyAddress) {
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(companyAddress);
  }

  public void company(String company) {
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(company);
  }

  public void title(String title) {
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(title);
  }

  public void nick(String nick) {
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(nick);
  }

  public void lastName(String lName) {
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(lName);
  }

  public void middleName(String mName) {
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(mName);
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
