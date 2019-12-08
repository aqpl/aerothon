package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import static com.hackathon.hackathon.Constants.FlightsQuery.INSERT_BOOKING;
import static com.hackathon.hackathon.Constants.FlightsTable.*;
import static com.hackathon.hackathon.Constants.UsersTable.EMAIL;

@Service
public class BookingDB {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  public void insertBooking(Bookings bookings) {
    jdbcTemplate
      .update(INSERT_BOOKING,
        new MapSqlParameterSource()
          .addValue(BOOKING_ID, bookings.bookingId())
          .addValue(EMAIL, bookings.email())
          .addValue(FLIGHT_ID, bookings.flightId())
          .addValue(AMOUNT_PAID, bookings.amountPaid()));
  }

}
