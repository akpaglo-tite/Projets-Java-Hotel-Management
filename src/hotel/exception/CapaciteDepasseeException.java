package hotel.exception;

import hotel.model.TypeChambre;

public class CapaciteDepasseeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TypeChambre typeChambre;
	public int capacite;
	
	public CapaciteDepasseeException(TypeChambre typeChambre, int capacite) {
		super("La capacite "+capacite+" dépasse celle prévue cette chambre de type : "+typeChambre);
		this.capacite = capacite;
		this.typeChambre = typeChambre;
	}
	

}
