package backend;

public class Hole extends Cell{
	private boolean isTuz;
	private static final int STARTING_KORGOOLS = 9;
	private static final int KORGOOLS_TO_TUZ = 3;

	public Hole(){
		super(STARTING_KORGOOLS);
		isTuz = false;
	}

	public Hole(int korgools) {
		super(korgools);
		isTuz = false;
	}

	/**
	 * Return the korgools contained and then set them to 0.
	 * @return The number of korgools
	 */
	public int setKorgoolsToZero(){
		int temp = korgools;
		korgools = 0;
		return temp;
	}

	public void korgoolsPlusOne(){
		korgools++;
	}

	public void setTuz(){
		isTuz = true;
	}

	public boolean isTuz(){
		return isTuz;
	}

	public boolean isTuzzable(){
		return(!isTuz && korgools==KORGOOLS_TO_TUZ);
	}
}
