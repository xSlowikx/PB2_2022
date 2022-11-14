package ar.unlam.edu.pb2;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Empleado implements Serializable, Comparable<Empleado>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigoEmpleado;
	private String nombreEmpleado;
	private Area areaEstablecida;
	private LocalDate fechaDeRegistro;

	public Empleado(Integer codigoEmpleado, String nombreEmpleado, Area areaEstablecida, LocalDate fechaDeRegistro) {
		// TODO Auto-generated constructor stub
		this.codigoEmpleado = codigoEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.areaEstablecida = areaEstablecida;
		this.fechaDeRegistro = fechaDeRegistro;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (codigoEmpleado == null) {
			if (other.codigoEmpleado != null)
				return false;
		} else if (!codigoEmpleado.equals(other.codigoEmpleado))
			return false;
		if (nombreEmpleado == null) {
			if (other.nombreEmpleado != null)
				return false;
		} else if (!nombreEmpleado.equals(other.nombreEmpleado))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoEmpleado == null) ? 0 : codigoEmpleado.hashCode());
		result = prime * result + ((nombreEmpleado == null) ? 0 : nombreEmpleado.hashCode());
		return result;
	}

	@Override
	public int compareTo(Empleado o) {
		// TODO Auto-generated method stub
		return this.getCodigoEmpleado().compareTo(o.getCodigoEmpleado());
	}

}
