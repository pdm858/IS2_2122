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
		 * Casos válidos
		 */
		try {
			sut = new Furgoneta("1111-AAA", hoy, 20, true);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == hoy);
			assertTrue((sut.getComercial()) ? "COMERCIAL" : "NO COMERCIAL",
					sut.getComercial());
		} catch (OperacionNoValida e) {
			fail("Caso 1: No debería lanzar la excepción");
		}
		
		try {
			sut = new Furgoneta("1111-AAA", ayer, 20, false);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == ayer);
			assertTrue((sut.getComercial()) ? "COMERCIAL" : "NO COMERCIAL",
					!sut.getComercial());
		} catch (OperacionNoValida e) {
			fail("Caso 1: No debería lanzar la excepción");
		}
		
		/*
		 * Casos no válidos
		 */
		try {
			sut = new Furgoneta(null, ayer, 20, true);
			fail("Debería lanzar la excepción por matrícula no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", manhana, 20, true);
			fail("Debería lanzar la excepción por fecha no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", null, 20, true);
			fail("Debería lanzar la excepción por fecha no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", hoy, 0, true);
			fail("Debería lanzar la excepción por potencia no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", ayer, -2, true);
			fail("Debería lanzar la excepción por potencia no válida");
		} catch (OperacionNoValida e) { }
		
	}
	
	@Test
	public void precioImpuestoTest() {
		
		Furgoneta sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		
		/*
		 * Casos válidos
		 */
		try {
			sut = new Furgoneta("1111-A", LocalDate.parse("2008-03-12"), 4,
					true);
			assertEquals(20.192, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 1: no debería fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", hoy, 7.99, false);
			assertEquals(25.24, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 2: no debería fallar el constructor");
		}
		
		try {
			sut = new Furgoneta("1111-A", ayer, 8, true);
			assertEquals(54.528, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 3: no debería fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", LocalDate.parse("1975-06-16"), 10,
					true);
			assertEquals(0, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 4: no debería fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", ayer, 11.99, false);
			assertEquals(68.16, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 5: no debería fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", hoy, 12, false);
			assertEquals(143.88, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 6: no debería fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", LocalDate.parse("1975-06-16"), 14,
					false);
			assertEquals(0, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 7: no debería fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", hoy, 15.99, false);
			assertEquals(143.88, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 8: no debería fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", ayer, 16, false);
			assertEquals(179.22, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 9: no debería fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", hoy, 18, false);
			assertEquals(179.22, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 10: no debería fallar el constructor");
		}
		
		try {
			sut = new Furgoneta("1111-A", ayer, 19.99, false);
			assertEquals(179.22, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 11: no debería fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", hoy, 20, false);
			assertEquals(224, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 12: no debería fallar el constructor");
		}

		try {
			sut = new Furgoneta("1111-A", ayer, 100, false);
			assertEquals(224, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 13: no debería fallar el constructor");
		}
		
	}

}
