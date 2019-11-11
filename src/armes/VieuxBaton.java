package armes;

import tpRPG.*;

public class VieuxBaton extends Arme{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7579923862573650051L;

	public VieuxBaton() {
		
		this.degatsMagiques = 8;
		this.degatsPhysiques = 3;
		this.typeArme = TypeArme.DeuxMain;
		this.rarete = Rarete.Commun;
		this.valeur = 10;
		this.description = "vieux baton";
		
	}

}
