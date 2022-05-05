package es.unican.is2.gestionTienda;


public class VendedorEnPracticas extends Vendedor { //WMC=1 WMCn=1/1=1 //CCog=0
	
	/**
	 * Retorna un nuevo vendedor en prácticas
	 * @param nombre
	 * @param dni
	 */
	public VendedorEnPracticas(String nombre, String id, String dni) { //WMC+1
		super(nombre, id, dni);
	}

}
