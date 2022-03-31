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
		} catch (MatriculaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (matr�cula)");
		} catch (FechaMatriculacionNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (fecha)");
		} catch (CilindradaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (potencia)");
		}
		
		try {
			sut = new Motocicleta("1111-AAA", ayer, 20);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == ayer);
			assertTrue(String.valueOf(sut.getCilindrada()),
					sut.getCilindrada() == 20);
		} catch (MatriculaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (matr�cula)");
		} catch (FechaMatriculacionNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (fecha)");
		} catch (CilindradaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (potencia)");
		}
		
		/*
		 * Casos no v�lidos
		 */
		try {
			sut = new Motocicleta(null, ayer, 130);
			fail("Deber�a lanzar la excepci�n por matr�cula no v�lida");
		} catch (MatriculaNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", manhana, 130);
			fail("Deber�a lanzar la excepci�n por fecha no v�lida");
		} catch (FechaMatriculacionNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", null, 800);
			fail("Deber�a lanzar la excepci�n por fecha no v�lida");
		} catch (FechaMatriculacionNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", hoy, 0);
			fail("Deber�a lanzar la excepci�n por potencia no v�lida");
		} catch (CilindradaNoValida e) { }
		
		try {
			sut = new Motocicleta("1111-AAA", ayer, -2);
			fail("Deber�a lanzar la excepci�n por potencia no v�lida");
		} catch (MatriculaNoValida e) { }
		
	}
	
	@Test
	public void testPrecioImpuesto() {
		
		Motocicleta sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		LocalDate manhana	= hoy.plusDays(1);
		
		/*
		 * Casos v�lidos
		 */
		sut = new Motocicleta("1111-A", LocalDate.parse("2008-03-12"), 50);
		assertTrue(sut.precioImpuesto() == 8.84);

		sut = new Motocicleta("1111-A", hoy, 124.99);
		assertTrue(sut.precioImpuesto() == 8.84);
		
		sut = new Motocicleta("1111-A", ayer, 125);
		assertTrue(sut.precioImpuesto() == 15.14);

		sut = new Motocicleta("1111-A", LocalDate.parse("1975-06-16"), 200);
		assertTrue(sut.precioImpuesto() == 0);

		sut = new Motocicleta("1111-A", ayer, 249.99);
		assertTrue(sut.precioImpuesto() == 15.14);

		sut = new Motocicleta("1111-A", hoy, 250);
		assertTrue(sut.precioImpuesto() == 30.30);

		sut = new Motocicleta("1111-A", LocalDate.parse("1975-06-16"), 400);
		assertTrue(sut.precioImpuesto() == 0);

		sut = new Motocicleta("1111-A", hoy, 499.99);
		assertTrue(sut.precioImpuesto() == 30.30);

		sut = new Motocicleta("1111-A", ayer, 500);
		assertTrue(sut.precioImpuesto() == 60.58);

		sut = new Motocicleta("1111-A", hoy, 700);
		assertTrue(sut.precioImpuesto() == 60.58);
		
		sut = new Motocicleta("1111-A", ayer, 999.99);
		assertTrue(sut.precioImpuesto() == 60.58);

		sut = new Motocicleta("1111-A", hoy, 1000);
		assertTrue(sut.precioImpuesto() == 121.16);

		sut = new Motocicleta("1111-A", ayer, 1500);
		assertTrue(sut.precioImpuesto() == 121.16);
		
	}

}
