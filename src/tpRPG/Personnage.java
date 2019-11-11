package tpRPG;

import static tpRPG.UtilsDeroulementPartie.affiche;

import static tpRPG.UtilsRandom.getRandomInt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import armes.*;

public class Personnage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5030269565134710376L;
	private int PV;
	private int force;
	private int agilite;
	private int intelligence;
	private int lvl = 1;
	private int xp = 0;
	private int PVMax;
	private Classe classe;
	private Arme armeEquipee;
	private int argent = 0;
	private List<Item> items = new ArrayList<Item>();
	
	
	
	public Personnage(Classe classe) {
		
		super();
		this.classe = classe;

		switch (classe) {
		
			case Guerrier:
				
				this.PVMax = 300;
				this.PV = PVMax;
				this.force = 10;
				this.agilite = 8;
				this.intelligence = 6;
				this.armeEquipee = new EpeeRouillee();
				break;
				
			case Mage:
				
				this.PVMax = 200;
				this.PV = PVMax;
				this.force = 6;
				this.agilite = 6;
				this.intelligence = 10;
				this.armeEquipee = new VieuxBaton();
				break;
				
			case Voleur:
				
				this.PVMax = 250;
				this.PV = PVMax;
				this.force = 8;
				this.agilite = 10;
				this.intelligence = 8;
				this.armeEquipee = new CouteauEmousse();
				break;
				
			case Monstre:
				
				this.force = getRandomInt(5, 12);
				this.agilite = getRandomInt(5, 12);
				this.intelligence = getRandomInt(5, 12);
				this.PVMax = getRandomInt(200, 300);
				this.PV = PVMax;
				this.armeEquipee = new Griffes();
				break;
		
		}
		
	}
	
	public int getXp() {
		return xp;
	}
	public int getPV() {
		return PV;
	}
	public int getForce() {
		return force;
	}
	public int getAgilite() {
		return agilite;
	}
	public int getIntelligence() {
		return intelligence;
	}
	
	public int getLvl() {
		return lvl;
	}
	
	public int getPVMax() {
		return PVMax;
	}
	public Classe getClasse() {
		return classe;
	}
	
	public int getDegatsPhysiques(){
		
		return force * armeEquipee.getDegatsPhysiques();
		
	}
	
	public int getDegatsMagiques() {
		
		return intelligence * armeEquipee.getDegatsMagiques();
		
	}

	public Arme getArmeEquipee() {
		return armeEquipee;
	}

	public int getArgent() {
		return argent;
	}

	public void giveXP(int nbXP) {
		
		xp += nbXP;
		
		if(xp >= lvl * lvl) {
			
			levelUp();
			
		}
		
	}
	
	public void levelUp() {
		
		switch (classe) {
		
			case Guerrier:
				
				this.force += 4;
				this.agilite += 1;
				this.intelligence += 1;
				this.PVMax *= 1.1;
				break;
				
			case Mage:
				
				this.force += 2;
				this.agilite += 1;
				this.intelligence += 5;
				this.PVMax *= 1.06;
				break;
				
			case Voleur:
				
				this.force += 2;
				this.agilite += 3;
				this.intelligence += 2;
				this.PVMax *= 1.08;
				break;
				
			case Monstre:
				
				this.force += getRandomInt(0, 4);
				this.agilite += getRandomInt(0, 4);
				this.intelligence += getRandomInt(0, 4);
				this.PVMax *= 1f + getRandomInt(6, 10)/100f;
				break;
	
		}
		
		lvl++;
		xp = 0;
		
		affiche("Vous passez au niveau " + lvl);
		
	}
	
	public void setLevel(int lvl) {
		
		while(this.lvl < lvl) {
			
			levelUp();
			
		}
		
	}
	
	//à améliorer pour tenir compte de l'armure et du type d'attaque
	public void degats(int nbDegats, boolean isPhysique) {
		
		PV -= nbDegats;
		affiche(nbDegats + " points de degats");
		
	}
	
	public boolean isAlive() {
		
		return this.getPV() > 0;
		
	}
	
	public void addPV(int nbPV) {
		
		PV += nbPV;
		
		if (PV > PVMax) {
			
			PV = PVMax;
			
		}
		
	}
	
	public void afficheArgent() {
		
		String message = argent > 1 ? " pièce d'or" : " pièces d'or";
		
		affiche("vous possédez " + argent + message);
		
	}
	
	public void achat(Item i) {
		// TODO Auto-generated method stub
		
		int valeur = i.getValeur();
		
		if(valeur < argent) {
			
			items.add(i);
			argent -= valeur;
			
		}
		
		else {
			
			affiche("Achat impossible, vous n'avez pas assez de PO");
			
		}
		
	}
	
	public String toString() {
		
		String description = "caractéristiques du personnage : \n";
		description += "force : " + this.getForce() + "\n";
		description += "agilité : " + this.getAgilite() + "\n";
		description += "intelligence : " + this.getIntelligence() + "\n";
		description += "PV : " + this.getPV() + "\n";
		description += "PV maximum : " + this.getPVMax() + "\n";
		description += "lvl : " + this.getLvl() + "\n";
		
		return description;
		
	}
	
}
