package tictactoe;

import static tictactoe.Character.*;

public class Board {
  char[][] board;
  int difference;
  boolean isThereEmptyCell;
  GameState state;

  Board(String cells) {
    board = new char[3][3];
    difference = 0;
    isThereEmptyCell = false;
    setState();
    parseBoard(cells);
  }

  Board() {
    board = new char[3][3];
    difference = 0;
    isThereEmptyCell = true;
    state = GameState.PLAYING;
    parseBoard("_________");
  }
    
    private void parseBoard(String cells) {
      int count = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          char cell = cells.charAt(count);
          board[i][j] = cell;

          if (cell == EMPTY.getChar()) {
            isThereEmptyCell = true;
          }

          if (cell == X.getChar()) {
            difference++;
          }

          if (cell == O.getChar()) {
            difference--;
          }
          count++;
        }
    }
  }

  public void print() {
    System.out.println("---------");
    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j]);
        System.out.print(" ");
      }
      System.out.println("|");
    }
    System.out.println("---------");
  }

  public void setState() {
    boolean xWins = checkWinFor(X.getChar());
    boolean yWins = checkWinFor(O.getChar());

    if (xWins && yWins || Math.abs(difference) > 1) {
      state = GameState.ERROR;
    } else if (xWins) {
      state = GameState.X_WINS;
    } else if (yWins) {
      state = GameState.O_WINS;
    } else if (isThereEmptyCell) {
      state = GameState.PLAYING;
    } else {
      state = GameState.DRAW;
    }
  }

  public GameState getState() {
    return state;
  }

  public boolean checkWinFor(char c) {
    boolean[] wins = {true,true,true,true,true,true,true,true};
    boolean win = false;

    for (int i = 0; i < 3; i++) {
      if (board[0][i] != c) {
        wins[0] = false;
      };

      if (board[1][i] != c) {
        wins[1] = false;
      }

      if (board[2][i] != c) {
        wins[2] = false;
      };

      if (board[i][0] != c) {
        wins[3] = false;
      };

      if (board[i][1] != c) {
        wins[4] = false;
      };

      if (board[i][2] != c) {
        wins[5] = false;
      };

      if (board[i][i] != c) {
        wins[6] = false;
      }

      if (board[i][2 - i] != c) {
        wins[7] = false;
      }
    }

    for (boolean state : wins) {
      if (state) {
        win = state;
      }
    }

    return win;
  }

  public void move(Character c, int posX, int posY) throws IllegalArgumentException {
    int[] pos = convertXY(posX, posY);
    int i = pos[0];
    int j = pos[1];


    if (board[i][j] == X.getChar() || board[i][j] == O.getChar()) {
      throw new IllegalArgumentException("This cell is occupied! Choose another one!");
    } else {
      board[i][j] = c.getChar();
    }

    setState();
  }

  private int[] convertXY(int x, int y) {
    x--;
    y--;
    int i = Math.abs(y - (3-1));
    int j = x;
    int[] a = {i, j};
    return a;
  }
}
