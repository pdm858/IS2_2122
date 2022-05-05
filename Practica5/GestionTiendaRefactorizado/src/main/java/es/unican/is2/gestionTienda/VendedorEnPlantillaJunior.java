package es.unican.is2.gestionTienda;

public class VendedorEnPlantillaJunior extends VendedorEnPlantilla { //WMC=2 WMCn=2/2=1 //CCog=0

	private static final double COMISION = 0.005;
	
	public VendedorEnPlantillaJunior(String nombre, String id, String dni, TipoVendedor tipo) { //WMC+1
		super(nombre, id, dni, tipo);
	}

	@Override
	public double importeFinal (double importe) { //WMC+1
		importe += importe * COMISION;
		return importe;
	}
}
