package ar.edu.unlam.pb2;

public class Historia extends Libro implements Fotocopiable {

	public Historia(Integer cod, String nombre, String autor) {
		super(cod, nombre, autor);
	}

	@Override
	public String fotocopiar() {
		return "nombre: " + this.getNombre() + "autor: " + this.getAutor();
	}

}
