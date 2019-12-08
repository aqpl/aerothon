package com.hackathon.hackathon;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.hackathon.hackathon.Constants.FlightsTable.*;


@Component
public class FlightsMapper implements RowMapper<Flights> {
  @Override
  public Flights mapRow(ResultSet resultSet, int i) throws SQLException {
    Flights flights = new Flights()
      .flightId(resultSet.getString(FLIGHT_ID))
      .source(resultSet.getString(SOURCE))
      .destination(resultSet.getString(DESTINATION))
      .startTime(resultSet.getLong(START_TIME))
      .endTime(resultSet.getLong(END_TIME))
      .price(resultSet.getInt(PRICE))
      .capacity(resultSet.getInt(CAPACITY));
    return flights;
  }
}
