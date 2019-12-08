package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hackathon.hackathon.AppConfig.GSON;
import static com.hackathon.hackathon.Constants.FlightsTable.OFFER;
import static com.hackathon.hackathon.Constants.SearchTableQuery.ADD_PROMOTION;
import static com.hackathon.hackathon.Constants.SearchTableQuery.GET_PROMOTIONS;
import static com.hackathon.hackathon.Constants.UsersTable.EMAIL;

@Service
public class PromotionsDB {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Autowired
  private PromotionsMapper promotionsMapper;

  public void insertPromotion(String email, Offer offer) {
    jdbcTemplate
      .update(ADD_PROMOTION,
        new MapSqlParameterSource()
          .addValue(EMAIL, email)
          .addValue(OFFER, GSON.toJson(offer)));
  }

  public List<Promotions> getPromotions(String email) {
    return jdbcTemplate
      .query(GET_PROMOTIONS,
        new MapSqlParameterSource()
          .addValue(EMAIL, email), promotionsMapper);
  }
}
