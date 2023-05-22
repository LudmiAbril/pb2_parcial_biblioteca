package ar.edu.unlam.pb2;

public class Alumno {
	private Integer dni;
	private String nombre;
	private String apellido;

	public Alumno(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public void devolver(Libro libro, Biblioteca actual) {
		actual.devolucion(libro);
		
	}


}
