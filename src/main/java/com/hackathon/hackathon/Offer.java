package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

public class Offer {
  @Expose
  private String source;
  @Expose
  private String destination;
  @Expose
  private String couponCode;
  @Expose
  private int discount;

  public String source() {
    return this.source;
  }

  public String destination() {
    return this.destination;
  }

  public String couponCode() {
    return this.couponCode;
  }

  public int discount() {
    return this.discount;
  }

  public Offer source(final String source) {
    this.source = source;
    return this;
  }

  public Offer destination(final String destination) {
    this.destination = destination;
    return this;
  }

  public Offer couponCode(final String couponCode) {
    this.couponCode = couponCode;
    return this;
  }

  public Offer discount(final int discount) {
    this.discount = discount;
    return this;
  }

}
