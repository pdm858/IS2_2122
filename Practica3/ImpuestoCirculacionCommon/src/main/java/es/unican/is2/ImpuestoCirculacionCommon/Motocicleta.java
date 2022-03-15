@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private int cilindrada;

    /**
     * Retorna la cilindrada de la motocicleta
     * @return cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }
    
  
	@Override
    public double precioImpuesto() {
		return  (cilindrada < 125) ? 8.84 :
                ((125 <= cilindrada && cilindrada < 250)  ? 15.14  :
                ((250 <= cilindrada && cilindrada < 500)  ? 30.3   :
                ((500 <= cilindrada && cilindrada < 1000) ? 60.58  : 121.16)));
    }
}
