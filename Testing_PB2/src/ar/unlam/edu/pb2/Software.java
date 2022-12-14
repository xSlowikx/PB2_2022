package ar.unlam.edu.pb2;

import java.util.ArrayList;

public class Software {
	private String nombreDelDispositivo;
	private Integer limiteDeUsuariosRegistrables;
	private ArrayList<Usuario> usuarios;
	
	
	public Software() {
		// TODO Auto-generated constructor stub
	}
	
	public Software (String nombreDelDispositivo, Integer limiteDeUsuariosRegistrables) {
		this.nombreDelDispositivo = nombreDelDispositivo;
		this.limiteDeUsuariosRegistrables = limiteDeUsuariosRegistrables;
		this.usuarios = new ArrayList<>();
	}

	

	public void registrarUnUsuario(Integer numeroDeUsuario, String apellido, TipoDeEmpleado puestoLaboral, Double sueldo) {
		Usuario nuevoUsuario = new Usuario (numeroDeUsuario, apellido, puestoLaboral, sueldo);
		this.usuarios.add(nuevoUsuario);
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void registrarIngresoUsuario(Integer numeroUsuario, Integer dia, Integer mes) {
		for(Usuario recorridoUsuario: this.usuarios) {
			if( (recorridoUsuario.getNumeroDeUsuario().equals(numeroUsuario))) {
				System.out.println("El usuario existe, procediendo a continuar el ingreso...");
			}
		}
	}
}
