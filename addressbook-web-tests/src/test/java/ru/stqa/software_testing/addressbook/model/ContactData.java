package ru.stqa.software_testing.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.checkerframework.checker.units.qual.C;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contacts")
@Entity
@Table(name="addressbook")

public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name="id")
  @Type(type = "int")
  public int id;
  @Expose
  @Column(name = "firstname")
  public String firstname;
  @Transient
  public String middleName;
  @Expose
  @Column(name = "lastname")
  public String lastname;
  @Transient
  public String nick;
  @Transient
  public String title;
  @Transient
  public String company;
  @Expose
  @Column(name = "address")
  @Type(type = "text")
  public String companyAddress;
  @Column(name = "home")
  @Type(type = "text")
  public String homePhone;
  @Column(name = "mobile")
  @Type(type = "text")
  public String mobilePhone;
  @Column(name = "work")
  @Type(type = "text")
  public String workPhone;
  @Transient
  public String allPhones;
  @Transient
  public String fax;
  @Transient
  public String email1;
  @Transient
  public String email2;
  @Transient
  public String email3;
  @Transient
  public String allEmails;
  @Transient
  public String homepage;
  @Transient
  public String dayOfMonth;
  @Transient
  public String month;
  @Transient
  public String yearBday;
  @Transient
  public String yearAday;
  @Transient
  public String groupContact = "[none]";
  @Transient
  public String homeAddress;
  @Transient
  public String houseAddress;
  @Transient
  public String notes;
  @Column(name = "photo")
  @Type(type = "text")
  public String photo;

  public File getPhoto() {

    return new File(photo);

  }

  public ContactData withPhoto(File photo) {

    this.photo = photo.getPath();
    return this;

  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddleName() {
    return middleName;
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

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
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

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getFax() {
    return fax;
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
    return houseAddress;
  }

  public String getNotes() {
    return notes;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", companyAddress='" + companyAddress + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            '}';
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }



  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }


  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withNick(String nick) {
    this.nick = nick;
    return this;
  }



}
