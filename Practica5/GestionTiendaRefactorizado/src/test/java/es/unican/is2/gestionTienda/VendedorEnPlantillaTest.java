package es.unican.is2.gestionTienda;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class VendedorEnPlantillaTest {
	
	private static VendedorEnPlantilla sutJunior;
	private static VendedorEnPlantilla sutSenior;

	
	@Before
	public void setUp(){
		sutJunior = new VendedorEnPlantilla("Ana", "1", "11111111A");
		sutSenior = new VendedorEnPlantilla("Pepe", "2", "222222222A");
	}
	
	@Test
	public void testConstructor() {
		assertEquals("1", sutJunior.getId());
		assertEquals("11111111A", sutJunior.getDni());
		assertEquals("Ana", sutJunior.getNombre());
	}

	@Test
	public void testAnhadeVenta() {
		
		sutJunior.anhade(200);
		assertEquals(200, sutJunior.getTotalVentas(), 0);
		
		sutJunior.anhade(300);
		assertEquals(500, sutJunior.getTotalVentas(), 0);
		
		sutSenior.anhade(300);
		assertEquals(300, sutSenior.getTotalVentas(), 0);
		
		sutSenior.anhade(300);
		assertEquals(600, sutSenior.getTotalVentas(), 0);
		
	}
	
	@Test
	public void testSetTotalVentas() {
		
		sutJunior.setT(2000);
		assertEquals(2000, sutJunior.getTotalVentas(), 0);	
		sutJunior.setT(4000);
		assertEquals(4000, sutJunior.getTotalVentas(), 0);	
		sutJunior.setT(0);
		assertEquals(0, sutJunior.getTotalVentas(), 0);
		
		sutSenior.setT(4500);
		assertEquals(4500, sutSenior.getTotalVentas(), 0);		
		sutSenior.setT(4000);
		assertEquals(4000, sutSenior.getTotalVentas(), 0);
		sutJunior.setT(0);
		assertEquals(0, sutJunior.getTotalVentas(), 0);	
		
	}

	
	@Test
	public void testEquals() {
		VendedorEnPlantilla igualJunior = new VendedorEnPlantilla("Ana", "1", "11111111A");
		VendedorEnPlantilla distintoIdJunior = new VendedorEnPlantilla("Ana", "2", "11111111A");
		VendedorEnPlantilla distintoDNIJunior = new VendedorEnPlantilla("Ana", "1", "222222222A");
		
		assertEquals(igualJunior, sutJunior);
		assertNotEquals(distintoIdJunior, sutJunior);
		assertNotEquals(distintoDNIJunior, sutJunior);
		
		
		VendedorEnPlantilla igualSenior = new VendedorEnPlantilla("Pepe", "2", "222222222A");
		VendedorEnPlantilla distintoIdSenior = new VendedorEnPlantilla("Pepe", "3", "222222222A");
		VendedorEnPlantilla distintoDNISenior = new VendedorEnPlantilla("Pepe", "2", "33333333A");
		
		assertEquals(igualSenior, sutSenior);
		assertNotEquals(distintoIdSenior, sutSenior);
		assertNotEquals(distintoDNISenior, sutSenior);
		
		
		
		
	}
	
	
	
}
