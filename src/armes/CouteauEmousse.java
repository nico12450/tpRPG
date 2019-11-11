package armes;

import tpRPG.*;

public class CouteauEmousse extends Arme {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3847378526592591311L;

	public CouteauEmousse() {
		
		this.degatsPhysiques = 5;
		this.typeArme = TypeArme.UneMain;
		this.rarete = Rarete.Commun;
		this.valeur = 3;
		this.description = "couteau émoussé";
		
	}

}
