package tpRPG;

public abstract class Personnage {
	
	protected int PV;
	protected int force;
	protected int agilite;
	protected int intelligence;
	protected int lvl = 1;
	protected int xp = 1;
	protected int PVMax;
	protected Classe classe;
	
	public int getXp() {
		return xp;
	}
	public int getPV() {
		return PV;
	}
	public int getForce() {
		return force;
	}
	public int getAgilite() {
		return agilite;
	}
	public int getIntelligence() {
		return intelligence;
	}
	
	public int getLvl() {
		return lvl;
	}
	
	public int getPVMax() {
		return PVMax;
	}
	public Classe getClasse() {
		return classe;
	}
	
	public void levelUp() {
		// TODO Auto-generated method stub
		// System.out.println("lvl up");
		lvl++;
		
	}
	
	//à améliorer pour tenir compte du niveau de l'adversaire de l'armure et du type d'attaque
	public void degats(int nbDegats) {
		
		PV -= nbDegats;
		
	}
	
	public boolean isAlive() {
		
		return this.getPV() > 0;
		
	}
	
	public String toString() {
		
		String description = "caractéristiques du personnage : \n";
		description += "force : " + this.getForce() + "\n";
		description += "agilité : " + this.getAgilite() + "\n";
		description += "intelligence : " + this.getIntelligence() + "\n";
		description += "PV : " + this.getPV() + "\n";
		description += "PV maximum : " + this.getPVMax() + "\n";
		description += "lvl : " + this.getLvl() + "\n";
		
		return description;
		
	}
	
}
