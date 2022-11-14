package ar.unlam.edu.pb2;

import java.util.ArrayList;
import java.util.List;

public class Central {

	private String nombreCentral;
	private List<Alarma> listaDeAlarmas;
	private List<Usuario> listaDeUsuarios;
	
	public Central(String nombreCentral) {
		// TODO Auto-generated constructor stub
		this.nombreCentral = nombreCentral;
		this.listaDeAlarmas = new ArrayList<>();
		this.listaDeUsuarios = new ArrayList<>();
	}

	public String getNombreCentral() {
		return nombreCentral;
	}

	public void setNombreCentral(String nombreCentral) {
		this.nombreCentral = nombreCentral;
	}

	public List<Alarma> getListaDeAlarmas() {
		return this.listaDeAlarmas;
	}
	
	public Integer obtenerCantidadDeAlarmasRegistradas (){
		return this.listaDeAlarmas.size();
	}

	public List<Usuario> getListaDeUsuarios() {
		// TODO Auto-generated method stub
		return this.listaDeUsuarios;
	}

	public Alarma buscarAlarmaPorId(Integer idAlarma) throws LaAlarmaNoSeEncuentraAgregadaEnLaCentralException {
		// TODO Auto-generated method stub
		for(Alarma recorridoListaAlarmas : this.listaDeAlarmas) {
			if(recorridoListaAlarmas.getIdAlarma().equals(idAlarma)) {
				return recorridoListaAlarmas;
			}
		}
		throw new LaAlarmaNoSeEncuentraAgregadaEnLaCentralException(
				"La alarma que buscas no se encuentra registrada en la central");
	}

	public Usuario buscarUsuarioPorDni(Integer dniUsuarioAgregado) throws ElUsuarioNoSeEncuentraAgregadoEnLaCentralException {
		// TODO Auto-generated method stub
		for(Usuario recorridoListaUsuarios: this.listaDeUsuarios) {
			if(recorridoListaUsuarios.getDniUsuario().equals(dniUsuarioAgregado)) {
				return recorridoListaUsuarios;
			}
		}
		throw new ElUsuarioNoSeEncuentraAgregadoEnLaCentralException(
				"El usuario que buscas no se encuentra registrado en la central");
	}

	public void corroborarSiElUsuarioEsPermitido(Usuario administrador, Usuario usuarioEncontrado) throws EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException {
		// TODO Auto-generated method stub
		if(!(administrador instanceof Usuario) | !(usuarioEncontrado instanceof Usuario)) {
			throw new EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException("No posees los permisos necesarios para agregar sensores");
		}
	}

}
