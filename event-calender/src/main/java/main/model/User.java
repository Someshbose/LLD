package main.model;

import java.util.ArrayList;
import java.util.List;

public class User {
  String name;
  List<InviteNotifcation> list;

  public User(String name){
    this.name=name;
    this.list = new ArrayList<>();
  }

  public List<InviteNotifcation> getList() {
    return list;
  }

  public String getName() {
    return name;
  }

  //  public boolean putResponse(int id, Response response){
//    list.stream().findFirst(item->item. == id)
//        return item;
//      )
//  }

}
