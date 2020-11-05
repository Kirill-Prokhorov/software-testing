package ru.stqa.software_testing.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook");
    login("admin", "secret");
  }
  private void login(String user, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(user);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContactCreation() throws Exception {

    initContactCreation();
    fillContactForm(new ContactDate("Otshel", "Otshelovichc", "Otshelov"));
    submitContactCreation();
    logOut();
  }


  private void fillContactForm(ContactDate contactDate) {
    firstName(contactDate.getFirstname());
    middleName(contactDate.getMiddlename());
    lastName(contactDate.getLastname());
    /*nick(contactDate.getNick());
    title(contactDate.getTitle());
    company(contactDate.getCompany());
    companyAddress(contactDate.getCompanyAddress());
    homePhone(contactDate.getHomePhone());
    mobilePhone(contactDate.getMobilePhone());
    workPhone(contactDate.getWorkPhone());
    fax(contactDate.getFax());
    email1(contactDate.getEmail1());
    email2(contactDate.getEmail2());
    email3(contactDate.getEmail3());
    homepage(contactDate.getHomepage());
    bDay(contactDate.getDayOfMonth(), contactDate.getMonth(), contactDate.getYearBday());
    aDay(contactDate.getDayOfMonth(), contactDate.getMonth(), contactDate.getYearAday());
    addContactToGroup(contactDate.getGroupContact());
    homeAddress(contactDate.getHomeAddress());
    numberHouse(contactDate.getHouseaddress());
    notes(contactDate.getNotes());*/
  }

  private void logOut() {
    wd.findElement(By.linkText("Logout")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void notes(String text) {
    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys(text);
  }

  private void numberHouse(String houseNumber) {
    wd.findElement(By.name("phone2")).click();
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys(houseNumber);
  }

  private void homeAddress(String address) {
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys(address);
  }

  private void addContactToGroup(String groupName) {
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupName);
  }

  private void aDay(String dayOfMonth, String month, String yearADay) {
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

  private void bDay(String dayOfMonth, String month, String yearBDay) {
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

  private void homepage(String homepage) {
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys(homepage);
  }

  private void email3(String email3) {
    wd.findElement(By.name("email3")).click();
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(email3);
  }

  private void email2(String email2) {
    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(email2);
  }

  private void email1(String email1) {
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(email1);
  }

  private void fax(String fax) {
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(fax);
  }

  private void workPhone(String workPhone) {
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(workPhone);
  }

  private void mobilePhone(String mobilePhone) {
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(mobilePhone);
  }

  private void homePhone(String homePhone) {
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(homePhone);
  }

  private void companyAddress(String companyAddress) {
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(companyAddress);
  }

  private void company(String company) {
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(company);
  }

  private void title(String title) {
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(title);
  }

  private void nick(String nick) {
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(nick);
  }

  private void lastName(String lName) {
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(lName);
  }

  private void middleName(String mName) {
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(mName);
  }

  private void firstName(String fname) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(fname);
  }

  private void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }


  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
