package com.hackathon.hackathon;

import com.google.gson.reflect.TypeToken;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.hackathon.hackathon.AppConfig.GSON;
import static com.hackathon.hackathon.Constants.FlightsTable.OFFER;
import static com.hackathon.hackathon.Constants.UsersTable.EMAIL;

@Component
public class PromotionsMapper implements RowMapper<Promotions> {

  Type OFFER_TYPE_TOKEN = new TypeToken<Offer>() {
  }.getType();

  @Override
  public Promotions mapRow(ResultSet resultSet, int i) throws SQLException {
    Promotions promotions = new Promotions()
      .email(resultSet.getString(EMAIL))
      .offer(GSON.fromJson(resultSet.getString(OFFER), OFFER_TYPE_TOKEN));
    return promotions;
  }
}

