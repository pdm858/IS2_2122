package es.unican.is2.gestionTienda;


/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */
<<<<<<< HEAD
public abstract class Vendedor { //WMC=6 WMCn=6/6=1 //CCog=0
=======
public abstract class Vendedor {
>>>>>>> origin
	
	private String id;
	private String nombre;
	
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double t;
	
<<<<<<< HEAD
	public Vendedor(String nombre, String id) { //WMC+1
=======
	public Vendedor(String nombre, String id) {
>>>>>>> origin
		this.nombre = nombre;
		this.id = id;
	}
	

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
<<<<<<< HEAD
	public String getNombre() { //WMC+1
=======
	public String getNombre() {
>>>>>>> origin
		return nombre;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
<<<<<<< HEAD
	public String getId() { //WMC+1
=======
	public String getId() {
>>>>>>> origin
		return id;
	}
	
	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
<<<<<<< HEAD
	public double getTotalVentas() { //WMC+1
=======
	public double getTotalVentas() {
>>>>>>> origin
		return t;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
<<<<<<< HEAD
	public void setT(double totalVentas) { //WMC+1
=======
	public void setT(double totalVentas) {
>>>>>>> origin
		this.t = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
<<<<<<< HEAD
	public void anhade(double importe){ //WMC+1
=======
	public void anhade(double importe){
>>>>>>> origin
		t += importe;
	}
	
}
