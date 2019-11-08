package tpRPG;

public class Guerrier extends Personnage {
	
	public Guerrier() {
		super();
		PVMax = 300;
		PV = PVMax;
		this.force = 10;
		this.agilite = 8;
		this.intelligence = 6;
		this.classe = Classe.Guerrier;
	}

	
	@Override
	public void levelUp() {
		// TODO Auto-generated method stub
		super.levelUp();
		
		this.force += 4;
		this.agilite += 1;
		this.intelligence += 1;
		this.PVMax *= 1.1;
		
	}
	
	public String toString() {
		
		String description = "classe : " + this.classe + "\n";
		
		description += super.toString();
		
		return description;
		
	}

}
