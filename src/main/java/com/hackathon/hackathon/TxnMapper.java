package com.hackathon.hackathon;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.hackathon.hackathon.Constants.FlightsTable.DETAILS;
import static com.hackathon.hackathon.Constants.FlightsTable.TXN_ID;
import static com.hackathon.hackathon.Constants.UsersTable.EMAIL;

@Component
public class TxnMapper implements RowMapper<Transactions> {
  @Override
  public Transactions mapRow(ResultSet resultSet, int i) throws SQLException {
    Transactions txn = new Transactions()
      .email(resultSet.getString(EMAIL))
      .txnId(resultSet.getLong(TXN_ID))
      .details(resultSet.getString(DETAILS));
    return txn;
  }
}
