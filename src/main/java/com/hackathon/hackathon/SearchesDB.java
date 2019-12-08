package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hackathon.hackathon.Constants.FlightsTable.DESTINATION;
import static com.hackathon.hackathon.Constants.FlightsTable.SOURCE;
import static com.hackathon.hackathon.Constants.SearchTableQuery.ADD_SEARCH;
import static com.hackathon.hackathon.Constants.SearchTableQuery.GET_ALL_SEARCH;
import static com.hackathon.hackathon.Constants.UsersTable.EMAIL;

@Service
public class SearchesDB {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Autowired
  private SearchesMapper searchesMapper;

  public void insertSearch(SearchFlightsRequest request) {
    jdbcTemplate
      .update(ADD_SEARCH,
        new MapSqlParameterSource()
          .addValue(EMAIL, request.email())
          .addValue(SOURCE, request.source())
          .addValue(DESTINATION, request.destination()));
  }

  public Integer getAllSearchReq(String email, String source, String destination) {
    return jdbcTemplate
      .queryForObject(GET_ALL_SEARCH,
        new MapSqlParameterSource()
          .addValue(EMAIL, email)
          .addValue(SOURCE, source)
          .addValue(DESTINATION, destination), Integer.class);

  }
}

