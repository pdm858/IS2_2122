package es.unican.is2.gestionTienda;

public class VendedorEnPlantillaSenior extends VendedorEnPlantilla {

	private static final double COMISION = 0.01;
	
	public VendedorEnPlantillaSenior(String nombre, String id, String dni, TipoVendedor tipo) {
		super(nombre, id, dni, tipo);
	}
	
	@Override
	public double importeFinal (double importe) {
		importe += importe * COMISION;
		return importe;
	}

}
