package es.unican.is2.gestionTienda;


public class VendedorEnPlantilla extends Vendedor { //WMC=3 WMCn=3/3=1 //CCog=0
	
	private TipoVendedor tipo;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String id, String dni, TipoVendedor tipo) { //WMC+1
		super(nombre, id, dni);
		this.tipo = tipo;
	}
	
	public TipoVendedor tipo() { //WMC+1
		return tipo;
	}
	
	public double importeFinal(double importe) { //WMC+1
		return importe;
	}
}
