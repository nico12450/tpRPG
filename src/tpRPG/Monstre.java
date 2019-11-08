package tpRPG;

import static tpRPG.UtilsRandom.getRandomInt;

public class Monstre extends Personnage {
	
	
	public Monstre() {
		
		force = getRandomInt(5, 12);
		agilite = getRandomInt(5, 12);
		intelligence = getRandomInt(5, 12);
		PVMax = getRandomInt(200, 300);
		PV = PVMax;
		classe = Classe.Monstre;
				
	}
	
	public void levelUp() {
		
		super.levelUp();
		
		force += getRandomInt(0, 4);
		agilite += getRandomInt(0, 4);
		intelligence += getRandomInt(0, 4);
		PVMax *= 1f + 100f/getRandomInt(6, 10);
		
	}
	
	public void setLevel(int lvl) {
		
		while(this.lvl < lvl) {
			
			levelUp();
			
		}
		
	}
	
	public String toString() {
		
		String description = "Monstre\n";
		description += super.toString();
		
		return description;
		
	}

}
