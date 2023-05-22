package ar.edu.unlam.pb3;

import java.util.ArrayList;

public class Prestamo {
	private Integer id;
	private Alumno alumno;
	private ArrayList<Libro> libros = new ArrayList<Libro>();

	public Prestamo(Integer id, Alumno alumno, ArrayList<Libro> libros_solicitados) {
		this.id = id;
		this.alumno = alumno;
		this.libros = libros_solicitados;
	}

}
