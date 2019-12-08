package com.hackathon.hackathon;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.hackathon.hackathon.Constants.UsersTable.*;


@Component
public class UsersMapper implements RowMapper<Users> {
  @Override
  public Users mapRow(ResultSet resultSet, int i) throws SQLException {
    Users users = new Users()
      .email(resultSet.getString(EMAIL))
      .password(resultSet.getString(PASSWORD))
      .amount(resultSet.getInt(AMOUNT))
      .token(resultSet.getString(TOKEN))
      .isAdmin(resultSet.getBoolean(IS_ADMIN));
    return users;
  }
}