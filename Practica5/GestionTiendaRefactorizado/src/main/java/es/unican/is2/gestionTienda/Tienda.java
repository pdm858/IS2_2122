package es.unican.is2.gestionTienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores.
 * Gestiona las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como parámetro al crear la tienda
 */
public class Tienda { //WMC=33 WMCn=33/13=2.54 //CCog=26

	private LinkedList<Vendedor> lista = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;

	private String datos;

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) { //WMC+1
		this.datos = datos;
        leeFich();
	}

	/**
	 * Retorna la dirección de la tienda
	 * @return Dirección de la tienda
	 */
	public String direccion() { //WMC+1
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() { //WMC+1
		return nombre;
	}

	/**
	 * Añade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya había un vendedor con el mismo id
	 */
	public boolean anhadeVendedor(Vendedor nuevoVendedor) throws IOException { //WMC+1
		Vendedor elVendedor = buscaVendedor(nuevoVendedor.getId());
		if (elVendedor != null) //WMC+1 //CCog+1
			return false;
		lista.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo dni se pasa como parámetro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ningún vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException { //WMC+1
		Vendedor elVendedor = buscaVendedor(id);
		if (elVendedor == null) //WMC+1 //CCog+1
			return false;
		lista.remove(elVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Añade una venta a un vendedor
	 * @param id Id del vendedor
	 * @param importe Importe de la venta
	 * @return true si se añade la venta 
	 *         false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws IOException { //WMC+1
		Vendedor elVendedor = buscaVendedor(id);
		if (elVendedor == null) { //WMC+1 //CCog+1
			return false;
		}
		
		if (elVendedor instanceof VendedorEnPlantilla) { //WMC+1 //CCog+1
			importe = ((VendedorEnPlantilla) elVendedor).importeFinal(importe);
		}
		
		elVendedor.anhade(importe);
		vuelcaDatos();
		return true;
	}

	private void leeSeccion(Scanner in, String tipoVendedor,
			String siguienteTipoVendedor, LinkedList<Vendedor> lista) { //WMC+1
		Vendedor ven = null;
		while (in.hasNext() && !in.next().equals(siguienteTipoVendedor)) { //WMC+1+1	//CCog+1+1
			String nombre = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni= in.next();
			in.next();
			double totalVentas = in.nextDouble();
			if (tipoVendedor.equals("Senior")) { //WMC+1 //CCog+2
				ven = new VendedorEnPlantillaSenior(nombre, idIn, dni);
			} else if (tipoVendedor.equals("Junior")) { //WMC+1 //CCog+1
				ven = new VendedorEnPlantillaJunior(nombre, idIn, dni);
			} else { //CCog+1
				ven = new VendedorEnPracticas(nombre, idIn, dni);
			}
			ven.setT(totalVentas);
			lista.add(ven);
		}
	}

    private void leeFich() { //WMC+1
		Scanner in = null;
		lista.clear();
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			// lee los vendedores senior
			leeSeccion(in, "Senior", "Junior", lista);
			// lee los vendedores junior
			leeSeccion(in, "Junior", "Pr�cticas", lista);
			// lee los vendedores en practicas
			leeSeccion(in, "", "", lista);
		} catch (FileNotFoundException e) { //CCog+1
			System.out.println("No se pudo leer el fichero");
		} finally {
			if (in != null) { //WMC+1 //CCog+1
				in.close();
			}
		}
    }

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) { //WMC+1
		leeFich();
		for (Vendedor v : lista) { //WMC+1 //CCog+1
			if (v.getId().equals(id)) { //WMC+1	//CCog+2
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() { //WMC+1
		leeFich();
		return lista;
	}

	/**
	 * Método que actualiza el fichero datosTienda.txt 
	 * con los datos actualizados de los vendedores
	 */
	private void vuelcaDatos() throws IOException { //WMC+1
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		for (Vendedor v : lista) { //WMC+1 //CCog+1
			if (v instanceof VendedorEnPracticas) {	//WMC+1	CCog+2
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantillaJunior) {	//WMC+1	CCog+1
				junior.add(v);
			} else if (v instanceof VendedorEnPlantillaSenior) {	//WMC+1	CCog+1
				senior.add(v);
			}
		}

		try {
			out = new PrintWriter(new FileWriter(datos));
			out.println(nombre);
			out.println(direccion);

			out.println();
			out.println("Senior");	
			imprimeDatosVendedores(senior, out);

			out.println();
			out.println("Junior");
			imprimeDatosVendedores(junior, out);

			out.println();
			out.println("Pr�cticas");	
			imprimeDatosVendedores(practicas, out);
		} finally {
			if (out != null) //WMC+1 //CCog+1
				out.close();
		}
	}
	
	private void imprimeDatosVendedores(List<Vendedor> vendedores, PrintWriter out) { //WMC+1
		for (Vendedor v: vendedores) { //WMC+1 //CCog+1
			v.imprimeDatos(out);
		}
	}

	public void ventasMaximas(List<Vendedor> resultado) { //WMC+1
		double maxVentas = 0.0;
		for (Vendedor v : lista) { //WMC+1 //CCog+1
			if (v.getTotalVentas() > maxVentas) { //WMC+1 //CCog+2
				maxVentas = v.getTotalVentas();
				resultado.clear();
				resultado.add(v);
			} else if (v.getTotalVentas() == maxVentas) { //WMC+1 //CCog+1
				resultado.add(v);
			}
		}
	}

}
