package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

public class BookingRequest {

  @Expose
  private String flightId;
  @Expose
  private int amountPaid;

  public int amountPaid() {
    return this.amountPaid;
  }

  public String flightId() {
    return this.flightId;
  }

  public BookingRequest flightId(final String flightId) {
    this.flightId = flightId;
    return this;
  }

  public BookingRequest amountPaid(final int amountPaid) {
    this.amountPaid = amountPaid;
    return this;
  }
}
