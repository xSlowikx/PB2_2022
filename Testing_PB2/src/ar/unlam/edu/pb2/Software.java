package ar.unlam.edu.pb2;

public class Software {
	private String nombreDelDispositivo;
	private Integer limiteDeUsuariosRegistrables;
	
	public Software() {
		// TODO Auto-generated constructor stub
	}
	
	public Software (String nombreDelDispositivo, Integer limiteDeUsuariosRegistrables) {
		this.nombreDelDispositivo = nombreDelDispositivo;
		this.limiteDeUsuariosRegistrables = limiteDeUsuariosRegistrables;
	}

	

	public void registrarUnUsuario(Integer numeroDeUsuario, String apellido, TipoDeEmpleado puestoLaboral, Double sueldo) {
		Usuario nuevoUsuario = new Usuario (numeroDeUsuario, apellido, puestoLaboral, sueldo);
	}
}
