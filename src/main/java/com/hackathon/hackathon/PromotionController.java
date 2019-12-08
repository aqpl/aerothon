package com.hackathon.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.hackathon.hackathon.Constants.Headers.AUTHORIZATION;

@RestController
public class PromotionController {

  @Autowired
  private LoginService loginService;
  @Autowired
  private FlightService flightService;

  @PostMapping("/getPromotions")
  public List<Promotions> getPromotions(HttpServletRequest servletRequest) {
    String toekn = (servletRequest.getHeader(AUTHORIZATION));
    Users user = loginService.authorize(toekn);
    return flightService.getPromotions(user.email());
  }
}
