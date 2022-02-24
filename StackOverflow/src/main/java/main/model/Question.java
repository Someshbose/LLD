package main.model;

import lombok.Builder;
import lombok.Getter;
import main.model.MetaData;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class Question {

  private int id;

  private String description;

  private List<Answer> answerList = new ArrayList<>();

  private int userId;

  private MetaData metaData;

}
