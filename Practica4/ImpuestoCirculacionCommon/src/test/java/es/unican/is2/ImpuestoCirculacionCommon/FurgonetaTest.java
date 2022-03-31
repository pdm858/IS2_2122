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
		} catch (MatriculaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (matr�cula)");
		} catch (FechaMatriculacionNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (fecha)");
		} catch (PotenciaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (potencia)");
		} catch (ComercialNoValido e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (comercial)");
		}
		
		try {
			sut = new Furgoneta("1111-AAA", ayer, 20, false);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == ayer);
			assertTrue((sut.getComercial()) ? "COMERCIAL" : "NO COMERCIAL",
					!sut.getComercial());
		} catch (MatriculaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (matr�cula)");
		} catch (FechaMatriculacionNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (fecha)");
		} catch (PotenciaNoValida e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (potencia)");
		} catch (ComercialNoValido e) {
			fail("Caso 1: No deber�a lanzar la excepci�n (comercial)");
		}
		
		/*
		 * Casos no v�lidos
		 */
		try {
			sut = new Furgoneta(null, ayer, 20, true);
			fail("Deber�a lanzar la excepci�n por matr�cula no v�lida");
		} catch (MatriculaNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", manhana, 20, true);
			fail("Deber�a lanzar la excepci�n por fecha no v�lida");
		} catch (FechaMatriculacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", null, 20, true);
			fail("Deber�a lanzar la excepci�n por fecha no v�lida");
		} catch (FechaMatriculacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", hoy, 0, true);
			fail("Deber�a lanzar la excepci�n por potencia no v�lida");
		} catch (PotenciaNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", ayer, -2, true);
			fail("Deber�a lanzar la excepci�n por potencia no v�lida");
		} catch (MatriculaNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", hoy, 20, null);
			fail("Deber�a lanzar la excepci�n por comercial no v�lido");
		} catch (ComercialNoValido e) { }
		
	}
	
	@Test
	public void precioImpuestoTest() {
		
		Furgoneta sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		
		/*
		 * Casos v�lidos
		 */
		sut = new Furgoneta("1111-A", LocalDate.parse("2008-03-12"), 4, true);
		assertTrue(sut.precioImpuesto() == 20.19);

		sut = new Furgoneta("1111-A", hoy, 7.99, false);
		assertTrue(sut.precioImpuesto() == 25.24);
		
		sut = new Furgoneta("1111-A", ayer, 8, true);
		assertTrue(sut.precioImpuesto() == 54.53);

		sut = new Furgoneta("1111-A", LocalDate.parse("1975-06-16"), 10, true);
		assertTrue(sut.precioImpuesto() == 0);

		sut = new Furgoneta("1111-A", ayer, 11.99, false);
		assertTrue(sut.precioImpuesto() == 68.16);

		sut = new Furgoneta("1111-A", hoy, 12, false);
		assertTrue(sut.precioImpuesto() == 143.88);

		sut = new Furgoneta("1111-A", LocalDate.parse("1975-06-16"), 14, false);
		assertTrue(sut.precioImpuesto() == 0);

		sut = new Furgoneta("1111-A", hoy, 15.99, false);
		assertTrue(sut.precioImpuesto() == 143.88);

		sut = new Furgoneta("1111-A", ayer, 16, false);
		assertTrue(sut.precioImpuesto() == 179.22);

		sut = new Furgoneta("1111-A", hoy, 18, false);
		assertTrue(sut.precioImpuesto() == 179.22);
		
		sut = new Furgoneta("1111-A", ayer, 19.99, false);
		assertTrue(sut.precioImpuesto() == 179.22);

		sut = new Furgoneta("1111-A", hoy, 20, false);
		assertTrue(sut.precioImpuesto() == 224);

		sut = new Furgoneta("1111-A", ayer, 100, false);
		assertTrue(sut.precioImpuesto() == 224);
		
	}

}
