package tp;

import java.io.Serializable;
import java.util.HashSet;

public class Materia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Integer id;
	HashSet <Tema> listaTemas;
	
	public Materia() {}
	public Materia(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.listaTemas = new HashSet<>();
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNombre() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}

	public HashSet<Tema> getListaTemas() {
		return listaTemas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setListaTemas(HashSet<Tema> listaTemas) {
		this.listaTemas = listaTemas;
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", id=" + id + ", listaTemas=" + listaTemas + "]";
	}
	
	
	
}
