package tpRPG;

public class Voleur extends Personnage{
	
	public Voleur() {
		super();
		PVMax = 250;
		PV = PVMax;
		this.force = 8;
		this.agilite = 10;
		this.intelligence = 8;
		this.classe = Classe.Voleur;

	}
	
	@Override
	public void levelUp() {
		// TODO Auto-generated method stub
		super.levelUp();
		
		this.force += 2;
		this.agilite += 3;
		this.intelligence += 2;
		this.PVMax *= 1.08;
			
	}
	
	public String toString() {
		
		String description = "classe : Voleur\n";
		description += super.toString();
		
		return description;
		
	}
	
}
