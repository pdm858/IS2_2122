package es.unican.is2.ImpuestoCirculacionCommon;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;

public class TurismoTest {

	@Test
	public void testTurismo() {
		
		Turismo sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		LocalDate manhana	= hoy.plusDays(1);

		/*
		 * Casos válidos
		 */
		try {
			sut = new Turismo("1111-AAA", hoy, 20);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == hoy);
			assertTrue(String.valueOf(sut.getPotencia()),
					sut.getPotencia() == 20);
		} catch (OperacionNoValida e) {
			fail("Caso 1: No debería lanzar la excepción");
		}
		
		try {
			sut = new Turismo("1111-AAA", ayer, 20);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == ayer);
			assertTrue(String.valueOf(sut.getPotencia()),
					sut.getPotencia() == 20);
		} catch (OperacionNoValida e) {
			fail("Caso 1: No debería lanzar la excepción");
		}
		
		/*
		 * Casos no válidos
		 */
		try {
			sut = new Turismo(null, ayer, 20);
			fail("Debería lanzar la excepción por matrícula no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Turismo("1111-AAA", manhana, 20);
			fail("Debería lanzar la excepción por fecha no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Turismo("1111-AAA", null, 20);
			fail("Debería lanzar la excepción por fecha no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Turismo("1111-AAA", hoy, 0);
			fail("Debería lanzar la excepción por potencia no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Turismo("1111-AAA", ayer, -2);
			fail("Debería lanzar la excepción por potencia no válida");
		} catch (OperacionNoValida e) { }
		
	}
	
	@Test
	public void testPrecioImpuesto() {
		
		Turismo sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		
		/*
		 * Casos válidos
		 */
		try {
			sut = new Turismo("1111-A", LocalDate.parse("2008-03-12"), 4);
			assertEquals(25.24, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 1: no debería fallar el constructor");
		}

		try {
			sut = new Turismo("1111-A", hoy, 7.99);
			assertEquals(25.24, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 2: no debería fallar el constructor");
		}
		
		try {
			sut = new Turismo("1111-A", ayer, 8);
			assertEquals(68.16, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e10) {
			fail("Caso 3: no debería fallar el constructor");
		}

		try {
			sut = new Turismo("1111-A", LocalDate.parse("1975-06-16"), 10);
			assertEquals(0, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e9) {
			fail("Caso 4: no debería fallar el constructor");
		}

		try {
			sut = new Turismo("1111-A", ayer, 11.99);
			assertEquals(68.16, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e8) {
			fail("Caso 5: no debería fallar el constructor");
		}

		try {
			sut = new Turismo("1111-A", hoy, 12);
			assertEquals(143.88, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e7) {
			fail("Caso 6: no debería fallar el constructor");
		}

		try {
			sut = new Turismo("1111-A", LocalDate.parse("1975-06-16"), 14);
			assertEquals(0, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e6) {
			fail("Caso 7: no debería fallar el constructor");
		}

		try {
			sut = new Turismo("1111-A", hoy, 15.99);
			assertEquals(143.88, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e5) {
			fail("Caso 8: no debería fallar el constructor");
		}

		try {
			sut = new Turismo("1111-A", ayer, 16);
			assertEquals(179.22, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e4) {
			fail("Caso 9: no debería fallar el constructor");
		}

		try {
			sut = new Turismo("1111-A", hoy, 18);
			assertEquals(179.22, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e3) {
			fail("Caso 10: no debería fallar el constructor");
		}
		
		try {
			sut = new Turismo("1111-A", ayer, 19.99);
			assertEquals(179.22, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e2) {
			fail("Caso 11: no debería fallar el constructor");
		}

		try {
			sut = new Turismo("1111-A", hoy, 20);
			assertEquals(224, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e1) {
			fail("Caso 12: no debería fallar el constructor");
		}

		try {
			sut = new Turismo("1111-A", ayer, 100);
			assertEquals(224, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 13: no debería fallar el constructor");
		}

	}

}
