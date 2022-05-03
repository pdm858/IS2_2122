package es.unican.is2.gestionTienda;


public class vendedorEnPracticas extends Vendedor {
	
	/**
	 * Retorna un nuevo vendedor en prácticas
	 * @param nombre
	 * @param dni
	 */
	public vendedorEnPracticas(String nombre, String id, String dni) {
		super(nombre, id, dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof vendedorEnPracticas)) 
			return false;
		vendedorEnPracticas v = (vendedorEnPracticas) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
