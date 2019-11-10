package tpRPG;

import java.util.Scanner;
import static tpRPG.UtilsCombat.*;

public class UtilsDeroulementPartie {
	
	private static Scanner sc = new Scanner(System.in);
	private static Personnage joueur;
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
					joueur = new Personnage(Classe.Guerrier);	
					break;
					
				case(2):
					
					afficheln("Vous avez choisi de jouer un Mage");
					joueur = new Personnage(Classe.Mage);
					break;
					
				case(3):
					
					afficheln("Vous avez choisi de jouer un Voleur");
					joueur = new Personnage(Classe.Voleur);
					break;
					
				case(4):
					
					afficheln("Vous avez choisi de jouer un Monstre");
					joueur = new Personnage(Classe.Monstre);
					break;
					
				default:
					
					afficheln("choix inconnu, rentrez un nombre entre 1 et 3");
					debutPartie();
			
			}
			
			System.out.println(joueur);
			nextTour();
			
		}
		
		public static void nextTour() {
			
			nbTour++;
			
			afficheln("Début du tour " + nbTour);
			
			rencontre();
			
			if(joueur.isAlive()) {
				
				choixContinuer();
				
			}
			
		}
		
		public static void choixContinuer() {
			
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
					choixContinuer();
			
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
			
			affiche("Vous rencontrez un monstre");
			
			Personnage monstre = new Personnage(Classe.Monstre);
			
			monstre.setLevel(joueur.getLvl());
			
			affiche(monstre);
			
			affiche("fuir ou combattre ? (f/c)");
			
			String choix = sc.nextLine();
			
			switch(choix) {
			
			case "f":
				
				affiche("vous choisissez la fuite");
				break;
				
			case "c":
				
				affiche("vous choisissez le combat");
				combat(joueur, monstre);
				
			}
			
		}
		
		public static void affiche(Object message) {
			
			System.out.println(message);
			
		}
		
		public static void afficheln(Object message) {
			
			System.out.println("\n" + message + "\n");
			
		}

}
