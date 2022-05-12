package es.unican.is2.gestionTienda;


public class VendedorEnPracticas extends Vendedor { //WMC=4 WMCn=4/2=2 //CCog=2
	
	/**
	 * Retorna un nuevo vendedor en pr�cticas
	 * @param nombre
	 * @param dni
	 */
	public VendedorEnPracticas(String nombre, String id, String dni) { //WMC+1
		super(nombre, id, dni);
	}
	
	@Override
	public boolean equals(Object obj) { //WMC+1
		if (!(obj instanceof VendedorEnPracticas)) //WMC+1 //CCog+1
			return false;
		VendedorEnPracticas v = (VendedorEnPracticas) obj;
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
