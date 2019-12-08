package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @Autowired
  private LoginService loginService;

  @PostMapping("/login")
  public Users login(@RequestBody LoginRequest req) {
    req.validate();
    return loginService.login(req);
  }

  @PostMapping("/signUp")
  public Users signUp(@RequestBody LoginRequest req) {
    req.validate();
    return loginService.signup(req);
  }

  @PostMapping("/tokens")
  public Users tokens(@RequestBody TokenRequest req) {
    req.validate();
    return loginService.getUserFromToken(req);
  }

}
