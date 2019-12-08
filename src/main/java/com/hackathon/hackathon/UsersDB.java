package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import static com.hackathon.hackathon.Constants.FlightsTable.ADD_AMOUNT;
import static com.hackathon.hackathon.Constants.LoginQuery.*;
import static com.hackathon.hackathon.Constants.UsersTable.*;
import static com.hackathon.hackathon.ErrorCode.InvalidToken;
import static com.hackathon.hackathon.ErrorCode.UserAlreadyExists;

@Service
public class UsersDB {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Autowired
  private UsersMapper usersMapper;

  public Users getUserInfo(String email) {
    try {
      return jdbcTemplate
        .queryForObject(GET_USER_INFO,
          new MapSqlParameterSource().addValue(EMAIL, email),
          usersMapper);
    } catch (EmptyResultDataAccessException ex) {
      throw new AppException(ErrorCode.UserNotFound);
    }
  }

  public Users getUserInfoFromToken(String token) {
    try {
      return jdbcTemplate
        .queryForObject(GET_USER_INFO_FROM_TOKEN,
          new MapSqlParameterSource().addValue(TOKEN, token),
          usersMapper);
    } catch (EmptyResultDataAccessException ex) {
      throw new AppException(InvalidToken);
    }
  }

  public void registerUser(Users users) {
    try {
      jdbcTemplate.update(INSERT_USER,
        new MapSqlParameterSource()
          .addValue(EMAIL, users.email())
          .addValue(PASSWORD, users.password())
          .addValue(TOKEN, users.token()));
    } catch (DuplicateKeyException ex) {
      throw new AppException(UserAlreadyExists);
    }
  }

  public void addMoney(String email, Integer amount) {
    jdbcTemplate.update(ADD_MONEY,
      new MapSqlParameterSource()
        .addValue(ADD_AMOUNT, amount)
        .addValue(EMAIL, email));
  }

  /*public void updateWatchInfo(Long watchExpiryTime, long emailId) {
    jdbcTemplate.update(UPDATE_WATCH_INFO,
      new MapSqlParameterSource()
        .addValue(EMAIL_ID, emailId)
        .addValue(WATCH_EXPIRY_TIME, watchExpiryTime));
  }

  public void updateNextFolderId(long emailId, int nextFolderId) {
    jdbcTemplate.update(UPDATE_NEXT_FOLDER_ID,
      new MapSqlParameterSource().addValue(EMAIL_ID, emailId)
        .addValue(NEXT_FOLDER_ID, nextFolderId));
  }

  public EmailInfo getEmailInfo(long emailId) {
    try {
      return jdbcTemplate
        .queryForObject(GET_EMAIL_INFO_USING_EMAILID,
          new MapSqlParameterSource().addValue(EMAIL_ID, emailId),
          emailInfoMapper);
    } catch (EmptyResultDataAccessException ex) {
      throw new FlockException(InvalidMail);
    }
  }*/

}
