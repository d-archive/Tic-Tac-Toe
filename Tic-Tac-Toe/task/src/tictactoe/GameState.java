package tictactoe;

public enum GameState {
  PLAYING("Game not finished"),
  DRAW("Draw"),
  X_WINS("X wins"),
  O_WINS("O wins"),
  ERROR("Impossible");

  private final String msg;

  GameState(String msg) {
    this.msg = msg;
  }


  @Override
  public String toString() {
    return msg;
  }
}
