package somesh.bose.service;

import somesh.bose.model.Restruant;

import java.util.List;

public interface Search {
  List<Restruant> getRestruantList(String filter);
}
