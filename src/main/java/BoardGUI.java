import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

/**
* Panel with the board game
**/
public class BoardGUI extends JPanel
{
  public BoardGUI()
  {
    this.setLayout(new BorderLayout());
    Player pl1 = new Player("PLAYER 1",9, e -> onButtonClick(e));
    this.add(pl1.showHoles(), BorderLayout.NORTH);
    Player pl2 = new Player("PLAYER 2",9,e -> onButtonClick(e));
    this.add(pl2.showHoles(), BorderLayout.SOUTH);
    this.add(setCenter(pl1,pl2), BorderLayout.CENTER);
  }

  private JPanel setCenter(Player pl1, Player pl2)
  {
    JPanel center = new JPanel();
    center.setLayout(new FlowLayout());
    center.add(pl1.showScoreLabel());
    center.add(pl2.showScoreLabel());
    return center;
  }

  private void onButtonClick(ActionEvent e) {
      int indexOfHole = ((Hole) e.getSource()).getIndex();
      System.out.println(indexOfHole); // TODO test

      ((Hole) e.getSource()).makeTuz();
      //call backend, and tell them the index of the cell that has been clicked

      //get necessary information from backend to update the state of the game/GUI

      updateGUI();
  }

  private void updateGUI() {
    //update the information
      // update the holes
      // update the score
      // update the tuz location

    this.repaint();
  }

}
