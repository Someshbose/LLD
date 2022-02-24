package main.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class MetaData {
  private Date postedOn;
}
