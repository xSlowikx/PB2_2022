package tp;

import java.io.Serializable;
import java.util.HashSet;

public class Persona implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Integer dni;
	private HashSet<Materia> materias;
	
	public Persona() {}
	
	public Persona(String nombre, Integer dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.materias = new HashSet<>();
	}


	public HashSet<Materia> getMaterias() {
		return materias;
	}


	public String getNombre() {
		return nombre;
	}


	public Integer getDni() {
		return dni;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setMaterias(HashSet<Materia> materias) {
		this.materias = materias;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setDni(Integer dni) {
		this.dni = dni;
	}


	public void agregarMateria(Materia materia) {
		this.materias.add(materia);
		
	}


	public void agregarTemaAMateria(Tema tema, Materia mat) {
		mat.getListaTemas().add(tema);
	}

	@Override
	public String toString() {
		return "Persona [materias=" + materias + ", nombre=" + nombre + ", dni=" + dni + "]";
	}
	
}
