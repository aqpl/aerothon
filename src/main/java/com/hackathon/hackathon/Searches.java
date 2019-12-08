package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

public class Searches {

  @Expose
  private String email;
  @Expose
  private String source;
  @Expose
  private String destination;

  public String email() {
    return this.email;
  }

  public String source() {
    return this.source;
  }

  public String destination() {
    return this.destination;
  }

  public Searches email(final String email) {
    this.email = email;
    return this;
  }

  public Searches source(final String source) {
    this.source = source;
    return this;
  }

  public Searches destination(final String destination) {
    this.destination = destination;
    return this;
  }


}
