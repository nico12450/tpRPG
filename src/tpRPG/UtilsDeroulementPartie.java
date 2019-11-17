package tpRPG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import consommables.PotionPVInferieure;

import static tpRPG.UtilsCombat.*;

public class UtilsDeroulementPartie {
	
	private static Scanner sc = new Scanner(System.in);
	private static Personnage joueur;
	private static File fichier =  new File("save.ser") ;
	private static ObjectOutputStream oos = null;
	private static ObjectInputStream ois = null;
	private static boolean continuer;
	
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
				partie();
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
					joueur = new Personnage(Classe.Guerrier, true);	
					break;
					
				case(2):
					
					afficheln("Vous avez choisi de jouer un Mage");
					joueur = new Personnage(Classe.Mage, true);
					break;
					
				case(3):
					
					afficheln("Vous avez choisi de jouer un Voleur");
					joueur = new Personnage(Classe.Voleur, true);
					break;
					
				case(4):
					
					afficheln("Vous avez choisi de jouer un Monstre");
					joueur = new Personnage(Classe.Monstre, true);
					break;
					
				default:
					
					afficheln("choix inconnu, rentrez un nombre entre 1 et 3");
					debutPartie();
			
			}
			
			System.out.println(joueur);
			partie();
			
		}
	
		public static void partie() {
			
			continuer = true;
			
			while(continuer && joueur.isAlive()) {	
					
				choixAction();

				
			}
			
		}
		
		public static void nextTour() {
			
			rencontre();
			
		}
		
		public static void choixAction() {
			
			afficheln("Que souhaitez vous faire ?");
			affiche("1- Continuer");
			affiche("2- menu personnage");
			affiche("3- Sauvegarder");
			affiche("4- Quitter");
			
			String choix = sc.nextLine();
			
			switch (choix) {
			
				case "1":
					
					nextTour();
					break;
					
				case "2":
					
					menuPersonnage();
					break;
					
				case "3":
					
					sauvegarder();
					afficheln("La partie a été sauvegardée");
					choixAction();
					break;
					
				case "4":
					
					System.out.println("fin de la partie");
					continuer = false;
					break;
					
				default:
					
					System.out.println("choix incorrect");
					choixAction();
			
			}
			
		}
		
		public static void rencontre() {
			
			int tirage = UtilsRandom.getRandomInt(1, 4);
			
			if(tirage < 3) {
				
				rencontreEnnemi();
				
			}
			
			else {
				
				rencontreMarchand();
				
			}
			
		}
		
		public static void rencontreEnnemi() {
			
			affiche("Vous rencontrez un monstre");
			
			Personnage monstre = new Personnage(Classe.Monstre, false);
			
			monstre.setLevel(joueur.getLvl());
			
			affiche(monstre);
			
			affiche("fuir ou combattre ? (f/c)");
			
			String choix = sc.nextLine();
			
			switch(choix) {
			
			case "f":
				
				affiche("vous choisissez la fuite");
				fuite();
				break;
				
			case "c":
				
				affiche("vous choisissez le combat");
				combat(joueur, monstre);
				break;
				
			default:
				
				affiche("Choix incorrect");
				rencontreEnnemi();
				
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
			
			menuMarchand();			
			
		}
		
		public static void menuMarchand() {
			
			affiche("Voulez vous acheter vendre ou partir ? (a/v/p)");
			
			String choix = sc.nextLine();
			
			switch(choix) {
			
				case "a":
					
					Consommable achat = menuAchat();
					
					if(achat != null) {
						
						joueur.achatConsommable(achat);
						menuAchat();
						break;
						
					}
					
					else {
						
						menuMarchand();
						break;
						
					}
					

					
				case "v":
					
					affiche("choix non implémenté");
					break;
					
				case "p":
					
					choixAction();
					break;
					
				default:
					
					affiche("choix invalide");
					rencontreMarchand();
					break;
			}
			
		}
		
		public static Consommable menuAchat() {
			
			affiche("1- potion de vie inférieure (1 PO)");
			affiche("2- retour");
			
			String choix = sc.nextLine();
			
			switch (choix) {
			
			case "1":
				
				affiche("vous achetez une potion de vie inférieure");
				return new PotionPVInferieure();
			
			}
			
			return null;
			
		}
		
		public static void menuPersonnage() {
			
			afficheln(joueur);
			affiche("le menu n'est pas encore implémenté appuyez sur une touche pour continuer");
			sc.nextLine();
			choixAction();
			
		}
		
		public static void affiche(Object message) {
			
			System.out.println(message);
			
		}
		
		public static void afficheln(Object message) {
			
			System.out.println("\n" + message + "\n");
			
		}

}
