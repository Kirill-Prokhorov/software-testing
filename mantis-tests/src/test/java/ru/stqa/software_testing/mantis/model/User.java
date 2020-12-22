package ru.stqa.software_testing.mantis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "mantis_user_table")
public class User {

  @Id
  @Column(name = "id")
  private  int id = Integer.MAX_VALUE;


  @Column(name = "username")
  private  String username;

  @Column(name = "email")
  private  String email;

  public int getId() {
    return id;
  }



  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public User withId(int id) {
    this.id = id;
    return this;
  }

  public User withUsername(String username) {
    this.username = username;
    return this;
  }

  public User withEmail(String email) {
    this.email = email;
    return this;
  }

}