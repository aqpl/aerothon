package com.hackathon.hackathon;

import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Enumeration;

public class SequenceGenerator {

  private static int LOWER_ORDER_TEN_BITS = 0x3FF;
  public static int MACHINE_ID_BITS = 10;
  public static int UNIQUE_ID_COUNTER_BITS = 10;
  public static int EPOCH_BITS = 41;
  private static long PER_MS_ID_COUNTER = 0;
  private static long CUR_EPOCH = 0;

  private static int MACHINE_ID = createMachineId();
  private static final long EPOCH_MILLIS_ON_1_JAN_2018 = 1514764800000L;

  public static long nextID() {
    long rebasedEpoch = getRebasedEpoch(Instant.now().toEpochMilli());
    long id = rebasedEpoch << (MACHINE_ID_BITS + UNIQUE_ID_COUNTER_BITS);
    id |= MACHINE_ID << UNIQUE_ID_COUNTER_BITS;
    id |= getNextCounter(rebasedEpoch);
    return id;
  }

  private synchronized static long getNextCounter(long epoch) {
    if (epoch == CUR_EPOCH)
      PER_MS_ID_COUNTER++;
    else {
      PER_MS_ID_COUNTER = 0;
      CUR_EPOCH = epoch;
    }
    PER_MS_ID_COUNTER &= LOWER_ORDER_TEN_BITS;
    return PER_MS_ID_COUNTER;
  }

  public static long getRebasedEpoch(long epochInMillis) {
    return (epochInMillis - EPOCH_MILLIS_ON_1_JAN_2018) / 100;
  }

  private static int createMachineId() {
    int machineId;
    try {
      StringBuilder sb = new StringBuilder();
      Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
      while (networkInterfaces.hasMoreElements()) {
        NetworkInterface networkInterface = networkInterfaces.nextElement();
        byte[] mac = networkInterface.getHardwareAddress();
        if (mac != null) {
          for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X", mac[i]));
          }
        }
      }
      machineId = sb.toString().hashCode();
    } catch (Exception ex) {
      machineId = (new SecureRandom().nextInt());
    }
    machineId = machineId & LOWER_ORDER_TEN_BITS;
    return machineId;
  }
}