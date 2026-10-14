package hotel.model;

public class Reservation {
	
	private String idReservation;
	private String nomClient;
	private Chambre chambre;
	private int nombreNuits;
	
	//L'initialisation dans le constructeur
	public Reservation(final String idReservation, final String nomClient, final Chambre chambre, final int nombreNuits) {
		this.idReservation = idReservation;
		this.nomClient = nomClient;
		this.chambre = chambre;
		this.nombreNuits = nombreNuits;
	}

	//Les getters pour la récupération des valeurs
	public Chambre getChambre() {
		return chambre;
	}
	public String getIdReservation() {
		return idReservation;
	}
	public int getNombreNuits() {
		return nombreNuits;
	}
	public String getNomClient() {
		return nomClient;
	}
	
	
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	public void setIdReservation(String idReservation) {
		this.idReservation = idReservation;
	}
	public void setNombreNuits(int nombreNuits) {
		this.nombreNuits = nombreNuits;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	
	
	//Affichage des informations de la classe reservation
	public void afficherDetails() {
		System.out.println("Identifiant de réservation : "+this.idReservation
				+"\nNom du client : "+this.nomClient
				+"\nNombre de nuits : "+this.nombreNuits+"\n");
		if (chambre == null) {
			System.out.print("Pas de chambre!");
		}
		this.chambre.afficherInformationChambres();

	}
	public double calculerMontant() {
		if (!(chambre == null ) && !(chambre.getType() == null)) {
			return nombreNuits * chambre.getType().getPrixParNuit();
		}
		return -1.0;
	}
}