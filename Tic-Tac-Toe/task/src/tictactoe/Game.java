package tictactoe;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static tictactoe.GameState.PLAYING;

public class Game {
  int turn;
  Board board;

  public Game() {
    turn = 0;
    board = new Board();
  }

  public void play() {
    Scanner scanner = new Scanner(System.in);
    board.print();

    int x;
    int y;

    while (board.getState() == PLAYING) {
      try {
        System.out.print("Enter the coordinates [posX posY]: ");
        x = scanner.nextInt();
        y = scanner.nextInt();
        if (x < 1 || x > 3 || y < 1 || y > 3) {
          System.out.println("Coordinates should be from 1 to 3");
        } else {
          if (turn % 2 == 0) {
            board.move(Character.X,x,y);
          } else {
            board.move(Character.O,x,y);
          }
          turn++;
        }
      } catch (NoSuchElementException ex) {
        System.out.println("You should enter numbers");
        scanner.nextLine();
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        scanner.nextLine();
      }
      board.print();
    }

    System.out.println(board.getState());
  }
}
