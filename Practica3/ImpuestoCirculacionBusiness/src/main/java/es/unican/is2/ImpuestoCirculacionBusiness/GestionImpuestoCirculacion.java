package es.unican.is2.ImpuestoCirculacionBusiness;

import es.unican.is2.ImpuestoCirculacionCommon.Contribuyente;
import es.unican.is2.ImpuestoCirculacionCommon.IContribuyentesDAO;
import es.unican.is2.ImpuestoCirculacionCommon.IGestionContribuyentes;
import es.unican.is2.ImpuestoCirculacionCommon.IGestionVehiculos;
import es.unican.is2.ImpuestoCirculacionCommon.IInfoImpuestoCirculacion;
import es.unican.is2.ImpuestoCirculacionCommon.IVehiculosDAO;
import es.unican.is2.ImpuestoCirculacionCommon.OperacionNoValida;
import es.unican.is2.ImpuestoCirculacionCommon.Vehiculo;

/**
 * Clase que implementa la capa de negocio de la aplicacion
 */
public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, IInfoImpuestoCirculacion {
	
	private IContribuyentesDAO contribuyentes;
	private IVehiculosDAO vehiculos;
	
	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentes, IVehiculosDAO vehiculos) {
		this.contribuyentes = contribuyentes;
		this.vehiculos = vehiculos;
	}
	
	public Contribuyente altaContribuyente(Contribuyente c) {
		return (contribuyentes.creaContribuyente(c) == null) ? null : c;
	}
	
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValida {
		Contribuyente c = contribuyentes.eliminaContribuyente(dni);
		if (c != null && !c.getVehiculos().isEmpty())
			throw new OperacionNoValida("El contribuyente tiene vehiculos a su nombre");
		return c;		
	 }
	
	public Contribuyente contribuyente(String dni) {
		return contribuyentes.contribuyente(dni);
	}

	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida {
		Contribuyente c = contribuyentes.contribuyente(dni);
		if (c == null) return null;
		c.getVehiculos().add(v);
		if (vehiculos.creaVehiculo(v) == null)
			throw new OperacionNoValida("El vehiculo ya existe");
		return v;
	}

	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida {
		Contribuyente c = contribuyentes.contribuyente(dni);
		Vehiculo v = vehiculos.vehiculo(matricula);
		if (!c.getVehiculos().contains(v))
			throw new OperacionNoValida("El vehiculo no pertenece al contribuyente");
		c.getVehiculos().remove(v);
		vehiculos.eliminaVehiculo(matricula);
		return (c == null || v == null) ? null : v;
	}
	
	public Vehiculo vehiculo(String matricula) {
		return vehiculos.vehiculo(matricula);
	}	
}

