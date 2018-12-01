package backend;
import javafx.util.Pair;

import java.lang.Math;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AIBoard extends Board{

  private static final int HARD = 3;
  private static final int MEDIUM = 2;
  private static final int EASY = 1;

  private int level;

  public AIBoard(int hardness){
    super();
    level = hardness;
  }

  private AIBoard(String board, int hardness) {
    super(board);
    level = hardness;
  }
  /**
   * Move the korgools according to the pressed hole
   * @param pressedHole: the hole pressed
   * @return True if the current player has won,
   *    False otherwise
   */
  @Override
  public void makeAMove(int pressedHole){
    if(isWhiteTurn)
      super.makeAMove(pressedHole);
    makeAIMove();
  }

  private void makeAIMove(){
    int randomHole = evaluate();
    while(!isValidMove(randomHole)){
      System.out.println(randomHole);
      randomHole = evaluate();
    }
    super.makeAMove(evaluate());
  }

  private boolean isValidMove(int pressedHole){
    Player currentPlayer = (isWhiteTurn? white : black);
    return currentPlayer.getHoles()[pressedHole].getKorgools() != 0;
  }

  /**
   * Return the hole to move for the AI Player
   * @return The hole selected
   */
  private int evaluate(){
    return (int)(Math.random()*8);
  }

  // get the possible moves he could make from pos 0

  //

  public static void main(String[] s) {
    String testBoard = "9,9,9,9,9,9,9,9,0,13,0\n" +
            "0,1,1,3,0,1,3,0,0,20,0\n" +
            "b";

    System.out.println(getBestMoveForBlack(testBoard));
  }


  // ASSUMING AI IS BLACK
  private static Pair<Integer, String> alphabeta(String boardString, int depth, int alpha, int beta, boolean isBlackTurn) {
    if (depth == 0 || gameHasEnded(boardString)) {
      return new Pair<Integer, String>(heuristicValue(boardString), boardString);
    }

    ArrayList<String> possibleBoards = getPossibleMoves(boardString);
    String bestBoard = "";
    if (isBlackTurn) { // maximize
      for (String newBoard : possibleBoards) {
        int newAlpha = alphabeta(newBoard, depth-1, alpha, beta, !isBlackTurn).getKey();
        if (alpha < newAlpha) {
          alpha = newAlpha;
          bestBoard = newBoard;
          //System.out.println("switching to " + newBoard);

        }
        if (beta <= alpha) break; // prune
      }
      return new Pair<>(alpha, bestBoard);
    }
    else { // minimize
      for (String newBoard : possibleBoards) {
        int newBeta = alphabeta(newBoard, depth-1, alpha, beta, !isBlackTurn).getKey();
        if (beta < newBeta) {
          beta = newBeta;
          bestBoard = newBoard;
          //System.out.println("switching to " + newBoard);
        }
        if (beta <= alpha) break; // prune
      }
      return new Pair<>(beta, bestBoard);
    }
  }

  private static boolean gameHasEnded(String boardString) {
    return (new Board()).gameHasEnded();

  }

  /**
   * For now, the heurstic value is the difference between the scores of the players, favoring black.
   *
   * Other ideas:
   * Analyzing best tuz placements
   * Having more kergels on your side could be disadvantages as he could capture
   * How much board coverage you have (how many of his cells you can reach)
   * @param boardString the board that we want to get the h-value for
   * @return the heuristic value of the board
   */
  private static int heuristicValue(String boardString) {
    String[] tokens = boardString.split("\n");
    int blackScore = Integer.parseInt(tokens[0].split(",")[9]);
    int whiteScore = Integer.parseInt(tokens[1].split(",")[9]);

    return blackScore - whiteScore;
  }

  private static ArrayList<String> getPossibleMoves(String boardString) {
    ArrayList<String> reachableBoards = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      if ((new AIBoard(0)).isValidMove(i)) {
        Board board = new Board(boardString);
        board.makeAMove(i);
        reachableBoards.add(board.toString());
      }
    }

    for (String bs : reachableBoards) {
      System.out.println(bs);
    }
    return reachableBoards;
  }

  private static int getBestMoveForBlack(String boardString) {
    System.out.println("starting: " + boardString);
    System.out.println(heuristicValue(boardString) + "\n");

    String desiredBoard = alphabeta(boardString, 1, Integer.MIN_VALUE, Integer.MAX_VALUE, true).getValue();

    System.out.println("desired: " + desiredBoard);
    System.out.println(heuristicValue(desiredBoard) + "\n");


    for (int i = 0; i < 9; i++) {
      Board newBoard = new Board(boardString);
      newBoard.makeAMove(i);

      if (newBoard.toString() == desiredBoard) return i;
    }

    try {
      throw new Exception("No Board found");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return -1;
  }
}
