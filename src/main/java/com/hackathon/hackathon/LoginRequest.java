package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

import static com.hackathon.hackathon.ErrorCode.*;
import static java.util.Objects.isNull;

public class LoginRequest {

  @Expose
  private String email;
  @Expose
  private String password;

  public String email() {
    return this.email;
  }

  public String password() {
    return this.password;
  }

  public LoginRequest email(final String email) {
    this.email = email;
    return this;
  }

  public LoginRequest password(final String password) {
    this.password = password;
    return this;
  }

  public void validate() {
    if(isNull(email) || email.length()==0 || isNull(password) || password.length()==0 ) {
      throw new AppException(InvalidRequest);
    }
  }

}
