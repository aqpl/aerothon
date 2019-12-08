package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

public class Flights {

  @Expose
  private String flightId;
  @Expose
  private String source;
  @Expose
  private String destination;
  @Expose
  private long startTime;
  @Expose
  private long endTime;
  @Expose
  private int price;
  @Expose
  private int capacity;

  public String flightId() {
    return this.flightId;
  }

  public String source() {
    return this.source;
  }

  public String destination() {
    return this.destination;
  }

  public long startTime() {
    return this.startTime;
  }

  public long endTime() {
    return this.endTime;
  }

  public int price() {
    return this.price;
  }

  public int capacity() {
    return this.capacity;
  }

  public Flights flightId(final String flightId) {
    this.flightId = flightId;
    return this;
  }

  public Flights source(final String source) {
    this.source = source;
    return this;
  }

  public Flights destination(final String destination) {
    this.destination = destination;
    return this;
  }

  public Flights startTime(final long startTime) {
    this.startTime = startTime;
    return this;
  }

  public Flights endTime(final long endTime) {
    this.endTime = endTime;
    return this;
  }

  public Flights price(final int price) {
    this.price = price;
    return this;
  }

  public Flights capacity(final int capacity) {
    this.capacity = capacity;
    return this;
  }

}
