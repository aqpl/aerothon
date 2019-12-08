package com.hackathon.hackathon;

import com.google.gson.annotations.Expose;

import static com.hackathon.hackathon.ErrorCode.InvalidRequest;
import static java.util.Objects.isNull;

public class TokenRequest {

  @Expose
  private String token;

  public String token() {
    return this.token;
  }

  public TokenRequest token(final String token) {
    this.token = token;
    return this;
  }

  public void validate() {
    if (isNull(token) || token.length() == 0) {
      throw new AppException(InvalidRequest);
    }
  }

}
