package ru.stqa.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstName;

  @Transient
  private String middleName;

  @Expose
  @Column(name = "lastname")
  private String lastName;

  @Transient
  private String nickname;

  @Transient
  private String title;

  @Transient
  private String company;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String homePhoneNumber;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhoneNumber;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email1;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;

  @Transient
  private String email3;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Transient
  private String allContact;

  @Transient
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;

    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withNikname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {

    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhoneNumber(String homePhoneNumber) {
    this.homePhoneNumber = homePhoneNumber;
    return this;
  }

  public ContactData withMobilePhoneNumber(String mobilePhoneNumber) {
    this.mobilePhoneNumber = mobilePhoneNumber;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
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

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withAllContact(String allContact) {
    this.allContact = allContact;
    return this;
  }

  public ContactData withPhoto(String photo) {
    this.photo = photo;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhoneNumber() {
    return homePhoneNumber;
  }

  public String getMobilePhoneNumber() {
    return mobilePhoneNumber;
  }

  public String getAllPhones() {
    return allPhones;
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

  public String getAllEmails() {
    return allEmails;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public int getId() {
    return id;
  }

  public String getAllContact() {
    return allContact;
  }

  public String getPhoto() {
    return photo;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            ", homePhoneNumber='" + homePhoneNumber + '\'' +
            ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
            ", email1='" + email1 + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", allEmails='" + allEmails + '\'' +
            ", allContact='" + allContact + '\'' +
            ", photo='" + photo + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
    if (title != null ? !title.equals(that.title) : that.title != null) return false;
    if (company != null ? !company.equals(that.company) : that.company != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (homePhoneNumber != null ? !homePhoneNumber.equals(that.homePhoneNumber) : that.homePhoneNumber != null)
      return false;
    if (mobilePhoneNumber != null ? !mobilePhoneNumber.equals(that.mobilePhoneNumber) : that.mobilePhoneNumber != null)
      return false;
    if (email1 != null ? !email1.equals(that.email1) : that.email1 != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
    if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;
    if (allEmails != null ? !allEmails.equals(that.allEmails) : that.allEmails != null) return false;
    if (allContact != null ? !allContact.equals(that.allContact) : that.allContact != null) return false;
    return photo != null ? photo.equals(that.photo) : that.photo == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (company != null ? company.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (homePhoneNumber != null ? homePhoneNumber.hashCode() : 0);
    result = 31 * result + (mobilePhoneNumber != null ? mobilePhoneNumber.hashCode() : 0);
    result = 31 * result + (email1 != null ? email1.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
    result = 31 * result + (allEmails != null ? allEmails.hashCode() : 0);
    result = 31 * result + (allContact != null ? allContact.hashCode() : 0);
    result = 31 * result + (photo != null ? photo.hashCode() : 0);
    return result;
  }
}
