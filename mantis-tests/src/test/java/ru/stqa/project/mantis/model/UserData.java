package ru.stqa.project.mantis.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class UserData {
  @Id
  @Column(name = "id")
  @Type(type = "int")
  private int id = Integer.MAX_VALUE;

  @Column(name = "username", length = 32, columnDefinition="TEXT")
  private String username;

  @Column(name = "email", length = 64, columnDefinition="TEXT")
  private String email;

  @Column(name = "password", length = 32, columnDefinition="TEXT")
  private String password;

  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public UserData withUsername(String username) {
    this.username = username;
    return this;
  }

  public UserData withEmail(String email) {
    this.email = email;
    return this;
  }

  public UserData withPassword(String password) {
    this.password = password;
    return this;
  }

  public int getId() { return id; }

  public String getUsername() { return username; }

  public String getEmail() { return email; }

  public String getPassword() { return password; }
}

