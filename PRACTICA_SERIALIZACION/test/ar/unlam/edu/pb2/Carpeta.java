package ar.unlam.edu.pb2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
public class Carpeta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Empleado> registrosDeEmpleado;
	private Area areaEstablecida;

	public Carpeta(Area areaEstablecida) {
		// TODO Auto-generated constructor stub
		this.areaEstablecida = areaEstablecida;
		this.registrosDeEmpleado = new ArrayList<>();
	}
	
}
