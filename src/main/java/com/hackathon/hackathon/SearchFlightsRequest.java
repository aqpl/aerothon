package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

public class SearchFlightsRequest {

  @Expose
  private String email;
  @Expose
  private String source;
  @Expose
  private String destination;
  @Expose
  private Long time;

  public String email() {
    return this.email;
  }

  public String source() {
    return this.source;
  }

  public String destination() {
    return this.destination;
  }

  public Long time() {
    return this.time;
  }

  public SearchFlightsRequest email(final String email) {
    this.email = email;
    return this;
  }

  public SearchFlightsRequest source(final String source) {
    this.source = source;
    return this;
  }

  public SearchFlightsRequest destination(final String destination) {
    this.destination = destination;
    return this;
  }

  public SearchFlightsRequest time(final Long time) {
    this.time = time;
    return this;
  }

}
