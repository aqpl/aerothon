package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

public class AddMoneyRequest {

  @Expose
  private String token;
  @Expose
  private Integer amount;

  public String token() {
    return this.token;
  }

  public Integer amount() {
    return this.amount;
  }

  public AddMoneyRequest token(final String token) {
    this.token = token;
    return this;
  }

  public AddMoneyRequest amount(final Integer amount) {
    this.amount = amount;
    return this;
  }

}
