package com.hackathon.hackathon;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.hackathon.hackathon.Constants.FlightsTable.DESTINATION;
import static com.hackathon.hackathon.Constants.FlightsTable.SOURCE;
import static com.hackathon.hackathon.Constants.UsersTable.EMAIL;

@Component
public class SearchesMapper implements RowMapper<Searches> {
  @Override
  public Searches mapRow(ResultSet resultSet, int i) throws SQLException {
    Searches searches = new Searches()
      .email(resultSet.getString(EMAIL))
      .source(resultSet.getString(SOURCE))
      .destination(resultSet.getString(DESTINATION));
    return searches;
  }
}
