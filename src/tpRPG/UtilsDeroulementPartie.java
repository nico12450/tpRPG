package tpRPG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import static tpRPG.UtilsCombat.*;

public class UtilsDeroulementPartie {
	
	private static Scanner sc = new Scanner(System.in);
	private static Personnage joueur;
	private static int nbTour = 0;
	private static File fichier =  new File("save.ser") ;
	private static ObjectOutputStream oos = null;
	private static ObjectInputStream ois = null;
	
	public static void menuDemarrage() {
		
		try {
			
			ois = new ObjectInputStream(new FileInputStream(fichier));
			
		}
		
		catch(IOException e) {
			
			debutPartie();
			return;
			
		}
		
		finally {
			
			try {
				
				ois.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				
			}
			
		}
		
		afficheln("Que souhaitez vous faire ?");
		
		affiche("1- Charger une partie existante");
		affiche("2- Commencer une nouvelle partie");
		
		int choix = Integer.parseInt(sc.nextLine());
		
		switch(choix) {
		
			case(1):
				
				chargerPartie();
				nextTour();
				break;
				
			case(2):
				
				debutPartie();
				break;
				
			default:
				
				afficheln("Choix inconnu");
				menuDemarrage();
				break;
			
		}
		
	}
	
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
			
			rencontre();
			
			if(joueur.isAlive()) {
				
				choixAction();
				
			}
			
		}
		
		public static void choixAction() {
			
			afficheln("Que souhaitez vous faire ?");
			affiche("1- Continuer");
			affiche("2- Sauvegarder");
			affiche("3- Quitter");
			
			String choix = sc.nextLine();
			
			switch (choix) {
			
				case "1":
					
					nextTour();
					break;
					
				case "2":
					
					sauvegarder();
					afficheln("La partie a été sauvegardée");
					choixAction();
					break;
					
				case "3":
					
					System.out.println("fin de la partie");
					break;
					
				default:
					
					System.out.println("choix incorrect");
					choixAction();
			
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
		
		public static void sauvegarder() {
			
			try {
				
				oos = new ObjectOutputStream(new FileOutputStream(fichier));
				oos.writeObject(joueur) ;
				
			}
			
			catch (IOException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			finally {
				
				try {
					
					oos.close();
					
				} catch (IOException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			}


			
		}
		
		public static void chargerPartie() {
			
			try {
				
				ois = new ObjectInputStream(new FileInputStream(fichier));
				
				try {
					
					joueur = (Personnage) ois.readObject();
					
				} catch (ClassNotFoundException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			}
			
			catch (IOException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			finally {
				
				try {
					
					ois.close();
					
				} catch (IOException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			}
			
		}
		
		public static void rencontreMarchand() {
			
			afficheln("Vous rencontrez le marchand");
			
		}
		
		public static void affiche(Object message) {
			
			System.out.println(message);
			
		}
		
		public static void afficheln(Object message) {
			
			System.out.println("\n" + message + "\n");
			
		}

}
