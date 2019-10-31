package tpRPG;

public class Mage extends Personnage{
	
	private int PV = 200;
	private int force = 6;
	private int agilite = 6;
	private int intelligence = 10;
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
		this.agilite += 1;
		this.intelligence += 5;
		this.PV *= 1.06;
		
	}
	
	public String toString() {
		
		String description = "caractéristiques du personnage : \n";
		description += "classe : Mage\n";
		description += "force : " + this.force + "\n";
		description += "agilité : " + this.agilite + "\n";
		description += "intelligence : " + this.intelligence + "\n";
		
		return description;
		
	}
	
}
