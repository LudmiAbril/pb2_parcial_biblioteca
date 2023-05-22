package ar.edu.unlam.pb3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Tests {

	@Test
	public void queSePuedaSolicitarUnPrestamoDeUnLibro() {
		Alumno alumno = new Alumno(43049505, "Mariana", "Perez");
		Geografia libro = new Geografia(234, "nombre", "autor");
		Biblioteca actual = new Biblioteca();
		
		actual.agregarLibro(libro);
		ArrayList<Libro> l = new ArrayList<Libro>();
		l.add(libro);

		assertTrue(actual.realizarPrestamo(l, alumno));
	}
	
	@Test
	public void queNoSePuedaSolicitarUnPrestamoDeUnLibroQueNoEsteEnLaBiblioteca() {
		Alumno alumno = new Alumno(43049505, "Mariana", "Perez");
		Geografia libro = new Geografia(234, "nombre", "autor");
		Biblioteca actual = new Biblioteca();
		
		ArrayList<Libro> l = new ArrayList<Libro>();
		l.add(libro);

		assertFalse(actual.realizarPrestamo(l, alumno));
	}

	@Test
	public void queSePuedaSolicitarUnPrestamoDeDosLibros() {
		Alumno alumno = new Alumno(43049505, "Mariana", "Perez");
		Geografia libro = new Geografia(234, "nombre", "autor");
		Matematica libro2 = new Matematica(214, "nombre", "autor");
		Biblioteca actual = new Biblioteca();
		
		actual.agregarLibro(libro);
		actual.agregarLibro(libro2);

		ArrayList<Libro> l = new ArrayList<Libro>();
		l.add(libro);
		l.add(libro2);

		assertTrue(actual.realizarPrestamo(l, alumno));
	}

	@Test
	public void queNoSePuedaSolicitarUnPrestamoDeMasDeDosLibros() {
		Alumno alumno = new Alumno(43049505, "Mariana", "Perez");
		Geografia libro = new Geografia(234, "nombre", "autor");
		Matematica libro2 = new Matematica(214, "nombre", "autor");
		Historia libro3 = new Historia(114, "nombre", "autor");
		Biblioteca actual = new Biblioteca();
		
		actual.agregarLibro(libro);
		actual.agregarLibro(libro2);
		actual.agregarLibro(libro3);

		ArrayList<Libro> l = new ArrayList<Libro>();
		l.add(libro);
		l.add(libro2);
		l.add(libro3);

		assertFalse(actual.realizarPrestamo(l, alumno));
	}

	@Test
	public void queNoSePuedaSolicitarUnPrestamoDeUnLibroQueNoEsteDisponible() {
		Alumno alumno = new Alumno(43049505, "Mariana", "Perez");
		Alumno alumno2 = new Alumno(46012905, "Pepe", "Lopez");
		Geografia libro = new Geografia(234, "nombre", "autor");
		Biblioteca actual = new Biblioteca();
		
		actual.agregarLibro(libro);
		ArrayList<Libro> l = new ArrayList<Libro>();
		l.add(libro);
		actual.realizarPrestamo(l, alumno);

		assertFalse(actual.realizarPrestamo(l, alumno2));
	}

	@Test
	public void queSePuedaDevolverUnLibro() {
		Alumno alumno = new Alumno(43049505, "Mariana", "Perez");
		Alumno alumno2 = new Alumno(430491275, "Luciano", "Gomez");
		Geografia libro = new Geografia(234, "nombre", "autor");
		Biblioteca actual = new Biblioteca();
		
		actual.agregarLibro(libro);
		ArrayList<Libro> l = new ArrayList<Libro>();
		l.add(libro);
		
		actual.realizarPrestamo(l, alumno);
		alumno.devolver(libro, actual);
		
		assertTrue(actual.realizarPrestamo(l, alumno2));
	}

	@Test
	public void queLaBibliotecaPuedaImprimirLibrosFotocopiables() {
		Geografia libro = new Geografia(234, "nombre", "autor");
		Biblioteca actual = new Biblioteca();
		actual.agregarLibro(libro);

		assertNotNull(actual.imprimir(libro));
	}

	@Test
	public void queLaBibliotecaNoPuedaImprimirLibrosQueNoSeanFotocopiables() {
		Matematica libro = new Matematica(234, "nombre", "autor");
		Biblioteca actual = new Biblioteca();
		actual.agregarLibro(libro);

		assertNull(actual.imprimir(libro));
	}
}
