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
<<<<<<< HEAD
public class Tienda { //WMC=37 WMCn=37/9=4.1 //CCog=35
=======
public class Tienda {
>>>>>>> origin

	private LinkedList<Vendedor> lista = new LinkedList<Vendedor>();
	private String direccion;
	private String nombre;

	private String datos;

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
<<<<<<< HEAD
	public Tienda(String datos) { //WMC+1
=======
	public Tienda(String datos) {
>>>>>>> origin
		this.datos = datos;
	}

	/**
	 * Retorna la dirección de la tienda
	 * @return Dirección de la tienda
	 */
<<<<<<< HEAD
	public String direccion() { //WMC+1
=======
	public String direccion() {
>>>>>>> origin
		return direccion;
	}

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
<<<<<<< HEAD
	public String nombre() { //WMC+1
=======
	public String nombre() {
>>>>>>> origin
		return nombre;
	}

	/**
	 * Añade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya había un vendedor con el mismo id
	 */
<<<<<<< HEAD
	public boolean anhade(Vendedor nuevoVendedor) throws IOException { //WMC+1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) { //WMC+1 //CCog+1
=======
	public boolean anhade(Vendedor nuevoVendedor) throws IOException {
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) {
>>>>>>> origin
			return false;
		}
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
<<<<<<< HEAD
	public boolean eliminaVendedor(String id) throws IOException { //WMC+1
		Vendedor v = buscaVendedor(id);
		if (v == null) { //WMC+1 //CCog+1
=======
	public boolean eliminaVendedor(String id) throws IOException {
		Vendedor v = buscaVendedor(id);
		if (v == null) {
>>>>>>> origin
			return false;
		}
		lista.remove(v);
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
<<<<<<< HEAD
	public boolean anhadeVenta(String id, double importe) throws IOException { //WMC+1
		Vendedor v = buscaVendedor(id);
		if (v == null) { //WMC+1 //CCog+1
			return false;
		}
		double importeFinal = importe;
		if (v instanceof VendedorEnPlantilla) { //WMC+1 //CCog+1
			switch (((VendedorEnPlantilla) v).tipo()) { //CCog+2
			case JUNIOR: //WMC+1
				importeFinal += importeFinal * 0.005;
				break;
			case SENIOR: //WMC+1
=======
	public boolean anhadeVenta(String id, double importe) throws IOException {
		Vendedor v = buscaVendedor(id);
		if (v == null) {
			return false;
		}
		double importeFinal = importe;
		if (v instanceof VendedorEnPlantilla) {
			switch (((VendedorEnPlantilla) v).tipo()) {
			case JUNIOR:
				importeFinal += importeFinal * 0.005;
				break;
			case SENIOR:
>>>>>>> origin
				importeFinal += importeFinal * 0.01;
				break;
			}
		}
		v.anhade(importeFinal);
		vuelcaDatos();
		return true;
	}

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
<<<<<<< HEAD
	public Vendedor buscaVendedor(String id) { //WMC+1
=======
	public Vendedor buscaVendedor(String id) {
>>>>>>> origin

		lista = new LinkedList<Vendedor>();
		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			Vendedor ven = null;
			// lee los vendedores senior
<<<<<<< HEAD
			while (in.hasNext() && !in.next().equals("Junior")) { //WMC+1+1 //CCog+1+1
=======
			while (in.hasNext() && !in.next().equals("Junior")) {
>>>>>>> origin

				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.SENIOR);
				ven.setT(totalVentas);
				lista.add(ven);
			}
			// lee los vendedores junior
<<<<<<< HEAD
			while (in.hasNext() && !in.next().equals("Prácticas")) { //WMC+1+1 //CCog+1+1
=======
			while (in.hasNext() && !in.next().equals("Prácticas")) {
>>>>>>> origin
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.JUNIOR);
				ven.setT(totalVentas);
				lista.add(ven);
			}
<<<<<<< HEAD
			while (in.hasNext()) { //WMC+1 //CCog+1
=======
			while (in.hasNext()) {
>>>>>>> origin
				in.next();
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
<<<<<<< HEAD
				ven = new VendedorEnPracticas(nombre, idIn, dni);
				ven.setT(totalVentas);
				lista.add(ven);
			}
		} catch (FileNotFoundException e) { //CCog+1
		} finally {
			if (in != null) { //WMC+1 //CCog+1
=======
				ven = new vendedorEnPracticas(nombre, idIn, dni);
				ven.setT(totalVentas);
				lista.add(ven);
			}
		} catch (FileNotFoundException e) {
		} finally {
			if (in != null) {
>>>>>>> origin
				in.close();
			}
		} // try

<<<<<<< HEAD
		for (Vendedor v : lista) { //WMC+1 //CCog+1
			if (v.getId().equals(id)) { //WMC+1 //CCog+2
=======
		for (Vendedor v : lista) {
			if (v.getId().equals(id)) {
>>>>>>> origin
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda 
	 * @return La lista de vendedores
	 */
<<<<<<< HEAD
	public List<Vendedor> vendedores() { //WMC+1
=======
	public List<Vendedor> vendedores() {
>>>>>>> origin
		lista = new LinkedList<Vendedor>();

		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			Vendedor ven = null;
			// lee los vendedores senior
<<<<<<< HEAD
			while (in.hasNext() && !in.next().equals("Junior")) { //WMC+1+1 //CCog+1+1
=======
			while (in.hasNext() && !in.next().equals("Junior")) {
>>>>>>> origin

				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.SENIOR);
				ven.setT(totalVentas);
				lista.add(ven);
			}
			// lee los vendedores junior
<<<<<<< HEAD
			while (in.hasNext() && !in.next().equals("Prácticas")) { //WMC+1+1 //CCog+1+1
=======
			while (in.hasNext() && !in.next().equals("Prácticas")) {
>>>>>>> origin
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombre, idIn, dni, TipoVendedor.JUNIOR);
				ven.setT(totalVentas);
				lista.add(ven);
			}
<<<<<<< HEAD
			while (in.hasNext()) { //WMC+1 //CCog+1
=======
			while (in.hasNext()) {
>>>>>>> origin
				in.next();
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
<<<<<<< HEAD
				ven = new VendedorEnPracticas(nombre, idIn, dni);
				ven.setT(totalVentas);
				lista.add(ven);
			}
		} catch (FileNotFoundException e) { //CCog+1

		} finally {
			if (in != null) { //WMC+1 //CCog+1
=======
				ven = new vendedorEnPracticas(nombre, idIn, dni);
				ven.setT(totalVentas);
				lista.add(ven);
			}
		} catch (FileNotFoundException e) {

		} finally {
			if (in != null) {
>>>>>>> origin
				in.close();
			}
		} // try

		return lista;

	}

	/**
	 * Método que actualiza el fichero datosTienda.txt 
	 * con los datos actualizados de los vendedores
	 */
<<<<<<< HEAD
	private void vuelcaDatos() throws IOException { //WMC+1
=======
	private void vuelcaDatos() throws IOException {
>>>>>>> origin
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

<<<<<<< HEAD
		for (Vendedor v : lista) { //WMC+1 //CCog+1
			if (v instanceof VendedorEnPracticas) { //WMC+1 //CCog+2
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) { //WMC+1 //CCog+1
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp.tipo().equals(TipoVendedor.JUNIOR)) //WMC+1 //CCog+3
					junior.add(vp);
				else //CCog+1
=======
		for (Vendedor v : lista) {
			if (v instanceof vendedorEnPracticas) {
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) {
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp.tipo().equals(TipoVendedor.JUNIOR))
					junior.add(vp);
				else
>>>>>>> origin
					senior.add(vp);
			}
		}

		try {

			out = new PrintWriter(new FileWriter(datos));

			out.println(nombre);
			out.println(direccion);
			out.println();
			out.println("Senior");
<<<<<<< HEAD
			for (Vendedor v : senior) { //WMC+1 //CCog+1
=======
			for (Vendedor v : senior) {
>>>>>>> origin
				VendedorEnPlantilla v1 = (VendedorEnPlantilla) v;
				out.println("  Nombre: " + v1.getNombre() + " Id: " + v1.getId() + " DNI: "+ v1.getDni()+" TotalVentasMes: "
						+ v1.getTotalVentas());
			}
			out.println();
			out.println("Junior");
<<<<<<< HEAD
			for (Vendedor v : junior) { //WMC+1 //CCog+1
=======
			for (Vendedor v : junior) {
>>>>>>> origin
				VendedorEnPlantilla v2 = (VendedorEnPlantilla) v;
				out.println("  Nombre: " + v2.getNombre() + " Id: " + v2.getId() + " DNI: "+ v2.getDni()+" TotalVentasMes: "
						+ v2.getTotalVentas());
			}
			out.println();
			out.println("Prácticas");
<<<<<<< HEAD
			for (Vendedor v : practicas) { //WMC+1 //CCog+1
				VendedorEnPracticas v3 = (VendedorEnPracticas) v;
=======
			for (Vendedor v : practicas) {
				vendedorEnPracticas v3 = (vendedorEnPracticas) v;
>>>>>>> origin
				out.println("  Nombre: " + v3.getNombre() + " Id: " + v3.getId() + " DNI: "+ v3.getDni()+" TotalVentasMes: "
						+ v3.getTotalVentas());
			}

		} finally {
<<<<<<< HEAD
			if (out != null) //WMC+1 //CCog+1
=======
			if (out != null)
>>>>>>> origin
				out.close();
		}
	}

}
