package tpRPG;

import java.io.Serializable;

public abstract class Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1233192891438319937L;
	protected String description;
	protected int valeur;
	
	public int getValeur() {
		
		return this.valeur;
		
	}

}
