package backend;

public class Player {
    private static final int N_HOLES = 9;
    private static final int UNTUZZABLE_HOLE = N_HOLES-1;//position in the array
    public Hole[] holes;
    private Kazan kazan;
    private boolean tuzIsAvailable;

    /**
     * Public constructor for Board game
     */
    public Player(){
      holes = new Hole[N_HOLES];
      for(int i = 0; i< N_HOLES;i++){
			holes[i] = new Hole();      
      }
      kazan = new Kazan();
      tuzIsAvailable = true;
    }

    /**
     * Take the number of a hole, empty it and move all the balls
     * into the next holes. A tuz can be called after a move.
     * @param startHole : The position of the hole you want to empty
     * @return 0 if all the korgools moveble from the starting hole have been moved,
     * otherwise return the remaining korgools;
     */
    public int act(int startHole){
    	  int movebleKorgools = holes[startHole].setKorgoolsToZero();
		    return moveKorgools(movebleKorgools,startHole);
    }


	 /**
	  * When moveKorgools method is called from outside, it means it has to start from
	  * the first hole, it only needs to know the korgoolsLeft
	  * @param korgoolsLeft: The left korgools to be distributed on board
	  * @return 0 if all the korgools left have been moved,
    * otherwise return the remaining korgools;
    */

	 public int moveKorgools(int korgoolsLeft){
		   return moveKorgools(korgoolsLeft,0);
	 }

	 /**
    * Distribute the korgools taken from a hole into the following holes.
    * @param korgoolsLeft: the korgools to redistribute.
    * @param currentHole: the hole to start from to redistribute
    * @return 0 if all the korgools have been redistributed, otherwise
    * return the remaining korgools;
    */
	 public int moveKorgools(int korgoolsLeft,int currentHole){
		   while(korgoolsLeft>0){
		      holes[currentHole].korgoolsPlusOne();
		      korgoolsLeft--;
          if(currentHole == N_HOLES-1)
            return korgoolsLeft;
          currentHole++;
          }

       if(hasTuzOption(currentHole)){
            holes[currentHole].setTuz();
            tuzIsAvailable = false;
       }
		   return 0;
	 }
	 
    /**
     * Check if the player can still set a tuz,
     * @param n : The player who wants to set the tuz
     */
    public boolean hasTuzOption(int currentHole){
      return (tuzIsAvailable && holes[currentHole].isTuzzable() && currentHole != UNTUZZABLE_HOLE);
    }

    public boolean hasWon(){
      return kazan.hasWon();
    }

     /**Empties the tuz and returns the number of korgools removed
     @return korgools removed from tuz if there is one, 0 otherwise*
     */
    public int emptyTuz(){
      for(Hole hole: holes){
        if(hole.isTuz())
          return hole.setKorgoolsToZero();
        }
      return 0;
    }

  /**
  *Increases the number of korgools in the kazan.
   @param numKorgools the number of korgools to add
   @return the number of korgools added*/
    public int addKorgoolsToKazan(int numKorgools){
          kazan.increaseKorgoolsBy(numKorgools);
          return numKorgools;
    }
}
