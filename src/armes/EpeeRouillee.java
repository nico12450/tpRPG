package armes;

import tpRPG.*;

public class EpeeRouillee extends Arme {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4779561178559628708L;

	public EpeeRouillee() {
		
		this.degatsPhysiques = 5;
		this.typeArme = TypeArme.DeuxMain;
		this.rarete = Rarete.Commun;
		this.valeur = 5;
		this.description = "vieille épée rouillée";
		
	}

}
