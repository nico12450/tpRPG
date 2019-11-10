package tpRPG;

public abstract class Arme {
	
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
