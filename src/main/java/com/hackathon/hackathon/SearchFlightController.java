package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.hackathon.hackathon.Constants.Headers.AUTHORIZATION;

@RestController
public class SearchFlightController {

  @Autowired
  private LoginService loginService;
  @Autowired
  private FlightService flightService;

  @PostMapping("/searchFlight")
  public SearchFlightsResposne searchFlights(@RequestBody SearchFlightsRequest request, HttpServletRequest servletRequest) {
    String token = servletRequest.getHeader(AUTHORIZATION);
    Users user = loginService.authorize(token);
    request.email(user.email());
    return new SearchFlightsResposne().flightsResponses(flightService.searchFlights(request));
  }

}
