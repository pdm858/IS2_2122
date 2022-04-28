package es.unican.is2.ImpuestoCirculacionCommon;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Turismo
    extends Vehiculo implements Serializable
{

	private double potencia;
	
	public Turismo(String matricula, LocalDate fechaMatriculacion,
			double potencia) throws OperacionNoValida {
		super(matricula, fechaMatriculacion);
		
		if (matricula == null)
			throw new OperacionNoValida("Debe indicar un valor para la"
					+ "matricula");
		if (fechaMatriculacion == null)
			throw new OperacionNoValida("Debe indicar un valor para la fecha");
		if (fechaMatriculacion.isAfter(LocalDate.now()))
			throw new OperacionNoValida("No puede matricular un "
					+ "vehiculo con una fecha posterior a hoy");
		if (potencia <= 0)
			throw new OperacionNoValida("No puede registrar un vehiculo con"
					+ " potencia inferior o igual a 0 CV");
		
		this.potencia = potencia;
	}


	/**
	 * Retorna la potencia del turismo
	 * @return potencia en caballos fiscales
	 */
    public double getPotencia() {
        return potencia;
    }
       
    
    /**
     * Retorna el precio del impuesto a pagar
     *  @return precio
     */
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
		return precio;
    }

}
