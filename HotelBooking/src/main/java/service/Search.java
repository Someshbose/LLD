package service;

import model.Room;

import java.util.List;

public interface Search{
  List<Room> searchByRoomType();
  List<Room> searchByRoom();
}
