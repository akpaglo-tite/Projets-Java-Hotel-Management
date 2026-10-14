package hotel.service;

import hotel.model.Reservation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hotel.exception.CapaciteDepasseeException;
import hotel.exception.ChambreNonDisponibleException;
import hotel.model.Chambre;
import hotel.model.TypeChambre;

public class GestionnaireHotel {

	Map<Integer,Chambre> chambres;
	List<Reservation> reservations;
	
	//Le constructeur
	public GestionnaireHotel() {
		chambres = new HashMap<Integer, Chambre>();
		reservations = new ArrayList<Reservation>();
		afficherDonneesParDefaut();
	}
	
	private void afficherDonneesParDefaut() {
		// 5 Chambres Simples (101 à 105)
	    this.chambres.put(101, new Chambre(101, TypeChambre.SIMPLE));
	    this.chambres.put(102, new Chambre(102, TypeChambre.SIMPLE));
	    this.chambres.put(103, new Chambre(103, TypeChambre.SIMPLE));
	    this.chambres.put(104, new Chambre(104, TypeChambre.SIMPLE));
	    this.chambres.put(105, new Chambre(105, TypeChambre.SIMPLE));

	    // 3 Chambres Doubles (201 à 203)
	    this.chambres.put(201, new Chambre(201, TypeChambre.DOUBLE));
	    this.chambres.put(202, new Chambre(202, TypeChambre.DOUBLE));
	    this.chambres.put(203, new Chambre(203, TypeChambre.DOUBLE));

	    // 2 Suites (301 et 302)
	    this.chambres.put(301, new Chambre(301, TypeChambre.SUITE));
	    this.chambres.put(302, new Chambre(302, TypeChambre.SUITE));
	}
	
	//Vériification du nombre de places de chaque type de chambre 
	public void reserverChambre(int capacite, String idReservation, String nomClient, Chambre chambre,int nombreNuits) throws CapaciteDepasseeException,ChambreNonDisponibleException{
		var type = chambre.getType();
		int nombrePersonneParChambre = type.getCapaciteMax();
		List<Chambre> valeursChambres = new ArrayList<Chambre>(this.chambres.values());	
		if(capacite > nombrePersonneParChambre) {
			throw new CapaciteDepasseeException(type, capacite);
		}
		Chambre chambreTrouvee = null;
		for(Chambre chambreDisponible : valeursChambres) {
			if(!chambreDisponible.getOccupee() && type == chambreDisponible.getType()) {
				chambreTrouvee = chambreDisponible;
				break;
			}
		}
		
		if(chambreTrouvee == null) {
			throw new ChambreNonDisponibleException(type, chambre.getOccupee());
		}
		
		chambreTrouvee.setOccupee(true);
		Reservation nouvelleReservation = new Reservation(idReservation, nomClient, chambreTrouvee, nombreNuits);
		
		//L'ajout de la nouvelle réservation 
		reservations.add(nouvelleReservation);
	}

	//Libération d'une chambre 
	public void libererChambre(int numChambre) {
		Chambre chambreLiberee = chambres.get(numChambre);
		if (chambreLiberee == null) {
			System.out.println("Erreur : La chambre "+numChambre+" n'existe pas");
			return;
		} else if (!chambreLiberee.getOccupee()) {
			System.out.println("La chambre numéro "+numChambre+" est déjà libre!");
			return;
		} 
		
		chambreLiberee.setOccupee(false);
		System.out.println("La chambre a été libérée avec succès ");
	}
	
	//Calcul du chiffre d'affaires réalisé
	public double calculerChiffreAffairesTotal() {
		double chiffreAffaire = 0.0;
		for (Reservation reservation : reservations) {
			
			chiffreAffaire += reservation.calculerMontant();
		}
		return chiffreAffaire;
	}
	
	//Affichage de l'état des chambres 
	public void afficherEtatChambres() {
		List<Chambre> etatChambre = new ArrayList<Chambre>(this.chambres.values());
		
		for(Chambre chambre : etatChambre) {
			if (chambre == null) {
				System.out.println("Chambre inexistante");
				return;
			}
			System.out.println("Chambre N° : "+ chambre.getNumero()+" -- Etat : "+(chambre.getOccupee()? "Occupee":"Libre"));
		}
	}
	
	//Historique des réservations 
	public void afficherHistoriqueReservations() {
		if (reservations.size() == 0) {
			System.out.println("Aucune réservation n'est faite pour le moment!");
			return;
		}
		for (Reservation reservation : reservations) {
			reservation.afficherDetails();
		}
	}
}