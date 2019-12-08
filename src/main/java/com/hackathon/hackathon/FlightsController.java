package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.hackathon.hackathon.Constants.Headers.AUTHORIZATION;

@RestController
public class FlightsController {

  @Autowired
  private FlightService flightService;
  @Autowired
  private LoginService loginService;

  @PostMapping("/addOrUpdateFlightInfo")
  public void addFlight(@RequestBody Flights flights) {
    flightService.addOrUpdateFlights(flights);
  }

  @GetMapping("/getFlightDetails")
  public FlightsResponse getFlightDetails(@RequestParam(name = "flightId") String flightId) {
    List<Flights> flightDetails = flightService.getFlightDetails(flightId);
    return new FlightsResponse().flights(flightDetails);
  }

  @PostMapping("/bookFlight")
  public Bookings bookFlight(@RequestBody BookingRequest request, HttpServletRequest servletRequest) {
    String toekn = (servletRequest.getHeader(AUTHORIZATION));
    Users user = loginService.authorize(toekn);
    return flightService.bookAflight(request, user.email());
  }

  @GetMapping("/getTxn")
  public List<Transactions> getTxn(HttpServletRequest servletRequest) {
    String toekn = (servletRequest.getHeader(AUTHORIZATION));
    Users user = loginService.authorize(toekn);
    return flightService.getTxn(user.email());
  }

}
