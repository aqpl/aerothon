package com.hackathon.hackathon;

public class Constants {

  public interface Headers {
    String AUTHORIZATION = "Authorization";
  }

  public interface UsersTable {
    String EMAIL = "email";
    String PASSWORD = "password";
    String AMOUNT = "amount";
    String IS_ADMIN = "isAdmin";
    String TOKEN = "token";
  }

  public interface FlightsTable {
    String FLIGHT_ID = "flightId";
    String SOURCE = "source";
    String DESTINATION = "destination";
    String START_TIME = "startTime";
    String END_TIME = "endTime";
    String PRICE = "price";
    String CAPACITY = "capacity";
    String ADD_AMOUNT = "addAmount";
    String OFFER = "offer";
    String LOW_TIME = "lowTime";
    String HIGH_TIME = "highTime";
    String BOOKING_ID = "bookingId";
    String AMOUNT_PAID = "amountPaid";
    String TXN_ID = "txnId";
    String DETAILS = "details";
  }

  public interface LoginQuery {
    String GET_USER_INFO = "SELECT * FROM users WHERE email = :email";
    String GET_USER_INFO_FROM_TOKEN = "SELECT * FROM users WHERE token = :token";
    String INSERT_USER = "INSERT INTO users (email, password, token) VALUES(:email, :password, :token)";
    String ADD_MONEY = "UPDATE users SET amount = amount + :addAmount WHERE email = :email";
  }

  public interface FlightsQuery {
    String ADD_OR_UPDATE_FLIGHT_INFO = "INSERT INTO flights (flightId, source, destination, startTime, endTime, price, capacity) VALUES(:flightId, :source, :destination, :startTime, :endTime, :price, :capacity) ON DUPLICATE KEY UPDATE startTime = :startTime , endTime= :endTime, price = :price";
    String GET_FLIGHT_DETAILS = "SELECT * FROM flights WHERE flightId LIKE :flightId LIMIT 5";
    String SEARCH_FLIGHTS = "SELECT * FROM flights WHERE (source = :source OR destination = :destination) AND startTime >= :lowTime AND startTime <= :highTime AND capacity > 0";
    String REDUCE_FLIGHT_CAP = "UPDATE flights SET capacity = capacity - 1 WHERE flightId = :flightId";
    String INSERT_BOOKING = "INSERT INTO bookings (email, bookingId, flightId, amountPaid) VALUES(:email, :bookingId, :flightId, :amountPaid)";
  }

  public interface SearchTableQuery {
    String ADD_SEARCH = "INSERT INTO searches (email, source, destination) VALUES(:email, :source, :destination)";
    String GET_ALL_SEARCH = "SELECT count(*) FROM searches WHERE email = :email AND source = :source AND destination = :destination";
    String ADD_PROMOTION = "INSERT INTO promotions (email, offer) VALUES(:email, :offer)";
    String GET_PROMOTIONS = "SELECT * FROM promotions where email = :email";
  }

  public interface TxnQuery {
    String ADD_TXN = "INSERT INTO transactions (email, txnId, details) VALUES(:email, :txnId, :details)";
    String GET_TXN = "SELECT * FROM transactions where email = :email";
  }
}
