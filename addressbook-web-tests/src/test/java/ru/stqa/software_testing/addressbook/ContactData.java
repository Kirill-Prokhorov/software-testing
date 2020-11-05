package ru.stqa.software_testing.addressbook;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nick;
  private final String title;
  private final String company;
  private final String companyAddress;
  private final String homePhone;
  private final String mobilePhone;
  private final String workPhone;
  private final String fax;
  private final String email1;
  private final String email2;
  private final String email3;
  private final String homepage;
  private final String dayOfMonth;
  private final String month;
  private final String yearBday;
  private final String yearAday;
  private final String groupContact;
  private final String homeAddress;
  private final String houseaddress;
  private final String notes;

  public ContactData(String firstname, String middlename, String lastname) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nick = null;
    this.title = null;
    this.company = null;
    this.companyAddress = null;
    this.homePhone = null;
    this.mobilePhone = null;
    this.workPhone = null;
    this.fax = null;
    this.email1 = null;
    this.email2 = null;
    this.email3 = null;
    this.homepage = null;
    this.dayOfMonth = null;
    this.month = null;
    this.yearBday = null;
    this.yearAday = null;
    this.groupContact = null;
    this.homeAddress = null;
    this.houseaddress = null;
    this.notes = null;
  }

  public ContactData(String firstname, String middlename, String lastname, String nick, String title, String company, String companyAddress, String homePhone, String mobilePhone, String workPhone, String fax, String email1, String email2, String email3, String homepage, String dayOfMonth, String month, String yearBday, String yearAday, String groupContact, String homeAddress, String houseaddress, String notes) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nick = nick;
    this.title = title;
    this.company = company;
    this.companyAddress = companyAddress;
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.fax = fax;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
    this.dayOfMonth = dayOfMonth;
    this.month = month;
    this.yearBday = yearBday;
    this.yearAday = yearAday;
    this.groupContact = groupContact;
    this.homeAddress = homeAddress;
    this.houseaddress = houseaddress;
    this.notes = notes;
  }


  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNick() {
    return nick;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getCompanyAddress() {
    return companyAddress;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getDayOfMonth() {
    return dayOfMonth;
  }

  public String getMonth() {
    return month;
  }

  public String getYearBday() {
    return yearBday;
  }

  public String getYearAday() {
    return yearAday;
  }

  public String getGroupContact() {
    return groupContact;
  }

  public String getHomeAddress() {
    return homeAddress;
  }

  public String getHouseaddress() {
    return houseaddress;
  }

  public String getNotes() {
    return notes;
  }
}
