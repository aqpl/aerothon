package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hackathon.hackathon.Constants.FlightsQuery.*;
import static com.hackathon.hackathon.Constants.FlightsTable.*;
import static com.hackathon.hackathon.EnvProp.DAY_IN_MILLIS;

@Service
public class FlightDB {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Autowired
  private FlightsMapper flightsMapper;

  public void addOrUpdateFlight(Flights flights) {
    jdbcTemplate.update(ADD_OR_UPDATE_FLIGHT_INFO,
      new MapSqlParameterSource()
        .addValue(FLIGHT_ID, flights.flightId())
        .addValue(SOURCE, flights.source())
        .addValue(DESTINATION, flights.destination())
        .addValue(START_TIME, flights.startTime())
        .addValue(END_TIME, flights.endTime())
        .addValue(PRICE, flights.price())
        .addValue(CAPACITY, flights.capacity()));
  }

  public List<Flights> getFlights(String flightId) {
    String nameLikeQuery = "%" + flightId + "%";
    return jdbcTemplate
      .query(GET_FLIGHT_DETAILS,
        new MapSqlParameterSource(FLIGHT_ID, nameLikeQuery), flightsMapper
      );
  }

  public List<Flights> searchFlights(SearchFlightsRequest req) {
    return jdbcTemplate
      .query(SEARCH_FLIGHTS,
        new MapSqlParameterSource(SOURCE, req.source())
          .addValue(DESTINATION, req.destination())
          .addValue(LOW_TIME, req.time())
          .addValue(HIGH_TIME, req.time() + DAY_IN_MILLIS), flightsMapper
      );
  }

  public void reduceCapacityOfFlight(String flightId) {
    jdbcTemplate.update(REDUCE_FLIGHT_CAP, new MapSqlParameterSource(FLIGHT_ID, flightId));
  }
}


