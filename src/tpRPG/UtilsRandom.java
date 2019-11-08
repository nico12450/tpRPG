package tpRPG;

import java.util.Random;

public class UtilsRandom {
	
	private static Random r = new Random();
	
	public static int jetDeDes12() {
	
		int resultat = r.nextInt(12) + 1;
		
		return resultat;
		
	}
	
	public static int getRandomInt(int min, int max) {
		
		return r.nextInt(max-min) + min;
		
	}
	
	public static Classe getRandomClasse() {
		
		int nbClasses = Classe.values().length;
		
		return Classe.values()[UtilsRandom.getRandomInt(0, nbClasses)];
		
	}

}
