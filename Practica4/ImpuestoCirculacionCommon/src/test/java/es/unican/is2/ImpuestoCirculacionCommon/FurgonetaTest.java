package es.unican.is2.ImpuestoCirculacionCommon;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class FurgonetaTest {

	@Test
	public void testFurgoneta() {

		Furgoneta sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		LocalDate manhana	= hoy.plusDays(1);

		/*
		 * Casos v�lidos
		 */
		try {
			sut = new Furgoneta("1111-AAA", hoy, 20, true);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == hoy);
			assertTrue((sut.getComercial()) ? "COMERCIAL" : "NO COMERCIAL",
					sut.getComercial());
		} catch (OperacionNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n");
		}
		
		try {
			sut = new Furgoneta("1111-AAA", ayer, 20, false);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == ayer);
			assertTrue((sut.getComercial()) ? "COMERCIAL" : "NO COMERCIAL",
					!sut.getComercial());
		} catch (OperacionNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n");
		}
		
		/*
		 * Casos no v�lidos
		 */
		try {
			sut = new Furgoneta(null, ayer, 20, true);
			fail("Deber�a lanzar la excepci�n por matr�cula no v�lida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", manhana, 20, true);
			fail("Deber�a lanzar la excepci�n por fecha no v�lida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", null, 20, true);
			fail("Deber�a lanzar la excepci�n por fecha no v�lida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", hoy, 0, true);
			fail("Deber�a lanzar la excepci�n por potencia no v�lida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", ayer, -2, true);
			fail("Deber�a lanzar la excepci�n por potencia no v�lida");
		} catch (OperacionNoValida e) { }
		
	}
	
	@Test
	public void precioImpuestoTest() {
		
		Furgoneta sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		
		/*
		 * Casos v�lidos
		 */
		try {
			sut = new Furgoneta("1111-A", LocalDate.parse("2008-03-12"), 4,
					true);
			assertEquals(20.192, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 1: no deber�a fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", hoy, 7.99, false);
			assertEquals(25.24, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 2: no deber�a fallar el constructor");
		}
		
		try {
			sut = new Furgoneta("1111-A", ayer, 8, true);
			assertEquals(54.528, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 3: no deber�a fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", LocalDate.parse("1975-06-16"), 10,
					true);
			assertEquals(0, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 4: no deber�a fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", ayer, 11.99, false);
			assertEquals(68.16, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 5: no deber�a fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", hoy, 12, false);
			assertEquals(143.88, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 6: no deber�a fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", LocalDate.parse("1975-06-16"), 14,
					false);
			assertEquals(0, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 7: no deber�a fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", hoy, 15.99, false);
			assertEquals(143.88, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 8: no deber�a fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", ayer, 16, false);
			assertEquals(179.22, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 9: no deber�a fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", hoy, 18, false);
			assertEquals(179.22, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 10: no deber�a fallar el constructor");
		}
		
		try {
			sut = new Furgoneta("1111-A", ayer, 19.99, false);
			assertEquals(179.22, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 11: no deber�a fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", hoy, 20, false);
			assertEquals(224, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 12: no deber�a fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", ayer, 100, false);
			assertEquals(224, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 13: no deber�a fallar el constructor");
		}
		
	}

}
