package ar.unlam.edu.pb2;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Habitante {

	private Integer nroLote;
	private String tipoDoc;
	private Integer numeroDoc;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;

	public Habitante(Integer nroLote, String tipoDoc, Integer numeroDoc, String nombre, String apellido,
			String fechaNacimiento) {
		// TODO Auto-generated constructor stub
		this.nroLote = nroLote;
		this.tipoDoc = tipoDoc;
		this.numeroDoc = numeroDoc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

}
