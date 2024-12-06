package Board;

import Pieces.*;

/**
 * Classe da 
 */
public class Board {

  private static Board uniqueInstance;

  private Piece[][] matrix;

  // cria o tabuleiro completo
  private Board() {

    matrix = new Piece[8][8];

    for (int y = 0; y < 8; y++) {
      for (int x = 0; x < 8; x++) {

        if (y == 0 || y == 7) {
          if (x == 0 || x == 7) {
            matrix[x][y] = new Rook((y == 0) ? Color.BLACK : Color.WHITE);
            matrix[x][y].updatePosition(x, y);
          } else if (x == 1 || x == 6) {
            matrix[x][y] = new Knight((y == 0) ? Color.BLACK : Color.WHITE);
            matrix[x][y].updatePosition(x, y);
          } else if (x == 2 || x == 5) {
            matrix[x][y] = new Bishop((y == 0) ? Color.BLACK : Color.WHITE);
            matrix[x][y].updatePosition(x, y);
          } else if (x == 3) {
            matrix[x][y] = new Queen((y == 0) ? Color.BLACK : Color.WHITE);
            matrix[x][y].updatePosition(x, y);
          } else {
            matrix[x][y] = new King((y == 0) ? Color.BLACK : Color.WHITE);
            matrix[x][y].updatePosition(x, y);
          }
        } else if (y == 1 || y == 6) {
          matrix[x][y] = new Pawn((y == 1) ? Color.BLACK : Color.WHITE);
          matrix[x][y].updatePosition(x, y);
        } else {
          matrix[x][y] = null;
        }
      }
    }
  }

  /**
   * singleton do tabuleiro
   * @return retorna a instância única da classe
   */
  public static synchronized Board getInstance() {
    if (uniqueInstance == null) uniqueInstance = new Board();
    return uniqueInstance;
  }

  public Piece[][] getBoardMatrix() {
    return this.matrix;
  }

  public Piece getPiece(int x, int y) {
    return this.matrix[x][y];
  }

  public Piece getPiece(int[] yxpos) {
    return this.matrix[yxpos[0]][yxpos[1]];
  }

  /**
   * printa o tabuleiro no terminal
   * @param e printa algum erro causado no sistema
   */
  public void showBoard(Exception e) {
    System.out.print("\033[H\033[2J");
    System.out.print(e == null ? "" : e + "\n");
    System.out.println("   a  b  c  d  e  f  g  h");
    for (int y = 0; y < matrix.length; y++) {
      System.out.print(y+1 + "  ");
      for (int x = 0; x < matrix.length; x++) {
        System.out.print((this.matrix[x][y] == null) ? " |" + " " : this.matrix[x][y] + "| ");
      }
      System.out.println();
    }
  }
  
  /**
   * printa o tabuleiro sem erros
   */
  public void showBoard() {
    showBoard(null);
  }

  public void setPiece(Piece piece, int y, int x) {
    matrix[y][x] = piece;
  }

  public void setPiece(Piece piece, int[] position) {
    matrix[position[0]][position[1]] = piece;
  }
  
  public void removePiece(int[] position) {
    matrix[position[0]][position[1]] = null;
  }
}