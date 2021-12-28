package main.service;

import java.util.HashMap;
import java.util.List;
import main.model.Room;
import main.model.RoomType;

public class SearchIndex implements Search{

  HashMap<RoomType,List<Room>> roomType;
  HashMap<String,List<Room>> rooms;

  @Override
  public List<Room> searchByRoomType() {
    return null;
  }

  @Override
  public List<Room> searchByRoom() {
    return null;
  }
}
