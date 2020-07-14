package tictactoe;

public enum Character {
  X('X'),
  O('O'),
  EMPTY('_');

  Character(char c) {
    this.c = c;
  }

  private final char c;

  public char getChar() {
    return c;
  }
}
