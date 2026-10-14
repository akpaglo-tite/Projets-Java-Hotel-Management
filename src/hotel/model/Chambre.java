package hotel.model;

public class Chambre {

	private int numero;
	private TypeChambre type;
	private boolean occupee;
	
	//Constructeur de la classe Chambre
	public Chambre(final int numero, final TypeChambre type) {
		this.numero = numero;
		this.type = type;
		this.occupee = false;
	}
	
	//Les getters pour la récupération des valeurs
	public int getNumero() {
		return numero;
	}
	public TypeChambre getType() {
		return type;
	}
	public boolean getOccupee() {
		return occupee;
	}
	

	//Les setters pour les modifications
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setType(TypeChambre type) {
		this.type = type;
	}
	public void setOccupee(boolean occupee) {
		this.occupee = occupee;
	}
	
	//Affichage des informations des chambres 
	public void afficherInformationChambres() {
		System.out.print("Numéro de chambre : "+this.numero
				+"\nType de chambre : "+this.type
				+"\nEtat : "+this.occupee+"\n");
		
	}
}
