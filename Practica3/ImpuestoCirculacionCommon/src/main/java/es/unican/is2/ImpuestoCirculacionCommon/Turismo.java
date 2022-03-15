import java.io.Serializable;

@SuppressWarnings("serial")
public class Turismo
    extends Vehiculo implements Serializable
{

	private double potencia;
	
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
    	return  (potencia < 8) ? 25.24 :
                ((8  <= potencia && potencia < 11.99) ? 68.16  :
                ((12 <= potencia && potencia < 15.99) ? 143.88 :
                ((16 <= potencia && potencia < 19.99) ? 179.22 : 224)));
    }
    
}
