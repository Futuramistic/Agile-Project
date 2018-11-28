package frontend;

import backend.Board;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import backend.*;

/**
* Panel with the board game
**/
public class BoardGUI extends JPanel
{
	private Board board;
	private Player black;
	private Player white;

  public BoardGUI()
  {
  	board = new Board("0,0,1,0,0,0,0,0,0,20,0\n"+
                      "0,0,0,0,0,0,0,0,0,13,0\nw");
    this.setLayout(new GridLayout(3,1));
    black = new Player(9, e -> onButtonClick(e));
    this.add(black.showHoles());
    white = new Player(9,e -> onButtonClick(e));
		this.add(setCenter());
    this.add(white.showHoles());
		updateGUI(board.toString());
  }

  private JPanel setCenter()
  {
    JPanel center = new JPanel();
    center.setLayout(new GridLayout(1,2));
    center.add(black.showScoreLabel());
    center.add(white.showScoreLabel());
    return center;
  }

  private void onButtonClick(ActionEvent e) {
		System.out.println("\n This is the board before the move:");
		  System.out.println(board);
      int indexOfHole = ((Hole) e.getSource()).getIndex();
      //call backend, and tell them the index of the cell that has been clicked

      //get necessary information from backend to update the state of the game/GUI
			board.makeAMove(indexOfHole);
      updateGUI(board.toString());
			System.out.println("This is the board after the move:");
			System.out.println("BUTTON PRESSED: " +  indexOfHole);
      System.out.println(board);
  }

  private void updateGUI(String boardState) {
    //update the information
		String[] info = boardState.split("\n");
		black.update(info[0]);
		white.update(info[1]);
		blockPlayer(info[2]);
    this.repaint();
		this.revalidate();
		if(SwingUtilities.getRoot(this)!=null){
			JFrame frame = (JFrame) SwingUtilities.getRoot(this);
			frame.pack();
		}
  }

	private void blockPlayer(String player)
	{
		if(player.equals("w"))
		{
			black.blockHoles();
			white.unblockHoles();
		}
		else
		{
			white.blockHoles();
			black.unblockHoles();
		}
	}
}
