package ar.edu.unlam.pb3;

public class Libro {
	private Integer cod;
	private String nombre;
	private String autor;
	private Boolean disponible;

	public Libro(Integer cod, String nombre, String autor) {
		this.cod = cod;
		this.nombre = nombre;
		this.autor = autor;
		this.disponible = true;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Integer getCod() {
		return cod;
	}

	public String getNombre() {
		return nombre;
	}

	public String getAutor() {
		return autor;
	}

}
