package ar.unlam.edu.pb2;

import java.util.Objects;

public class Usuario {

	private Integer dniUsuario;
	private String nombreUsuario;

	public Usuario(Integer dniUsuario, String nombreUsuario) {
		// TODO Auto-generated constructor stub
		this.dniUsuario = dniUsuario;
		this.nombreUsuario = nombreUsuario;
	}


	public Integer getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(Integer dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dniUsuario, nombreUsuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dniUsuario, other.dniUsuario) && Objects.equals(nombreUsuario, other.nombreUsuario);
	}

	
}
