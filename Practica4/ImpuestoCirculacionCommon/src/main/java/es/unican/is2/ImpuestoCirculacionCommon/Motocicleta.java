package es.unican.is2.ImpuestoCirculacionCommon;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private double cilindrada;

	public Motocicleta(String matricula, LocalDate fechaMatriculacion,
			double cilindrada) throws OperacionNoValida {
		super(matricula, fechaMatriculacion);
		
		if (matricula == null)
			throw new OperacionNoValida("Debe indicar un valor para la "
					+ "matricula");
		if (fechaMatriculacion == null)
			throw new OperacionNoValida("Debe indicar un valor para la fecha");
		if (fechaMatriculacion.isAfter(LocalDate.now()))
			throw new OperacionNoValida("No puede matricular un "
					+ "vehiculo con una fecha posterior a hoy");
		if (cilindrada <= 0)
			throw new OperacionNoValida("No puede registrar una motocicleta con"
					+ " cilindrada inferior o igual a 0 cc");

		this.cilindrada = cilindrada;
	}


	/**
     * Retorna la cilindrada de la motocicleta
     * @return cilindrada
     */
    public double getCilindrada() {
        return cilindrada;
    }
    
  
	@Override
    public double precioImpuesto() {
		double precio;
		if (getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25)))
			precio = 0;
		else
			precio = (cilindrada < 125) ? 8.84 :
				((125 <= cilindrada && cilindrada < 250)  ? 15.14  :
                ((250 <= cilindrada && cilindrada < 500)  ? 30.3   :
                ((500 <= cilindrada && cilindrada < 1000) ? 60.58  : 121.16)));
		return precio;
    }
}
