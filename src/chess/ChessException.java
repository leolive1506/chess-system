package chess;

import boardgame.BoardException;

public class ChessException extends BoardException {
  private static final long serialVerionUID = 1L;

  public ChessException(String msg) {
    super(msg);
  }
}
