package consommables;

import tpRPG.*;

public class PotionPVInferieure extends Item{
	
	public void effet(Personnage p) {
		
		p.addPV(50);
		
	}

}
