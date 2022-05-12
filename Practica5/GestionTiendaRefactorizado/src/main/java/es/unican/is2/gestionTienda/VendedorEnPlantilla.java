package es.unican.is2.gestionTienda;


public class VendedorEnPlantilla extends Vendedor { //WMC=5 WMCn=5/3=1.67 //CCog=2
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String id, String dni) { //WMC+1
		super(nombre, id, dni);
	}
	
	public double importeFinal(double importe) { //WMC+1
		return importe;
	}
	
	@Override
	public boolean equals(Object obj) { //WMC+1
		if (!(obj instanceof VendedorEnPlantilla)) //WMC+1 //CCog+1
			return false;
		VendedorEnPlantilla v = (VendedorEnPlantilla) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni())); //WMC+1 //CCog+1
	}
	
}
