package es.unican.is2.gestionTienda;

public class VendedorEnPlantillaJunior extends VendedorEnPlantilla { //WMC=5 WMCn=5/3=1.67 //CCog=2

	private static final double COMISION = 0.005;
	
	public VendedorEnPlantillaJunior(String nombre, String id, String dni) { //WMC+1
		super(nombre, id, dni);
	}

	@Override
	public double importeFinal (double importe) { //WMC+1
		importe += importe * COMISION;
		return importe;
	}
	
	@Override
	public boolean equals(Object obj) { //WMC+1
		if (!(obj instanceof VendedorEnPlantillaJunior)) //WMC+1 //CCog+1
			return false;
		VendedorEnPlantillaJunior v = (VendedorEnPlantillaJunior) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni())); //WMC+1 //CCog+1
	}
	
}
