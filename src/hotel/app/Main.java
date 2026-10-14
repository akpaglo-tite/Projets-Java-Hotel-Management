package hotel.app;

import java.util.Scanner;

import hotel.exception.CapaciteDepasseeException;
import hotel.exception.ChambreNonDisponibleException;
import hotel.model.Chambre;
import hotel.model.Reservation;
import hotel.model.TypeChambre;
import hotel.service.GestionnaireHotel;

public class Main {

	public static void main(String[] args) throws CapaciteDepasseeException,ChambreNonDisponibleException{
		GestionnaireHotel gestionnaireHotel = new GestionnaireHotel();
		String choix = "1";
		String type;
		int nombrePersonnes;
		int nombreNuits;
		//int numChambre;
		Scanner scanner = new Scanner(System.in);
		while (!choix.equals("6")) {
			//Reservation reservation = new Reservation(null, null, null, 0);
			//Chambre chambre = new Chambre(0, null);
			
			System.out.print("1. Réserver une chambre\n"
					+ "2. Libérer une chambre\n"
					+ "3. Afficher l'état des chambres (Occupées / Libres)\n"
					+ "4. Afficher l'historique des réservation\n"
					+ "5. Afficher le chiffre d'affaires total\n"
					+ "6. Quitter\n");
			System.out.print("Entrer votre choix : ");
			choix = scanner.nextLine();
			switch (choix) {
			case "1": {
				
				try {
					Reservation reservation = new Reservation(null, null, null, 0);
					Chambre chambre = new Chambre(0, null);

					System.out.print("Entrer l'identifiant de la réservation : ");
					reservation.setIdReservation(scanner.nextLine());
					
					System.out.print("Entrer le nom du client : ");
					reservation.setNomClient(scanner.nextLine());
					
					System.out.print("Entrer le type de chambre cherché (SIMPLE, DOUBLE, SUITE) : ");
					type = scanner.nextLine();
					
					TypeChambre typeChambre = TypeChambre.valueOf(type.toUpperCase());
					chambre.setType(typeChambre);
					reservation.setChambre(chambre);
					
					System.out.print("Entrer le nombre de personnes pour la chambre cherchée : ");
					nombrePersonnes = scanner.nextInt();
					scanner.nextLine();
					
					System.out.print("Entrer le nombre de nuits à faire : ");
					nombreNuits = scanner.nextInt();
					scanner.nextLine();
					
					gestionnaireHotel.reserverChambre(nombrePersonnes, reservation.getIdReservation(), reservation.getNomClient(), reservation.getChambre(), nombreNuits);
					
				} catch (ChambreNonDisponibleException e) {
					System.out.print("Erreur : "+e.getMessage());
				}catch (CapaciteDepasseeException e) {
					System.out.print("Erreur : "+e.getMessage());
				}catch (IllegalArgumentException e) {
					System.out.print("Valeur inconnue!");
				}
			break;	
			}
			case"2": {
				try {
					System.out.print("Entrer le numéro de la chambre à libérer : ");
					int numChambre = scanner.nextInt();
					scanner.nextLine();
					gestionnaireHotel.libererChambre(numChambre);
				} catch (IllegalArgumentException e) {
					System.out.println("Erreur : Numéro entré n'existe pas.");
				}
				break;
			}
			case"3": {
				gestionnaireHotel.afficherEtatChambres();
				break;
			}
			case"4": {
				gestionnaireHotel.afficherHistoriqueReservations();
				break;
			}
			case"5": {
				System.out.println("Selon les réservations effectuées, voici le chiffre d'affaire : "+gestionnaireHotel.calculerChiffreAffairesTotal()+"€");
				break;
			}
			default:
				System.out.println("vous venez de terminer toutes les opérations voulues! Au revoir");
			}
		}
		scanner.close();
	}

}