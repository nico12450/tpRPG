package tpRPG;

public class Voleur extends Personnage{

	private int PV = 250;
	private int force = 8;
	private int agilite = 10;
	private int intelligence = 8;
	private int lvl = 1;
	private int xp = 1;
	
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
	
	@Override
	public void levelUp() {
		// TODO Auto-generated method stub
		super.levelUp();
		
		this.force += 2;
		this.agilite += 3;
		this.intelligence += 2;
		this.PV *= 1.08;
			
	}
	
	public String toString() {
		
		String description = "Caractéristiques du personnage : \n";
		description += "classe : Voleur\n";
		description += "force : " + this.force + "\n";
		description += "agilité : " + this.agilite + "\n";
		description += "intelligence : " + this.intelligence + "\n";
		
		return description;
		
	}
	
}
