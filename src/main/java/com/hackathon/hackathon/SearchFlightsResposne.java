package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SearchFlightsResposne {

  @Expose
  private List<FlightsResponse> flightsResponses;

  public List<FlightsResponse> flightsResponses() {
    return this.flightsResponses;
  }

  public SearchFlightsResposne flightsResponses(final List<FlightsResponse> flightsResponses) {
    this.flightsResponses = flightsResponses;
    return this;
  }

}
