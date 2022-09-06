package ar.unlam.edu.pb2;

public class Usuario {
	
	private Integer numeroDeUsuario;
	private String apellido;
	private Double sueldo;
	private TipoDeEmpleado tipoDeEmpleado;
	
	public Usuario(Integer numeroDeUsuario, String apellido, TipoDeEmpleado puestoLaboral, Double sueldo) {
		// TODO Auto-generated constructor stub
		this.numeroDeUsuario = numeroDeUsuario;
		this.apellido = apellido;
		this.tipoDeEmpleado = puestoLaboral;
		this.sueldo = sueldo;
	}

	public Integer getNumeroDeUsuario() {
		return numeroDeUsuario;
	}

	public void setNumeroDeUsuario(Integer numeroDeUsuario) {
		this.numeroDeUsuario = numeroDeUsuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public TipoDeEmpleado getTipoDeEmpleado() {
		return tipoDeEmpleado;
	}

	public void setTipoDeEmpleado(TipoDeEmpleado tipoDeEmpleado) {
		this.tipoDeEmpleado = tipoDeEmpleado;
	}

	
}
