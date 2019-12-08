package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.hackathon.hackathon.Constants.Headers.AUTHORIZATION;

@RestController
public class UserController {

  @Autowired
  private UserService userService;
  @Autowired
  private LoginService loginService;

  @PostMapping("/addMoney")
  public void addMoney(@RequestBody AddMoneyRequest req, HttpServletRequest servletRequest) {
    req.token(servletRequest.getHeader(AUTHORIZATION));
    Users user = loginService.authorize(req.token());
    userService.addMoney(req, user.email());
  }
}
