package es.unican.is2.ImpuestoCirculacionCommon;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Furgoneta
    extends Vehiculo implements Serializable
{
	private static final double BONIFICACION = 0.2;
    
    private double potencia;
    private boolean comercial;
    
   public Furgoneta(String matricula, LocalDate fechaMatriculacion,
		   double potencia, boolean comercial) throws OperacionNoValida {
		super(matricula, fechaMatriculacion);
		
		if (matricula == null)
			throw new OperacionNoValida("Debe indicar un valor para la"
					+ " matricula");
		if (fechaMatriculacion == null)
			throw new OperacionNoValida("Debe indicar un valor para la fecha");
		if (fechaMatriculacion.isAfter(LocalDate.now()))
			throw new OperacionNoValida("No puede matricular un "
					+ "vehiculo con una fecha posterior a hoy");
		if (potencia <= 0)
			throw new OperacionNoValida("No puede registrar un vehiculo con"
					+ " potencia inferior o igual a 0 CV");

		this.potencia = potencia;
		this.comercial = comercial;
	}

/**
    * Retorna el valor del atributo comercial
    * @return true si la furgoneta es de uso comercial
    *         false si no es de uso comercial
    */
    public boolean getComercial() {
    	return comercial;
    }
    
    /**
	 * Retorna la potencia de la furgoneta
	 * @return potencia en caballos fiscales
	 */
    public double getPotencia() {
        return potencia;
    }
    
  
	@Override
    public double precioImpuesto() {
		double precio;
		if (getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25)))
			precio = 0;
		else
			precio = (potencia < 8) ? 25.24 :
                ((8  <= potencia && potencia < 12) ? 68.16  :
                ((12 <= potencia && potencia < 16) ? 143.88 :
                ((16 <= potencia && potencia < 20) ? 179.22 : 224)));
		if (comercial) precio = (1 - BONIFICACION) * precio;
		return precio;
    }
}
