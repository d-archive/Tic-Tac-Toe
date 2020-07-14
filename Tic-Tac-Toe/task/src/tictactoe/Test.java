package tictactoe;

import org.w3c.dom.ls.LSOutput;

public class Test {
  Board board;

  public void test() {
    board = new Board("XOXOXOXXO");
    board.print();
    System.out.println(board.getState());
  }
}
