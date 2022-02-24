package main.service;

import main.model.User;

import java.util.HashMap;
import java.util.Optional;

public class UserService {

  private static UserService instance = null;

  private HashMap<Integer, User> userHashMap ;

  private UserService(){
    userHashMap = new HashMap<>();
  }

  public static UserService getInstance() {
    if(instance == null)
        instance = new UserService();
    return instance;
  }


  public int addUser(String userName){

    User user = User.builder().userId(IdGeneratorService.getId()).userName(userName).build();
    userHashMap.put(user.getUserId(),user);

    return user.getUserId();

    // if in future there some unique username we can return false
  }

  public Optional<User> getUserById(int id){

    return Optional.of(userHashMap.getOrDefault(id,null));
  }

}
