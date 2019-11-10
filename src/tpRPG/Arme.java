package tpRPG;

import java.io.Serializable;

public abstract class Arme implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9145663592899238418L;
	protected int degatsPhysiques = 0;
	protected int degatsMagiques = 0;
	protected TypeArme type;
	protected int valeur;
	protected Rarete rarete;
	
	public int getDegatsPhysiques() {
		return degatsPhysiques;
	}
	public int getDegatsMagiques() {
		return degatsMagiques;
	}
	
}
