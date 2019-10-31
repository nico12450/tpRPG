package tpRPG;

public class Mage implements Personnage{
	
	private int PV = 200;
	private int force = 6;
	private int agilité = 6;
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
	public int getAgilité() {
		return agilité;
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
		System.out.println("lvl up");	
		
		this.force += 2;
		this.agilité += 1;
		this.intelligence += 5;
		this.PV *= 1.06;

		
	}
	
}
