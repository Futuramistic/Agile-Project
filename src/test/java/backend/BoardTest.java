package backend;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BoardTest{
  private Board board;

  // @Test
  // public void makeAMove(){
  //   board = new Board("0,0,0,0,0,0,0,0,0,13,0\n"+
  //                     "0,0,1,0,0,0,0,0,0,20,0\nw");
  //   board.makeAMove(2);
  //   assertTrue(board.toString().equals("0,0,0,0,0,0,0,0,0,13,0\n"+
  //                                      "0,0,1,0,0,0,0,0,0,20,0\nw"));
  // }
  @Test
  public void playerHasAMove(){
    board = new Board("0,0,0,0,0,0,0,0,0,60,-1\n"+
                      "0,0,0,0,0,0,0,0,3,81,-1\nw");
    assertTrue(board.currentPlayer.hasAMove());
  }

  @Test
  public void playerDoesntHaveAMove(){
    board = new Board("0,0,0,0,0,0,0,0,0,60,-1\n"+
                      "0,0,0,0,0,0,0,0,3,81,-1\nb");
    assertFalse(board.currentPlayer.hasAMove());
  }

  @Test
  public void gameHasEndedShouldReturnNull(){
    board = new Board("0,0,0,0,0,0,0,0,0,81,0\n"+
                      "0,0,0,0,0,0,0,1,0,81,0\nb");
    assertEquals(null,board.makeAMove(7));
  }

  @Test
  public void gameHasEndedTestShouldReturnWhite(){
    board = new Board("0,1,0,0,0,0,0,0,0,77,-1\n"+
                      "0,0,0,0,0,0,0,0,3,82,0\nw");
    assertEquals("White",board.gameHasEnded());
  }

  @Test
  public void gameHasEndedTestShouldReturnBlack(){
    board = new Board("0,0,0,0,0,0,0,0,1,82,0\n"+
                      "1,0,0,0,0,0,0,0,0,80,-1\nb");
    assertEquals("Black",board.gameHasEnded());
  }

  @Test
  public void makeAMoveWithNoMoveShouldChangeTheTurn(){
    board = new Board("0,1,0,0,0,0,0,0,0,79,-1\n"+
                      "0,0,0,0,0,0,0,0,1,80,-1\nw");
    board.makeAMove(8);
    board.makeAMove(0);
    assertEquals(board.toString(),"0,2,0,0,0,0,0,0,0,79,-1\n"+
                                  "0,0,0,0,0,0,0,0,0,80,-1\nb");
  }
}
