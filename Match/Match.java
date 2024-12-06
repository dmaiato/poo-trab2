package Match;

import Board.Board;
import Pieces.*;

public class Match {
  
  private Board board;
  private Player p1;
  private Player p2;
  private int turn; // atributo autoincrementado que troca os turnos

  public Match(Player p1, Player p2, Board board) {
    this.p1 = p1;
    this.p2 = p2;
    this.board = board;
    turn = 0;
  }

  /**
   * checa de quem é a vez, baseado no atributo turn
   * @return
   */
  public Color checkTurn() {
    if (turn == 0) return Color.WHITE;
    else return Color.BLACK;
  }

  /**
   * registra uma seleção de peça no tabuleiro
   * @param input string (ex: c6)
   * @throws Exception dispara um erro do usuário
   */
  public void registerPickUp(String input) throws Exception {
    Color turn = checkTurn();
    int[] position = positionConversion(input);

    if (board.getPiece(position) == null) {
      throw new Exception("celula vazia!");
    }

    if (turn != board.getPiece(position).getColor()) {
      throw new Exception("time incorreto!");
    }
  }
  
  /**
   * registra a nova posição desejada de um peça
   * @param origin posição de origem da peça
   * @param destination posição final da peça
   * @throws Exception dispara um erro do usuário
   */
  public void registerPlacing(String origin, String destination) throws Exception {
    int[] originPos = positionConversion(origin);
    int[] destinationPos = positionConversion(destination);

    Piece originPiece = board.getPiece(originPos);

    if (!originPiece.validMovement(destinationPos, this.board)) throw new Exception("movimento invalido!");
    
    board.removePiece(originPos);
    board.setPiece(originPiece, destinationPos);
    originPiece.updatePosition(destinationPos);
    
    this.turn = (turn+1) % 2;
  }

  /**
   * converte da string (ex: c6) para um array de posição x,y
   * @param text string a ser convertida
   * @return retorno do array tratado
   * @throws Exception dispara um erro de seleção
   */
  public int[] positionConversion(String text) throws Exception {
    String[] textArray = text.split("");

    if (textArray.length != 2) throw new Exception("posicao invalida!"); 

    int x;
    int y = Integer.parseInt(textArray[1]);

    if (y > 8) throw new Exception("coluna invalida!");

    int[] positionArray = new int[2];

    if (textArray[0].equalsIgnoreCase("a")) x = 0;
    else if (textArray[0].equalsIgnoreCase("b")) x = 1;
    else if (textArray[0].equalsIgnoreCase("c")) x = 2;
    else if (textArray[0].equalsIgnoreCase("d")) x = 3;
    else if (textArray[0].equalsIgnoreCase("e")) x = 4;
    else if (textArray[0].equalsIgnoreCase("f")) x = 5;
    else if (textArray[0].equalsIgnoreCase("g")) x = 6;
    else if (textArray[0].equalsIgnoreCase("h")) x = 7;
    else throw new Exception("linha invalida!");

    positionArray[0] = x;
    positionArray[1] = y-1;

    return positionArray;
  }

  @Override
  public String toString() {
    return "p1: " + p1.getTeam() + " - p2: " + p2.getTeam();
  }
}
