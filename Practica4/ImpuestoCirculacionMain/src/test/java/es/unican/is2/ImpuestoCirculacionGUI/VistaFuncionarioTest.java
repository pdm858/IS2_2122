package es.unican.is2.ImpuestoCirculacionGUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.ImpuestoCirculacionBusiness.GestionImpuestoCirculacion;
import es.unican.is2.ImpuestoCirculacionDAO.ContribuyentesDAO;
import es.unican.is2.ImpuestoCirculacionDAO.VehiculosDAO;

import org.fest.swing.fixture.FrameFixture;

public class VistaFuncionarioTest {

	private FrameFixture demo;
	
	@Before
	public void setUp() {
		// Componentes capa DAO
		ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
		VehiculosDAO vehiculosDAO = new VehiculosDAO();
				
		// Componentes capa negocio
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
		
		// Componentes casa presentacion
		VistaFuncionario gui = new VistaFuncionario(negocio, negocio, negocio);
		demo = new FrameFixture(gui);
		gui.setVisible(true);
	}
	
	@After
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void test() {
		
		/*
		 * Prueba aspecto de la interfaz
		 */
		demo.button("btnBuscar").requireText("Buscar");
		
		/*
		 * Prueba DNI no v�lido
		 */
		// Escribimos en el campo de Texto
		demo.textBox("txtDniContribuyente").enterText("1111-AAA");
		// Pulsamos el bot�n
		demo.button("btnBuscar").click();
		// Comprobamos la salida
		demo.textBox("txtTotalContribuyente").requireText("0");
		demo.textBox("txtNombreContribuyente").requireText("DNI No V�lido");
		
		demo.list("listMatriculasVehiculos").requireItemCount(0);
		
		/*
		 * Prueba DNI v�lido
		 */
		// Escribimos en el campo de Texto
		demo.textBox("txtDniContribuyente").deleteText();
		demo.textBox("txtDniContribuyente").enterText("11111111A");
		// Pulsamos el bot�n
		demo.button("btnBuscar").click();
		// Comprobamos la salida
		demo.textBox("txtTotalContribuyente").requireText("403.2");
		demo.textBox("txtNombreContribuyente").requireText("Pepe L�pez Mart�nez");
		demo.list("listMatriculasVehiculos").item(0).toString().equals("1111-AAA");
		demo.list("listMatriculasVehiculos").item(1).toString().equals("1111-BBB");
		
		
		/*
		 * Prueba DNI vac�o
		 */
		// Escribimos en el campo de Texto
		demo.textBox("txtDniContribuyente").deleteText();
		demo.textBox("txtDniContribuyente").enterText("");
		// Pulsamos el bot�n
		demo.button("btnBuscar").click();
		// Comprobamos la salida
		demo.textBox("txtTotalContribuyente").requireText("0");
		demo.textBox("txtNombreContribuyente").requireText("DNI No V�lido");
		demo.list("listMatriculasVehiculos").requireItemCount(0);
		
		/*
		 * Prueba DNI vac�o
		 */
		// Escribimos en el campo de Texto
		demo.textBox("txtDniContribuyente").deleteText();
		demo.textBox("txtDniContribuyente").enterText("44444444D");
		// Pulsamos el bot�n
		demo.button("btnBuscar").click();
		// Comprobamos la salida
		demo.textBox("txtTotalContribuyente").requireText("0.0");
		demo.textBox("txtNombreContribuyente").requireText("Luisa Mart�nez L�pez");
		demo.list("listMatriculasVehiculos").requireItemCount(0);
		
	}
	
}