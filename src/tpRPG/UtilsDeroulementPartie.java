package tpRPG;

import java.util.Scanner;

public class UtilsDeroulementPartie {
	
	private static Scanner sc = new Scanner(System.in);
	private static Personnage personnage;
	private static int nbTour = 0;
	
	public static void debutPartie() {
			
			afficheln("début de la partie");
			afficheln("choix du personnage");
			
			affiche("1- Guerrier");
			affiche("2- Mage");
			affiche("3- Voleur");
			affiche("4- Monstre");
			
			afficheln("entrez votre choix : ");
			
			int choix = Integer.parseInt(sc.nextLine());
			
			switch(choix) {
				
				case(1):
					
					afficheln("Vous avez choisi de jouer un Guerrier");
					personnage = new Guerrier();	
					break;
					
				case(2):
					
					afficheln("Vous avez choisi de jouer un Mage");
					personnage = new Mage();
					break;
					
				case(3):
					
					afficheln("Vous avez choisi de jouer un Voleur");
					personnage = new Voleur();
					break;
					
				case(4):
					
					afficheln("Vous avez choisi de jouer un Monstre");
					personnage = new Monstre();
					break;
					
				default:
					
					afficheln("choix inconnu, rentrez un nombre entre 1 et 3");
					debutPartie();
			
			}
			
			System.out.println(personnage);
			nextTour();
			
		}
		
		public static void affiche(String message) {
			
			System.out.println(message);
			
		}
		
		public static void afficheln(String message) {
			
			System.out.println("\n" + message + "\n");
			
		}
		
		public static void nextTour() {
			
			nbTour++;
			
			afficheln("Début du tour " + nbTour);
			
			rencontre();
			
			testContinuer();
			
		}
		
		public static void testContinuer() {
			
			afficheln("Voulez vous continuer ? o/n");
			
			String choix = sc.nextLine();
			
			switch (choix) {
			
				case "o":
					
					nextTour();
					break;
					
				case "n":
					
					System.out.println("fin de la partie");
					break;
					
				default:
					
					System.out.println("choix incorrect");
					testContinuer();
			
			}
			
		}
		
		public static void rencontre() {
			
			switch (UtilsRandom.getRandomInt(1, 2)) {
			
			case 1:
				
				rencontreEnnemi();
				break;
			
			}
			
		}
		
		public static void rencontreEnnemi() {
			
			afficheln("Vous rencontrez un monstre");
			
		}

}
