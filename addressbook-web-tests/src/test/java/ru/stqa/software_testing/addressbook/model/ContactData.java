package ru.stqa.software_testing.addressbook.model;

import java.util.Objects;

public class ContactData {
  public int id = Integer.MAX_VALUE;
  public String firstname = null;;
  public String middlename = null;;
  public String lastname = null;;
  public String nick = null;;
  public String title = null;;
  public String company = null;;
  public String companyAddress = null;;
  public String homePhone = null;;
  public String mobilePhone = null;;
  public String workPhone = null;;
  public String fax = null;;
  public String email1 = null;;
  public String email2 = null;;
  public String email3 = null;;

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }

  public String homepage = null;;
  public String dayOfMonth = null;;
  public String month = null;;
  public String yearBday = null;;
  public String yearAday = null;;
  public String groupContact = null;;
  public String homeAddress = null;;
  public String houseaddress = null;;
  public String notes = null;;

  public void setId(int id) {
    this.id = id;
  }

  public ContactData(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
    //this.id = id;


  }
  public ContactData(String firstname, String lastname, String groupContact) {
    this.firstname = firstname;
    this.lastname = lastname;
    this. groupContact = groupContact;

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

  public String getMiddleName() {
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

  public String getYearBDay() {
    return yearBday;
  }

  public String getYearADay() {
    return yearAday;
  }

  public String getGroupContact() {
    return groupContact;
  }

  public String getHomeAddress() {
    return homeAddress;
  }

  public String getHouseAddress() {
    return houseaddress;
  }

  public String getNotes() {
    return notes;
  }

  public  int getId() {
    return id;
  }
}
