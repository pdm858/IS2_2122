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
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.button("btnBuscar").requireText("Buscar");
		
		// Escribimos en el campo de Texto
		demo.textBox("txtDniContribuyente").enterText("1111-AAA");
		// Pulsamos el botón
		demo.button("btnBuscar").click();
		// Comprobamos la salida
		demo.textBox("txtTotalContribuyente").requireText("0");
		demo.textBox("txtNombreContribuyente").requireText("DNI No Válido");
		demo.textBox("listMatriculasVehiculos").requireEmpty();
		
		// Escribimos en el campo de Texto
		demo.textBox("txtDniContribuyente").enterText("11111111A");
		// Pulsamos el botón
		demo.button("btnBuscar").click();
		// Comprobamos la salida
		demo.textBox("txtTotalContribuyente").requireText("403.0");
		demo.textBox("txtNombreContribuyente").requireText("Pepe López Martínez");
		demo.textBox("listMatriculasVehiculos").requireText("1111-AAA"+""+"1111-BBB");
		
/*		// Escribimos en el campo de Texto
		demo.textBox("txtDniContribuyente").enterText("22222222B");
		// Pulsamos el botón
		demo.button("btnBuscar").click();
		// Comprobamos la salida
		demo.textBox("txtTotalContribuyente").requireText("232.0");
		demo.textBox("txtNombreContribuyente").requireText("Ana Pérez López");
		demo.textBox("listMatriculasVehiculos").requireText("2222-AAA"+"2222-BBB");
		
		// Escribimos en el campo de Texto
		demo.textBox("txtDniContribuyente").enterText("33333333C");
		// Pulsamos el botón
		demo.button("btnBuscar").click();
		// Comprobamos la salida
		demo.textBox("txtTotalContribuyente").requireText("249.0");
		demo.textBox("txtNombreContribuyente").requireText("Luis Toca Pérez");
		demo.textBox("listMatriculasVehiculos").requireText("3333-AAA"+"3333-BBB");
*/
	}
	
}