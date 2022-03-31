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
		} catch (MatriculaNoValida e) {
			fail("Caso 1: No debería lanzar la excepción (matrícula)");
		} catch (FechaMatriculacionNoValida e) {
			fail("Caso 1: No debería lanzar la excepción (fecha)");
		} catch (PotenciaNoValida e) {
			fail("Caso 1: No debería lanzar la excepción (potencia)");
		} catch (ComercialNoValido e) {
			fail("Caso 1: No debería lanzar la excepción (comercial)");
		}
		
		try {
			sut = new Furgoneta("1111-AAA", ayer, 20, false);
			assertTrue(sut.getMatricula(), sut.getMatricula() == "1111-AAA");
			assertTrue(sut.getFechaMatriculacion().toString(),
					sut.getFechaMatriculacion() == ayer);
			assertTrue((sut.getComercial()) ? "COMERCIAL" : "NO COMERCIAL",
					!sut.getComercial());
		} catch (MatriculaNoValida e) {
			fail("Caso 1: No debería lanzar la excepción (matrícula)");
		} catch (FechaMatriculacionNoValida e) {
			fail("Caso 1: No debería lanzar la excepción (fecha)");
		} catch (PotenciaNoValida e) {
			fail("Caso 1: No debería lanzar la excepción (potencia)");
		} catch (ComercialNoValido e) {
			fail("Caso 1: No debería lanzar la excepción (comercial)");
		}
		
		/*
		 * Casos no válidos
		 */
		try {
			sut = new Furgoneta(null, ayer, 20, true);
			fail("Debería lanzar la excepción por matrícula no válida");
		} catch (MatriculaNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", manhana, 20, true);
			fail("Debería lanzar la excepción por fecha no válida");
		} catch (FechaMatriculacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", null, 20, true);
			fail("Debería lanzar la excepción por fecha no válida");
		} catch (FechaMatriculacionNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", hoy, 0, true);
			fail("Debería lanzar la excepción por potencia no válida");
		} catch (PotenciaNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", ayer, -2, true);
			fail("Debería lanzar la excepción por potencia no válida");
		} catch (MatriculaNoValida e) { }
		
		try {
			sut = new Furgoneta("1111-AAA", hoy, 20, null);
			fail("Debería lanzar la excepción por comercial no válido");
		} catch (ComercialNoValido e) { }
		
	}
	
	@Test
	public void precioImpuestoTest() {
		
		Furgoneta sut;
		LocalDate hoy		= LocalDate.now();
		LocalDate ayer		= hoy.minusDays(1);
		
		/*
		 * Casos válidos
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
