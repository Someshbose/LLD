package main.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Builder
public class Answer {

  private int id;

  private String comment;

  private int userId;

  MetaData metaData;


  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Answer answer = (Answer) o;
    return id == answer.id && userId == answer.userId;
  }

  @Override public int hashCode() {
    return id*userId+id;
  }
}
