
import java.util.Scanner;

import Pieces.*;
import Board.*;
import Match.*;

public class Main {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    boolean matchStart = false;
    Player p1;
    Player p2;
    Board playBoard = null;
    Match match = null;

    // inicialização do jogo
    do {
      System.out.println("\n====== Xadrez ======");
      System.out.print("time player1: ");

      try {
        p1 = new Player(Color.valueOf(in.nextLine().toUpperCase()));        
      } catch (Exception e) {
        System.out.println("time invalido!");
        continue;
      }

      p2 = new Player((p1.getTeam()) == Color.WHITE ? Color.BLACK : Color.WHITE);        
      playBoard = Board.getInstance();

      match = new Match(p1, p2, playBoard);
      matchStart = true;

    } while (!matchStart);

    boolean matchEnd = false;
    playBoard.showBoard();
    
    // loop do jogo
    while (!matchEnd) {
      System.out.println("turn: " + match.checkTurn());
      
      try {
        System.out.print("peca (a1): ");
        String position = in.nextLine();

        match.registerPickUp(position);
        System.out.print("mover para: ");

        String destination = in.nextLine();
        match.registerPlacing(position, destination); 

        playBoard.showBoard();
        
      } catch (Exception e) {
        playBoard.showBoard(e);
      }
    }
    in.close();
  }
}
