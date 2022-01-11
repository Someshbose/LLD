package model;

import java.util.List;

public class Room {
  private String roomId;
  RoomType RoomType;
  boolean isSmoking;
  RoomStatus roomStatus;
  double bookingAmount;
  List<RoomKey> roomKeys;

  boolean setStatus(RoomStatus status){
    this.roomStatus= status;
    return true;
  }
}
