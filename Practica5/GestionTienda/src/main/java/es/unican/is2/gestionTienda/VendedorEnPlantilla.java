package es.unican.is2.gestionTienda;


<<<<<<< HEAD
public class VendedorEnPlantilla extends Vendedor { //WMC=6 WMCn=6/4=1.5 //CCog=2
=======
public class VendedorEnPlantilla extends Vendedor {
>>>>>>> origin
	
	private TipoVendedor tipo;
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
<<<<<<< HEAD
	public VendedorEnPlantilla(String nombre, String id, String dni, TipoVendedor tipo) { //WMC+1
=======
	public VendedorEnPlantilla(String nombre, String id, String dni, TipoVendedor tipo) {
>>>>>>> origin
		super(nombre, id);
		this.tipo = tipo;
		this.dni=dni;
	}
	
<<<<<<< HEAD
	public TipoVendedor tipo() { //WMC+1
		return tipo;
	}
	
	public String getDni() { //WMC+1
=======
	public TipoVendedor tipo() {
		return tipo;
	}
	
	public String getDni() {
>>>>>>> origin
		return dni;
	}
	
	@Override
<<<<<<< HEAD
	public boolean equals(Object obj) { //WMC+1
		if (!(obj instanceof VendedorEnPlantilla)) //WMC+1 //CCog+1
			return false;
		VendedorEnPlantilla v = (VendedorEnPlantilla) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni())); //WMC+1 //CCog+1
=======
	public boolean equals(Object obj) {
		if (!(obj instanceof VendedorEnPlantilla)) 
			return false;
		VendedorEnPlantilla v = (VendedorEnPlantilla) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
>>>>>>> origin
	}
}
