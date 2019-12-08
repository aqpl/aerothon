package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class FlightsResponse {

  @Expose
  private List<Flights> flights = new ArrayList<>();

  public List<Flights> flights() {
    return this.flights;
  }

  public FlightsResponse flights(final List<Flights> flights) {
    this.flights = flights;
    return this;
  }

  public FlightsResponse add(Flights flights) {
    this.flights.add(flights);
    return this;
  }

}
