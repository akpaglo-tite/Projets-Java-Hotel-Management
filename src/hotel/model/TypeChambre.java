package hotel.model;

public enum TypeChambre {
	SIMPLE(1,50.0),
	DOUBLE(2,80.0),
	SUITE(4,150);
	
	//Constructeur de l'énum 
	private final int capaciteMax;
	private final double prixParNuit;
	private TypeChambre(int cpaciteMax, double prixParNuit) {
		this.capaciteMax = cpaciteMax;
		this.prixParNuit = prixParNuit;
	}
	
	//Getters pour récupérer les sous-propriétés
	public int getCapaciteMax() {
		return capaciteMax;
	}
	
	public double getPrixParNuit() {
		return prixParNuit;
	}
}
