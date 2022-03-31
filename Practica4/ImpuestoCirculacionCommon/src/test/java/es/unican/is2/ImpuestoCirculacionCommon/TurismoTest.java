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
		 * Casos v�lidos
		 */
		try {
			sut = new Turismo("1111-AAA", hoy, 20);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == hoy);
			assertTrue(String.valueOf(sut.getPotencia()),
					sut.getPotencia() == 20);
		} catch (MatriculaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (matr�cula)");
		} catch (FechaMatriculacionNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (fecha)");
		} catch (PotenciaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (potencia)");
		}
		
		try {
			sut = new Turismo("1111-AAA", ayer, 20);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == ayer);
			assertTrue(String.valueOf(sut.getPotencia()),
					sut.getPotencia() == 20);
		} catch (MatriculaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (matr�cula)");
		} catch (FechaMatriculacionNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (fecha)");
		} catch (PotenciaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (potencia)");
		}
		
		/*
		 * Casos no v�lidos
		 */
		try {
			sut = new Turismo(null, ayer, 20);
			fail("Deber�a lanzar la excepci�n por matr�cula no v�lida");
		} catch (MatriculaNoValida e) { }
		
		try {
			sut = new Turismo("1111-AAA", manhana, 20);
			fail("Deber�a lanzar la excepci�n por fecha no v�lida");
		} catch (FechaMatriculacionNoValida e) { }
		
		try {
			sut = new Turismo("1111-AAA", null, 20);
			fail("Deber�a lanzar la excepci�n por fecha no v�lida");
		} catch (FechaMatriculacionNoValida e) { }
		
		try {
			sut = new Turismo("1111-AAA", hoy, 0);
			fail("Deber�a lanzar la excepci�n por potencia no v�lida");
		} catch (PotenciaNoValida e) { }
		
		try {
			sut = new Turismo("1111-AAA", ayer, -2);
			fail("Deber�a lanzar la excepci�n por potencia no v�lida");
		} catch (MatriculaNoValida e) { }
		
	}
	
	@Test
	public void testPrecioImpuesto() {
		
		Turismo sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		
		/*
		 * Casos v�lidos
		 */
		sut = new Turismo("1111-A", LocalDate.parse("2008-03-12"), 4);
		assertTrue(sut.precioImpuesto() == 25.24);

		sut = new Turismo("1111-A", hoy, 7.99);
		assertTrue(sut.precioImpuesto() == 25.24);
		
		sut = new Turismo("1111-A", ayer, 8);
		assertTrue(sut.precioImpuesto() == 68.16);

		sut = new Turismo("1111-A", LocalDate.parse("1975-06-16"), 10);
		assertTrue(sut.precioImpuesto() == 0);

		sut = new Turismo("1111-A", ayer, 11.99);
		assertTrue(sut.precioImpuesto() == 68.16);

		sut = new Turismo("1111-A", hoy, 12);
		assertTrue(sut.precioImpuesto() == 143.88);

		sut = new Turismo("1111-A", LocalDate.parse("1975-06-16"), 14);
		assertTrue(sut.precioImpuesto() == 0);

		sut = new Turismo("1111-A", hoy, 15.99);
		assertTrue(sut.precioImpuesto() == 143.88);

		sut = new Turismo("1111-A", ayer, 16);
		assertTrue(sut.precioImpuesto() == 179.22);

		sut = new Turismo("1111-A", hoy, 18);
		assertTrue(sut.precioImpuesto() == 179.22);
		
		sut = new Turismo("1111-A", ayer, 19.99);
		assertTrue(sut.precioImpuesto() == 179.22);

		sut = new Turismo("1111-A", hoy, 20);
		assertTrue(sut.precioImpuesto() == 224);

		sut = new Turismo("1111-A", ayer, 100);
		assertTrue(sut.precioImpuesto() == 224);

	}

}
