package main.service;

import java.util.List;
import main.model.Room;

public interface Search{
  List<Room> searchByRoomType();
  List<Room> searchByRoom();
}
