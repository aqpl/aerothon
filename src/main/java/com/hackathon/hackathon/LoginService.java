package com.hackathon.hackathon;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.hackathon.hackathon.ErrorCode.*;
import static com.hackathon.hackathon.MD5Helper.getMD5Hash;

@Service
public class LoginService {

  @Autowired
  private UsersDB usersDB;

  public Users login(LoginRequest req) {
    Users users = usersDB.getUserInfo(req.email());
    String hashedPassword = getMD5Hash(req.password());
    if (!users.password().equals(hashedPassword)) {
      throw new AppException(InvalidPassword);
    }
    return users;
  }

  public Users signup(LoginRequest req) {
    Users users = new Users().email(req.email()).password(getMD5Hash(req.password()));
    users.setToken();
    usersDB.registerUser(users);
    return users;
  }

  public Users getUserFromToken(TokenRequest req) {
    return usersDB.getUserInfoFromToken(req.token());
  }

  public Users authorize(String token) {
    Users userFromToken = getUserFromToken(new TokenRequest().token(token));
    return userFromToken;
  }
}
