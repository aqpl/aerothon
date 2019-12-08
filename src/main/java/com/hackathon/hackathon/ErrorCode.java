package com.hackathon.hackathon;

public enum ErrorCode {

  InternalServerError(500),
  InvalidRequest(400),
  InvalidPassword(401),
  UserAlreadyExists(402),
  UserNotFound(403),
  InvalidToken(404),
  Unauthorized(405);

  int statusCode;

  ErrorCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public int statusCode() {
    return statusCode;
  }
}

