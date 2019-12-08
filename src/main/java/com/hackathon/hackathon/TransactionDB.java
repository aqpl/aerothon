package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hackathon.hackathon.Constants.FlightsTable.DETAILS;
import static com.hackathon.hackathon.Constants.FlightsTable.TXN_ID;
import static com.hackathon.hackathon.Constants.TxnQuery.ADD_TXN;
import static com.hackathon.hackathon.Constants.TxnQuery.GET_TXN;
import static com.hackathon.hackathon.Constants.UsersTable.EMAIL;

@Service
public class TransactionDB {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Autowired
  private TxnMapper txnMapper;

  public void addTxn(Transactions txn) {
    jdbcTemplate.update(ADD_TXN,
      new MapSqlParameterSource()
        .addValue(TXN_ID, txn.txnId())
        .addValue(EMAIL, txn.email())
        .addValue(DETAILS, txn.details()));
  }

  public List<Transactions> getTransactions(String email) {
    return jdbcTemplate
      .query(GET_TXN,
        new MapSqlParameterSource()
          .addValue(EMAIL, email), txnMapper);
  }

}
