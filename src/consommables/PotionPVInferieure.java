package consommables;

import tpRPG.*;

public class PotionPVInferieure extends Item{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9129916933042463930L;

	public void effet(Personnage p) {
		
		p.addPV(50);
		
	}

}
