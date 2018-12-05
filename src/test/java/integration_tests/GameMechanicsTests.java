package integration_tests;

import org.junit.Test;
import org.junit.Before;
import com.athaydes.automaton.Swinger;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;
import frontend.*;

public class GameMechanicsTests {

    Swinger swinger;
    JFrame frame;

    @Before
    public void setup() {
        frame = new frontend.Gui().getFrame();
        swinger = Swinger.forSwingWindow();
    }

    // /**
    //  * Check that a player wins the game and is taken to the congratulations screen
    //  */
    // @Test
    // public void testWinGame(){
    //     // Check score for white player

    //     swinger.clickOn("name:New Game").pause(250);
        
    //     ScoreGUILabel whiteScoreLabel = (ScoreGUILabel)swinger.getAt("name:whiteScore");

    //     swinger.clickOn("name:whiteHole2").pause(250).clickOn("name:blackHole6").pause(250)
    //     .clickOn("name:whiteHole4").pause(250).clickOn("name:blackHole4").pause(250)
    //     .clickOn("name:whiteHole6").pause(250).clickOn("name:blackHole8").pause(250)
    //     .clickOn("name:whiteHole1").pause(250).clickOn("name:blackHole6").pause(250)
    //     .clickOn("name:whiteHole3").pause(250).clickOn("name:blackHole5").pause(250)
    //     .clickOn("name:whiteHole0").pause(250).clickOn("name:blackHole6").pause(250)
    //     .clickOn("name:whiteHole6").pause(250).clickOn("name:blackHole3").pause(250)
    //     .clickOn("name:whiteHole8").pause(250).clickOn("name:blackHole3").pause(250)
    //     .clickOn("name:whiteHole7").pause(250).clickOn("name:blackHole3").pause(250)
    //     .clickOn("name:whiteHole2").pause(250);

    //     // TODO: assert win
    // }

    // /**
    //  * Check no scoring for white and black player - if the total is odd
    //  */
    // @Test
    // public void testNoScoringOnOdd(){
    //     // Check score for white player

    //     swinger.clickOn("name:New Game").pause(250);
        
    //     ScoreGUILabel whiteScoreLabel = (ScoreGUILabel)swinger.getAt("name:whiteScore");
    //     ScoreGUILabel blackScoreLabel = (ScoreGUILabel)swinger.getAt("name:blackScore");
        
    //     swinger.clickOn("name:whiteHole2").pause(250).clickOn("name:blackHole6").pause(250);

    //     int blackScoreAfter = Integer.parseInt(blackScoreLabel.getScore());

    //     assertEquals(((Hole)swinger.getAt("name:whiteHole5")).getNumberOfKorgools(), 11);
    //     assertEquals(blackScoreAfter, 0);

    //     // Check score for black player

    //     swinger.clickOn("name:whiteHole0").pause(250);
    //     int whiteScoreAfter= Integer.parseInt(whiteScoreLabel.getScore());

    //     assertEquals(((Hole)swinger.getAt("name:whiteHole1")).getNumberOfKorgools(), 11);
    //     assertEquals(whiteScoreAfter, 10);
    // }

    // /**
    //  * Check basic scoring for white and black player - if the total is even
    //  */
    // @Test
    // public void testScoringOnEven(){
    //     // Check score for white player

    //     swinger.clickOn("name:New Game").pause(250);
        
    //     ScoreGUILabel whiteScoreLabel = (ScoreGUILabel)swinger.getAt("name:whiteScore");
    //     ScoreGUILabel blackScoreLabel = (ScoreGUILabel)swinger.getAt("name:blackScore");
        
    //     swinger.clickOn("name:whiteHole2").pause(250);

    //     int whiteScoreAfter = Integer.parseInt(whiteScoreLabel.getScore());

    //     assertEquals(((Hole)swinger.getAt("name:blackHole1")).getNumberOfKorgools(), 0);
    //     assertEquals(whiteScoreAfter, 10); // 10 korgools in first move

    //     // Check score for black player

    //     swinger.clickOn("name:blackHole2").pause(250);
    //     int blackScoreAfter= Integer.parseInt(blackScoreLabel.getScore());

    //     assertEquals(((Hole)swinger.getAt("name:whiteHole1")).getNumberOfKorgools(), 0);
    //     assertEquals(blackScoreAfter, 10); // 10 korgools in first move   
    // }

    // /**
    //  * Check white player owned tuz is formed and korgools move correctly to  
    //  * kazan if landing in the tuz
    //  */
    // @Test
    // public void testWhiteScoreInTuz(){
    //     swinger.clickOn("name:New Game").pause(250).clickOn("name:whiteHole2").pause(250)
    //     .clickOn("name:blackHole6").pause(250).clickOn("name:whiteHole8").pause(250)
    //     .clickOn("name:blackHole7").pause(250);

    //     ScoreGUILabel whiteScoreLabel = (ScoreGUILabel)swinger.getAt("name:whiteScore");

    //     // Tuz is claimed on black side
    //     int scoreBeforeTuz = Integer.parseInt(whiteScoreLabel.getScore());
    //     swinger.clickOn("name:whiteHole4").pause(250);
    //     int scoreAfterTuz = Integer.parseInt(whiteScoreLabel.getScore());

    //     assertTrue(((Hole)swinger.getAt("name:blackHole6")).isTuz());
    //     assertEquals(scoreAfterTuz, scoreBeforeTuz + 3); // 3 korgools needed for tuz

    //     // Make two more moves - check korgool is added to kazan from tuz
    //     swinger.clickOn("name:blackHole8").pause(250);
        
    //     int scoreBeforeKorgoolInTuz = Integer.parseInt(whiteScoreLabel.getScore());
    //     swinger.clickOn("name:whiteHole7").pause(250);
    //     int scoreAfterKorgoolInTuz = Integer.parseInt(whiteScoreLabel.getScore());

    //     assertEquals(((Hole)swinger.getAt("name:blackHole6")).getNumberOfKorgools(), 0);
    //     assertEquals(scoreAfterKorgoolInTuz, scoreBeforeKorgoolInTuz + 1);
    // }

    // /**
    //  * Check black player owned tuz is formed and korgools move correctly to  
    //  * kazan if landing in the tuz
    //  */
    // @Test
    // public void testBlackScoreInTuz(){
    //     swinger.clickOn("name:New Game").pause(250).clickOn("name:whiteHole2").pause(250)
    //     .clickOn("name:blackHole6").pause(250).clickOn("name:whiteHole3").pause(250);

    //     ScoreGUILabel blackScoreLabel = (ScoreGUILabel)swinger.getAt("name:blackScore");

    //     // Tuz is claimed on white side
    //     int scoreBeforeTuz = Integer.parseInt(blackScoreLabel.getScore());
    //     swinger.clickOn("name:blackHole2").pause(250);
    //     int scoreAfterTuz = Integer.parseInt(blackScoreLabel.getScore());

    //     assertTrue(((Hole)swinger.getAt("name:whiteHole2")).isTuz());
    //     assertEquals(scoreAfterTuz, scoreBeforeTuz + 3); // 3 korgools needed for tuz

    //     // Make two more moves - check korgool is added to kazan from tuz
    //     swinger.clickOn("name:whiteHole7").pause(250);
        
    //     int scoreBeforeKorgoolInTuz = Integer.parseInt(blackScoreLabel.getScore());
    //     swinger.clickOn("name:blackHole7").pause(250);
    //     int scoreAfterKorgoolInTuz = Integer.parseInt(blackScoreLabel.getScore());

    //     assertEquals(((Hole)swinger.getAt("name:whiteHole2")).getNumberOfKorgools(), 0);
    //     assertEquals(scoreAfterKorgoolInTuz, scoreBeforeKorgoolInTuz + 1);
    // }

    // /**
    //  * Basic 3 move cycle - Check all korgools move correctly
    //  */
    // @Test
    // public void testKorgoolsMoveCorrectly(){

    //     // White turn 1
    //     swinger.clickOn("name:New Game").pause(500).clickOn("name:whiteHole2").pause(500);

    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole2")).getNumberOfKorgools(), 1);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole3")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole4")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole5")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole6")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole7")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole8")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole0")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole1")).getNumberOfKorgools(), 0);

    //     // Black turn 1
    //     swinger.clickOn("name:blackHole0").pause(500);
        
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole0")).getNumberOfKorgools(), 1);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole1")).getNumberOfKorgools(), 1);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole2")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole3")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole4")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole5")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole6")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole7")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole8")).getNumberOfKorgools(), 10);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole0")).getNumberOfKorgools(), 0);

    //     // White turn 2
    //     swinger.clickOn("name:whiteHole4").pause(500);

    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole4")).getNumberOfKorgools(), 1);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole5")).getNumberOfKorgools(), 11);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole6")).getNumberOfKorgools(), 11);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole7")).getNumberOfKorgools(), 11);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:whiteHole8")).getNumberOfKorgools(), 11);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole0")).getNumberOfKorgools(), 2);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole1")).getNumberOfKorgools(), 2);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole2")).getNumberOfKorgools(), 11);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole3")).getNumberOfKorgools(), 11);
    //     assertEquals(((frontend.Hole)swinger.getAt("name:blackHole4")).getNumberOfKorgools(), 11);
    // }



    

}