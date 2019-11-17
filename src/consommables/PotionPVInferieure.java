package consommables;

import tpRPG.*;

public class PotionPVInferieure extends Consommable{
	
	private static final long serialVersionUID = -9129916933042463930L;
	
	public PotionPVInferieure() {
		
		description = "Potion de PV inférieure (50PV)";
		
	}

	public void effet(Personnage p) {
		
		p.addPV(50);
		UtilsDeroulementPartie.affiche("Vous recevez 50 PV");
		
	}

}
