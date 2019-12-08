package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UsersDB usersDB;

  public void addMoney(AddMoneyRequest req, String email) {
    usersDB.addMoney(email, req.amount());
  }
}
