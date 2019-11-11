package tpRPG;

public abstract class Consommable extends Item {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6692653243339836331L;

	protected abstract void effet(Personnage p);

}
