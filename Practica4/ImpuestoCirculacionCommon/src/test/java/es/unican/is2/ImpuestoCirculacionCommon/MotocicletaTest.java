package es.unican.is2.ImpuestoCirculacionCommon;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class MotocicletaTest {

	@Test
	public void testMotocicleta() {
		
		Motocicleta sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		LocalDate manhana	= hoy.plusDays(1);

		/*
		 * Casos válidos
		 */
		try {
			sut = new Motocicleta("1111-AAA", hoy, 20);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == hoy);
			assertTrue(String.valueOf(sut.getCilindrada()),
					sut.getCilindrada() == 20);
		} catch (OperacionNoValida e) {
			fail("Caso 1: No debería lanzar la excepción");
		}
		
		try {
			sut = new Motocicleta("1111-AAA", ayer, 20);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == ayer);
			assertTrue(String.valueOf(sut.getCilindrada()),
					sut.getCilindrada() == 20);
		} catch (OperacionNoValida e) {
			fail("Caso 1: No debería lanzar la excepción");
		}
		
		/*
		 * Casos no válidos
		 */
		try {
			sut = new Motocicleta(null, ayer, 130);
			fail("Debería lanzar la excepción por matrícula no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", manhana, 130);
			fail("Debería lanzar la excepción por fecha no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", null, 800);
			fail("Debería lanzar la excepción por fecha no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", hoy, 0);
			fail("Debería lanzar la excepción por potencia no válida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", ayer, -20);
			fail("Debería lanzar la excepción por potencia no válida");
		} catch (OperacionNoValida e) { }
		
	}
	
	@Test
	public void testPrecioImpuesto() {
		
		Motocicleta sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		
		/*
		 * Casos válidos
		 */
		try {
			sut = new Motocicleta("1111-A", LocalDate.parse("2008-03-12"), 50);
			assertEquals(8.84, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 1: no debería fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", hoy, 124.99);
			assertEquals(8.84, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 2: no debería fallar el constructor");
		}
		
		try {
			sut = new Motocicleta("1111-A", ayer, 125);
			assertEquals(15.14, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 3: no debería fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", LocalDate.parse("1975-06-16"), 200);
			assertEquals(0, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 4: no debería fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", ayer, 249.99);
			assertEquals(15.14, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 5: no debería fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", hoy, 250);
			assertEquals(30.30, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 6: no debería fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", LocalDate.parse("1975-06-16"), 400);
			assertEquals(0, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 7: no debería fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", hoy, 499.99);
			assertEquals(30.30, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 8: no debería fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", ayer, 500);
			assertEquals(60.58, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 9: no debería fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", hoy, 700);
			assertEquals(60.58, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 10: no debería fallar el constructor");
		}
		
		try {
			sut = new Motocicleta("1111-A", ayer, 999.99);
			assertEquals(60.58, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 11: no debería fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", hoy, 1000);
			assertEquals(121.16, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 12: no debería fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", ayer, 1500);
			assertEquals(121.16, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 13: no debería fallar el constructor");
		}
		
	}

}
