package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

import static com.hackathon.hackathon.MD5Helper.getMD5Hash;

public class Users {

  @Expose
  private String email;
  private String password;
  @Expose
  private String token;
  @Expose
  private int amount;
  @Expose
  private boolean isAdmin;

  public String email() {
    return this.email;
  }

  public String password() {
    return this.password;
  }

  public String token() {
    return this.token;
  }

  public int amount() {
    return this.amount;
  }

  public boolean isAdmin() {
    return this.isAdmin;
  }

  public Users email(final String email) {
    this.email = email;
    return this;
  }

  public Users password(final String password) {
    this.password = password;
    return this;
  }

  public Users token(final String token) {
    this.token = token;
    return this;
  }

  public Users amount(final int amount) {
    this.amount = amount;
    return this;
  }

  public Users isAdmin(final boolean isAdmin) {
    this.isAdmin = isAdmin;
    return this;
  }

  public void setToken(){
    this.token = getMD5Hash(this.email + ":" + this.password);
  }

}
