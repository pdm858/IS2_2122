package es.unican.is2.ImpuestoCirculacionCommon;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Furgoneta
    extends Vehiculo implements Serializable
{
    
    private double potencia;
    private boolean comercial;
    
   public Furgoneta(String matricula, LocalDate fechaMat, double potencia, boolean comercial) {
		super(matricula, fechaMat);
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
		return  (potencia < 8) ? 25.24 :
                ((8  <= potencia && potencia < 11.99) ? 68.16  :
                ((12 <= potencia && potencia < 15.99) ? 143.88 :
                ((16 <= potencia && potencia < 19.99) ? 179.22 : 224)));
    }
}
