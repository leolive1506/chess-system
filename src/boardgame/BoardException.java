package boardgame;

public class BoardException extends RuntimeException {
  private static final long serialVerionUID = 1L;

  public BoardException(String msg) {
    super(msg);
  }
}
