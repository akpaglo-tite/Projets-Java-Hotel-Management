package hotel.exception;

import hotel.model.TypeChambre;

public class ChambreNonDisponibleException extends Exception {

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TypeChambre typeChambre;
	public boolean occupee;
	
	public ChambreNonDisponibleException(TypeChambre typeChambre, boolean occupee) {
		super("Le type de chambre : "+typeChambre +"\n Occupée : "+occupee);
		this.typeChambre = typeChambre;
		this.occupee = occupee;
	}

}
