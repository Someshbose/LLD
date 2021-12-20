package somesh.bose.test;

public class Review {
  Long userId;
  int rating;
  String comment;

  public Review(Long userId, int rating, String comment) {
    this.userId = userId;
    this.rating=rating;
    this.comment=comment;
  }
}
