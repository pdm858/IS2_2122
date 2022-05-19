package es.unican.is2.gestion_tienda;

import java.io.PrintWriter;

/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */
public abstract class Vendedor { //WMC=8 WMCn=8/8=1 //CCog=0
	
	private String id;
	private String nombre;
	private String dni;
	
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double t;
	
	protected Vendedor(String nombre, String id, String dni) { //WMC+1
		this.nombre = nombre;
		this.id = id;
		this.dni = dni;
	}
	

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() { //WMC+1
		return nombre;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getId() { //WMC+1
		return id;
	}
	
	
	public String getDni() { //WMC+1
		return dni;
	}
	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() { //WMC+1
		return t;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void setT(double totalVentas) { //WMC+1
		this.t = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	public void anhade(double importe){ //WMC+1
		t += importe;
	}
	
	public void imprimeDatos(PrintWriter out) { //WMC+1
		out.println("  Nombre: " + getNombre() + " Id: " + getId() + " DNI: "+ getDni()+" TotalVentasMes: "
				+ getTotalVentas());
	}
	
}
