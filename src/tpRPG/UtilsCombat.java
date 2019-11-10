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
					
				}
				
			}
			
			else {
				
				actionAdversaire();
				
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
	
	public static void actionAdversaire() {
		
		afficheln("au tour de l'adversaire");
		
		int degats = 0;
		
		affiche("l'attaque de l'adversaire n'est pas encore implémentée");
		
		affiche("vous recevez " + degats + " degats");
		
	}

}
