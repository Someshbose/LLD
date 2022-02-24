package main.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

  private int userId;

  private String userName;

}
