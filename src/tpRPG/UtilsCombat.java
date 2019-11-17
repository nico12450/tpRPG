package tpRPG;
import static tpRPG.UtilsRandom.getRandomInt;

import java.util.Scanner;

import static tpRPG.UtilsDeroulementPartie.*;

public class UtilsCombat {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void combat(Personnage joueur, Personnage adversaire) {
		
		afficheln("début du combat");
		
		int tirage = getRandomInt(0, 2);
		
		if(tirage == 0) {
			
			afficheln("à vous de commencer");
			
		}
		
		else {
			
			afficheln("l'ennemi commence");
			
		}
		
		while(joueur.isAlive() && adversaire.isAlive()) {
			
			if(tirage == 0) {
				
				actionJoueur(joueur, adversaire);
				
				if(adversaire.isAlive()) {
					
					affiche("l'adversaire possède encore " + adversaire.getPV() + " PV");
					
				}
				
				else {
					
					afficheln("l'adversaire est vaincu");
					
					int lvlEnnemi = adversaire.getLvl();
					
					String message = lvlEnnemi > 1 ? " point d'expérience reçu" : " points d'expérience reçus";
					
					affiche(lvlEnnemi + message);
					
					joueur.giveXP(lvlEnnemi);
					joueur.giveMoney(getRandomInt(lvlEnnemi, lvlEnnemi * 3));
					
				}
				
			}
			
			else {
				
				actionAdversaire(joueur, adversaire);
				
				if(joueur.isAlive()) {
				
					affiche("vous possédez encore " + joueur.getPV() + " PV");
					
				}
				
				else {
					
					affiche("vous etes mort");	
					
				}
				
			}
			
			tirage = 1 - tirage;
			
		}
		
	}
	
	public static void actionJoueur(Personnage joueur, Personnage adversaire) {
		
		afficheln("choix de l'action");
		affiche("1- attaque physique");
		affiche("2- attaque magique");
		
		int degats = 0;
		
		String choix = sc.nextLine();
		
		switch (choix) {
		
		case "1":
			
			affiche("vous effectuez une attaque physique");
			degats += joueur.getDegatsPhysiques();
			adversaire.degats(degats, true);
			break;
			
		case "2":
			
			affiche("vous effectuez une attaque magique");
			degats += joueur.getDegatsMagiques();
			adversaire.degats(degats, false);
			break;
			
		default:
			
			affiche("choix incorrect");
		
		}	
		
	}
	
	public static void actionAdversaire(Personnage joueur, Personnage adversaire) {
		
		afficheln("au tour de l'adversaire");
		
		int degats = 0;
		
		affiche("L'adversaire effectue une attaque physique");
		
		degats += adversaire.getDegatsPhysiques();	
		joueur.degats(degats, true);
		
	}
	
	public static void fuite() {
		
		affiche("La fuite n'est pas encore implémentée");
		
	}

}
