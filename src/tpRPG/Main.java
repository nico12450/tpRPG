package tpRPG;

import java.util.Scanner;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	private static Personnage personnage;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		debutPartie();
		sc.close();

	}
	
	public static void debutPartie() {
		
		afficheln("début de la partie");
		afficheln("choix du personnage");
		
		affiche("1- Guerrier");
		affiche("2- Mage");
		affiche("3- Voleur");
		
		afficheln("entrez votre choix : ");
		
		int choix = Integer.parseInt(sc.nextLine());
		
		switch(choix) {
			
			case(1):
				
				afficheln("Vous avez choisi Guerrier");
				personnage = new Guerrier();	
				break;
				
			case(2):
				
				afficheln("Vous avez choisi Mage");
				personnage = new Mage();
				break;
				
			case(3):
				
				afficheln("Vous avez choisi Voleur");
				personnage = new Voleur();
				break;
				
			default:
				
				afficheln("choix inconnu, rentrez un nombre entre 1 et 3");
				debutPartie();
		
		}
		
	}
	
	public static void affiche(String message) {
		
		System.out.println(message);
		
	}
	
	public static void afficheln(String message) {
		
		System.out.println("\n" + message + "\n");
		
	}

}
