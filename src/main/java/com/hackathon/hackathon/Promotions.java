package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

public class Promotions {

  @Expose
  private String email;
  @Expose
  private Offer offer;

  public String email() {
    return this.email;
  }

  public Offer offer() {
    return this.offer;
  }

  public Promotions email(final String email) {
    this.email = email;
    return this;
  }

  public Promotions offer(final Offer offer) {
    this.offer = offer;
    return this;
  }

}
