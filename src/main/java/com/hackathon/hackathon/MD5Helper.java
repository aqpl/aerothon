package com.hackathon.hackathon;

import org.springframework.util.DigestUtils;

import java.util.Arrays;

public class MD5Helper {
  public MD5Helper() {
  }

  public static String getMD5Hash(String input) {
    return input == null ? null : DigestUtils.md5DigestAsHex(input.getBytes());
  }

  public static String getMD5Hash(Object... input) {
    StringBuilder sb = new StringBuilder();
    Arrays.stream(input).forEach(sb::append);
    return getMD5Hash(sb.toString());
  }
}
