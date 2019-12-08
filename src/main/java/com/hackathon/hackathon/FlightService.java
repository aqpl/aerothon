package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.hackathon.hackathon.AppConfig.GSON;
import static com.hackathon.hackathon.SequenceGenerator.nextID;
import static java.util.Arrays.asList;

@Service
public class FlightService {

  @Autowired
  private FlightDB flightDB;
  @Autowired
  private SearchesDB searchesDB;
  @Autowired
  private PromotionsDB promotionsDB;
  @Autowired
  private BookingDB bookingDB;
  @Autowired
  private TransactionDB transactionDB;

  public void addOrUpdateFlights(Flights flights) {
    flightDB.addOrUpdateFlight(flights);
  }

  public List<Flights> getFlightDetails(String flightId) {
    return flightDB.getFlights(flightId);
  }

  public List<FlightsResponse> searchFlights(SearchFlightsRequest request) {
    searchesDB.insertSearch(request);
    int searchCount = searchesDB.getAllSearchReq(request.email(), request.source(), request.destination());
    if (searchCount == 5) {
      generateOffer(request);
    }
    List<Flights> flights = flightDB.searchFlights(request);
    List<FlightsResponse> flightsResponses = new ArrayList<>();
    flightsResponses.addAll(getDirectFlights(flights, request));
    flightsResponses.addAll(getConnectingFlights(flights, request));
    return flightsResponses;
  }

  public Bookings bookAflight(BookingRequest req, String email) {
    Bookings bookings = new Bookings().bookingId(nextID()).email(email).flightId(req.flightId()).amountPaid(req.amountPaid());
    flightDB.reduceCapacityOfFlight(bookings.flightId());
    bookingDB.insertBooking(bookings);
    transactionDB.addTxn(new Transactions().details(GSON.toJson(bookings)).txnId(nextID()).email(email));
    return bookings;
  }

  public List<Transactions> getTxn(String email) {
    return transactionDB.getTransactions(email);
  }

  private List<FlightsResponse> getConnectingFlights(List<Flights> flights, SearchFlightsRequest request) {
    List<FlightsResponse> flightsResponses = new ArrayList<>();
    for (Flights flight : flights) {
      if (flight.source().equals(request.source())) {
        for (Flights flights1 : flights) {
          if (flights1.destination().equals(request.destination()) && flights1.source().equals(flight.destination())
            && flights1.startTime() > flight.endTime()) {
            FlightsResponse response = new FlightsResponse().add(flight).add(flights1);
            flightsResponses.add(response);
          }
        }
      }
    }
    return flightsResponses;
  }

  private List<FlightsResponse> getDirectFlights(List<Flights> flights, SearchFlightsRequest request) {
    List<FlightsResponse> flightsResponses = new ArrayList<>();
    for (Flights flight : flights) {
      if (flight.source().equals(request.source()) && flight.destination().equals(request.destination())) {
        flightsResponses.add(new FlightsResponse().flights(asList(flight)));
      }
    }
    return flightsResponses;
  }

  private void generateOffer(SearchFlightsRequest req) {
    Offer offer = new Offer().destination(req.destination()).source(req.source()).discount(5).couponCode(String.valueOf(nextID()));
    promotionsDB.insertPromotion(req.email(), offer);
  }

  public List<Promotions> getPromotions(String email) {
    return promotionsDB.getPromotions(email);
  }

}
