package somesh.bose.model;

public class IdGenerator {
  private static int id=1000;

  public static long getId(){
    return id++;
  }
}
