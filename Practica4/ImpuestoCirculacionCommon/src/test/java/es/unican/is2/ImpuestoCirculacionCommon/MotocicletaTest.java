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
		 * Casos v�lidos
		 */
		try {
			sut = new Motocicleta("1111-AAA", hoy, 20);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == hoy);
			assertTrue(String.valueOf(sut.getCilindrada()),
					sut.getCilindrada() == 20);
		} catch (OperacionNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n");
		}
		
		try {
			sut = new Motocicleta("1111-AAA", ayer, 20);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == ayer);
			assertTrue(String.valueOf(sut.getCilindrada()),
					sut.getCilindrada() == 20);
		} catch (OperacionNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n");
		}
		
		/*
		 * Casos no v�lidos
		 */
		try {
			sut = new Motocicleta(null, ayer, 130);
			fail("Deber�a lanzar la excepci�n por matr�cula no v�lida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", manhana, 130);
			fail("Deber�a lanzar la excepci�n por fecha no v�lida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", null, 800);
			fail("Deber�a lanzar la excepci�n por fecha no v�lida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", hoy, 0);
			fail("Deber�a lanzar la excepci�n por potencia no v�lida");
		} catch (OperacionNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", ayer, -20);
			fail("Deber�a lanzar la excepci�n por potencia no v�lida");
		} catch (OperacionNoValida e) { }
		
	}
	
	@Test
	public void testPrecioImpuesto() {
		
		Motocicleta sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		
		/*
		 * Casos v�lidos
		 */
		try {
			sut = new Motocicleta("1111-A", LocalDate.parse("2008-03-12"), 50);
			assertEquals(8.84, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 1: no deber�a fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", hoy, 124.99);
			assertEquals(8.84, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 2: no deber�a fallar el constructor");
		}
		
		try {
			sut = new Motocicleta("1111-A", ayer, 125);
			assertEquals(15.14, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 3: no deber�a fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", LocalDate.parse("1975-06-16"), 200);
			assertEquals(0, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 4: no deber�a fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", ayer, 249.99);
			assertEquals(15.14, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 5: no deber�a fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", hoy, 250);
			assertEquals(30.30, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 6: no deber�a fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", LocalDate.parse("1975-06-16"), 400);
			assertEquals(0, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 7: no deber�a fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", hoy, 499.99);
			assertEquals(30.30, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 8: no deber�a fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", ayer, 500);
			assertEquals(60.58, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 9: no deber�a fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", hoy, 700);
			assertEquals(60.58, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 10: no deber�a fallar el constructor");
		}
		
		try {
			sut = new Motocicleta("1111-A", ayer, 999.99);
			assertEquals(60.58, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 11: no deber�a fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", hoy, 1000);
			assertEquals(121.16, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 12: no deber�a fallar el constructor");
		}

		try {
			sut = new Motocicleta("1111-A", ayer, 1500);
			assertEquals(121.16, sut.precioImpuesto(), 0.001);
		} catch (OperacionNoValida e) {
			fail("Caso 13: no deber�a fallar el constructor");
		}
		
	}

}
