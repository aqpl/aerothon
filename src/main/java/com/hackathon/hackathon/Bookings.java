package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

public class Bookings {

  @Expose
  private String email;
  @Expose
  private long bookingId;
  @Expose
  private int amountPaid;
  @Expose
  private String flightId;

  public String email() {
    return this.email;
  }

  public long bookingId() {
    return this.bookingId;
  }

  public int amountPaid() {
    return this.amountPaid;
  }

  public String flightId() {
    return this.flightId;
  }

  public Bookings email(final String email) {
    this.email = email;
    return this;
  }

  public Bookings bookingId(final long bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  public Bookings amountPaid(final int amountPaid) {
    this.amountPaid = amountPaid;
    return this;
  }

  public Bookings flightId(final String flightId) {
    this.flightId = flightId;
    return this;
  }

}
