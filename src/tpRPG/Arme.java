package tpRPG;

public abstract class Arme extends Item{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9164024516045867053L;
	protected int degatsPhysiques = 0;
	protected int degatsMagiques = 0;
	protected TypeArme typeArme;
	protected Rarete rarete;
	
	public int getDegatsPhysiques() {
		return degatsPhysiques;
	}
	public int getDegatsMagiques() {
		return degatsMagiques;
	}
	
}
