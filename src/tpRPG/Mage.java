package tpRPG;

public class Mage extends Personnage{
	
	public Mage() {
		super();
		PVMax = 200;
		PV = PVMax;
		force = 6;
		this.agilite = 6;
		this.intelligence = 10;
		this.classe = Classe.Mage;

	}

	@Override
	public void levelUp() {
		// TODO Auto-generated method stub
		super.levelUp();	
		
		this.force += 2;
		this.agilite += 1;
		this.intelligence += 5;
		this.PVMax *= 1.06;
		
	}
	
	public String toString() {
		
		String description = "classe : Mage\n";
		description += super.toString();

		return description;
		
	}
	
}
