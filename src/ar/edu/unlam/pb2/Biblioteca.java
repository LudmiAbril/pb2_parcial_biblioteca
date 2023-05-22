package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
	private Integer id = 0;

	public Boolean realizarPrestamo(ArrayList<Libro> libros_solicitados, Alumno alumno) {
		if (libros.containsAll(libros_solicitados) && disponible(libros_solicitados) && libros_solicitados.size() < 3) {
			prestar(libros_solicitados);
			id++;
			return prestamos.add(new Prestamo(id, alumno, libros_solicitados));
		}
		return false;

	}

	private Boolean disponible(ArrayList<Libro> libros_solicitados) {
		Integer disponibles = 0;
		for (Libro l_s : libros_solicitados) {
			for (Libro l : libros) {
				if (l.equals(l_s) && l.getDisponible()) {
					disponibles++;
				}
			}
		}

		if (disponibles == libros_solicitados.size()) {
			return true;
		}
		return false;
	}

	private void prestar(ArrayList<Libro> libros_solicitados) {
		for (Libro l_s : libros_solicitados) {
			for (Libro l : libros) {
				if (l.equals(l_s)) {
					l.setDisponible(false);
				}
			}
		}
	}

	public Integer getCantidadDePrestamosRealizados() {
		return prestamos.size();
	}

	public void agregarLibro(Libro libro) {
		libros.add(libro);

	}

	public Object imprimir(Libro libro) {
		for(Libro l : libros) {
			if(l instanceof Geografia || l instanceof Historia) {
				return ((Fotocopiable) l).fotocopiar();
			}
		}
		return null;
	}

	public void devolucion(Libro libro) {
		for(Libro l : libros) {
			if(l.equals(libro)) {
				l.setDisponible(true);
			}
		}
		
	}

}
