package es.unican.is2.gestion_tienda;


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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getDni() == null) ? 0 : getDni().hashCode());
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getNombre() == null) ? 0 : getNombre().hashCode());
		return result;
	}
	
}
