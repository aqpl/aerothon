package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

public class Transactions {
  @Expose
  private String email;
  @Expose
  private long txnId;
  @Expose
  private String details;

  public String email() {
    return this.email;
  }

  public long txnId() {
    return this.txnId;
  }

  public String details() {
    return this.details;
  }

  public Transactions email(final String email) {
    this.email = email;
    return this;
  }

  public Transactions txnId(final long txnId) {
    this.txnId = txnId;
    return this;
  }

  public Transactions details(final String details) {
    this.details = details;
    return this;
  }


}
