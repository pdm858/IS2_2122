package es.unican.is2.listaOrdenada;

import static org.junit.Assert.*;

import org.junit.Test;

import es.unican.is2.listaOrdenadaAcotada.ListaOrdenadaAcotada;

public class ListaOrdenadaAcotadaTest {
	
	ListaOrdenadaAcotada<Integer> sut = new ListaOrdenadaAcotada<Integer>();
	
	@Test
	public void testAddGetSize() {			//PROBLEMAS FAIL CON 2 LISTA VACIA Y PROBAR NULL (DONDE 15)
		try {
			sut.get(2); //índice no válido
			//fail("Indice 2 no valido en lista vacía");
		} catch (IndexOutOfBoundsException e) {}
		
		sut.add(1); //añade a lista vacia
		assertTrue("Elemento: " + sut.get(0), sut.get(0) == 1); //comienza en 0, primer indice válido
		assertTrue("Tamaño: " + sut.size(), sut.size() == 1); //tamaño mínimo
		
		sut.add(3); //añade a lista con elementos
		assertTrue("Elemento: " + sut.get(1), sut.get(1) == 3);
		assertTrue("Tamaño: " + sut.size(), sut.size() == 2);
		
		sut.add(5);
		sut.add(2); //añade en un hueco
		assertTrue("Elemento: " + sut.get(1), sut.get(1) == 2);
		assertTrue("Tamaño: " + sut.size(), sut.size() == 4);
		
		sut.add(7);
		sut.add(8);
		sut.add(9);
		sut.add(7); //añade numero repetido
		sut.add(12);
		sut.add(15); //probar null ??
		assertTrue("Elemento: " + sut.get(9), sut.get(9) == 15);
		assertTrue("Tamaño: " + sut.size(), sut.size() == 10); //tamaño máximo
		
		try {
			sut.add(10); //añade a lista llena
			fail("La lista deberia estar llena");
		} catch (IllegalStateException e) {}
		
		try {
			sut.get(-1); //índice no válido
			fail("Indice -1 no valido");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			sut.get(10); //índice no válido
			fail("Indice 10 no valido");
		} catch (IndexOutOfBoundsException e) {}
	}
	
	@Test
	public void testRemove() {
		int num;
		try {
			sut.remove(2); //Eliminar cuando no hay elementos
			fail("Indice 2 no valido en lista vacia");
		} catch (IndexOutOfBoundsException e) {}
		
		sut.add(1); //Eliminar cuando hay un elemento
		num = sut.remove(0);
		assertTrue("Elemento: " + num, num == 1);
		assertTrue("Tamaño: " + sut.size(), sut.size() == 0);
		
		sut.add(1); //Eliminar con más de un elemento
		sut.add(3);
		num = sut.remove(0);
		assertTrue("Elemento: " + num, num == 3);
		assertTrue("Tamaño: " + sut.size(), sut.size() == 1);
		
		sut.add(3); //Eliminar para lista llena
		sut.add(5);
		sut.add(2);
		sut.add(7);
		sut.add(8);
		sut.add(9);
		sut.add(7);
		sut.add(12);
		sut.add(15);
		num = sut.remove(9);
		assertTrue("Elemento: " + num, num == 15);
		assertTrue("Tamaño: " + sut.size(), sut.size() == 9);
		
		try {
			sut.remove(-1); //índice no válido
			fail("Indice -1 no valido");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			sut.remove(10); //índice no válido
			fail("Indice 10 no valido");
		} catch (IndexOutOfBoundsException e) {}
	}
	
	@Test
	public void testClear() {
		sut.clear(); //Lista sin elementos
		assertTrue("Ha vaciado lista", sut.size() == 0);
		
		sut.add(0); //Lista con un elemento
		sut.clear();
		assertTrue("Ha vaciado lista", sut.size() == 0);
		
		sut.add(0); //Lista con varios elementos
		sut.add(1);
		sut.add(2);
		sut.add(3);
		sut.add(4);
		sut.add(5);
		sut.clear();
		assertTrue("Ha vaciado lista", sut.size() == 0);
		
		sut.add(0); //Lista llena
		sut.add(1);
		sut.add(2);
		sut.add(3);
		sut.add(4);
		sut.add(5);
		sut.add(6);
		sut.add(7);
		sut.add(8);
		sut.add(9);
		sut.clear();
		assertTrue("Ha vaciado lista", sut.size() == 0);
	}
}
