package ar.unlam.edu.pb2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alarma {

	private Integer idAlarma;
	private String codigoAd;
	private String codigoConf;
	private String nombreAlarma;
	private Boolean estadoAlarma;
	private List<Usuario> listaDeUsuariosValidos;
	private List<Accion> listaDeAccionesRealizadas;
	private List<Sensor> listaDeSensores;

	public Alarma(Integer idAlarma, String codigoAD, String codigoConf, String nombreAlarma) {
		// TODO Auto-generated constructor stub
		this.idAlarma = idAlarma;
		this.codigoAd = codigoAD;
		this.codigoConf = codigoConf;
		this.nombreAlarma = nombreAlarma;
		this.estadoAlarma = false;
		this.listaDeUsuariosValidos = new ArrayList<>();
		this.listaDeSensores = new ArrayList<>();
		this.listaDeAccionesRealizadas = new ArrayList<>();
	}

	public Boolean getEstadoAlarma() {
		return estadoAlarma;
	}

	public void setEstadoAlarma(Boolean estadoAlarma) {
		this.estadoAlarma = estadoAlarma;
	}

	public Integer getIdAlarma() {
		return idAlarma;
	}

	public void setIdAlarma(Integer idAlarma) {
		this.idAlarma = idAlarma;
	}

	public String getCodigoAd() {
		return codigoAd;
	}

	public void setCodigoAd(String codigoAd) {
		this.codigoAd = codigoAd;
	}

	public String getCodigoConf() {
		return codigoConf;
	}

	public void setCodigoConf(String codigoConf) {
		this.codigoConf = codigoConf;
	}

	public String getNombreAlarma() {
		return nombreAlarma;
	}

	public void setNombreAlarma(String nombreAlarma) {
		this.nombreAlarma = nombreAlarma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoAd, codigoConf, idAlarma, nombreAlarma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alarma other = (Alarma) obj;
		return Objects.equals(codigoAd, other.codigoAd) && Objects.equals(codigoConf, other.codigoConf)
				&& Objects.equals(idAlarma, other.idAlarma) && Objects.equals(nombreAlarma, other.nombreAlarma);
	}

	public Boolean agregarUsuario(Usuario usuarioEncontrado) throws ElUsuarioYaSeEncuentraValidadoEnLaAlarmaException {
		// TODO Auto-generated method stub
		if(listaDeUsuariosValidos.contains(usuarioEncontrado)) {
			throw new ElUsuarioYaSeEncuentraValidadoEnLaAlarmaException ("El usuario que intentas agregar a la alarma ya se encuentra habilitado");
		}
		return this.listaDeUsuariosValidos.add(usuarioEncontrado);

	}

	public List<Usuario> getListaDeUsuariosValidos() {
		return listaDeUsuariosValidos;
	}

	public void setListaDeUsuariosValidos(List<Usuario> listaDeUsuariosValidos) {
		this.listaDeUsuariosValidos = listaDeUsuariosValidos;
	}

	public List<Accion> getListaDeAccionesRealizadas() {
		return listaDeAccionesRealizadas;
	}

	public void setListaDeAccionesRealizadas(List<Accion> listaDeAccionesRealizadas) {
		this.listaDeAccionesRealizadas = listaDeAccionesRealizadas;
	}

	public List<Sensor> getListaDeSensores() {
		return listaDeSensores;
	}

	public void setListaDeSensores(List<Sensor> listaDeSensores) {
		this.listaDeSensores = listaDeSensores;
	}

	public void agregarSensor(Sensor sensorRecibido) throws SensorDuplicadoException {
		// TODO Auto-generated method stub
		if (listaDeSensores.contains(sensorRecibido)) {
			throw new SensorDuplicadoException ("El sensor que estas intentando agregar, ya se encuentra en la lista de sensores de la alarma");
		}
		this.listaDeSensores.add(sensorRecibido);
	}

	public Sensor buscarSensorPorId(Integer idSensor) throws SensorNoEncontradoException {
		// TODO Auto-generated method stub
		for(Sensor recorridoSensores : listaDeSensores) {
			if(recorridoSensores.getNumeroSensor().equals(idSensor)) {
				return recorridoSensores;
			}
		}
		throw new SensorNoEncontradoException ("El id de sensor que estas buscando es inexistente, pruebe nuevamente");
	}

}
