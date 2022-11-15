package ar.unlam.edu.pb2;

public class Administrador extends Usuario {


	public Administrador(Integer dniUsuario, String nombreUsuario) {
		// TODO Auto-generated constructor stub
		super(dniUsuario, nombreUsuario);
	}

	public Boolean registrarAlarma(Alarma alarmaParaRegistrar, Central centralDestino) {
		// TODO Auto-generated method stub
		centralDestino.getListaDeAlarmas().add(alarmaParaRegistrar);
		return true;

	}

	public Boolean agregarUsuarioEnLaCentral(Usuario usuarioParaAgregar, Central centralDestino) throws UsuarioYaExistenteEnLaCentralException {
		// TODO Auto-generated method stub
		if(centralDestino.getListaDeUsuarios().contains(usuarioParaAgregar)) {
			throw new UsuarioYaExistenteEnLaCentralException ("El usuario que intentas agregar ya forma parte del personal");
			
		}
		return centralDestino.getListaDeUsuarios().add(usuarioParaAgregar);
	}

	public void agregarUsuarioAUnaAlarma(Integer dniUsuarioAgregado, Integer idAlarma, String codConfiguracionAlarma, Central centralOperante) throws ElUsuarioNoSeEncuentraAgregadoEnLaCentralException, LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, CodigoAlarmaIncorrectoException, ElUsuarioYaSeEncuentraValidadoEnLaAlarmaException {
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = centralOperante.buscarUsuarioPorDni(dniUsuarioAgregado);
		Alarma alarmaEncontrada = centralOperante.buscarAlarmaPorId(idAlarma);
		corroborarCodigoConfiguracion(codConfiguracionAlarma,alarmaEncontrada);
		alarmaEncontrada.agregarUsuario(usuarioEncontrado);
	}

	private Boolean corroborarCodigoConfiguracion(String codConfiguracionAlarma, Alarma alarmaEncontrada) throws CodigoAlarmaIncorrectoException {
		// TODO Auto-generated method stub
		if(alarmaEncontrada.getCodigoConf().equals(codConfiguracionAlarma)) {
			return true;
		}
		throw new CodigoAlarmaIncorrectoException ("El codigo de configuracion no coincide con el esperado");
	}

	public void agregarSensorAUnaAlarma(Integer idAlarma, String codConfiguracionAlarma, Sensor sensorRecibido, Integer dniUsuarioConfigurador, Central centralOperante) throws LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, ElUsuarioNoSeEncuentraAgregadoEnLaCentralException, CodigoAlarmaIncorrectoException, EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException, SensorDuplicadoException {
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = centralOperante.buscarUsuarioPorDni(dniUsuarioConfigurador);
		centralOperante.corroborarSiElUsuarioEsPermitido(usuarioEncontrado);
		Alarma alarmaEncontrada = centralOperante.buscarAlarmaPorId(idAlarma);
		corroborarCodigoConfiguracion(codConfiguracionAlarma, alarmaEncontrada);
		alarmaEncontrada.agregarSensor(sensorRecibido);	
	}

	public Boolean activarDesactivarAlarma(Integer idAlarma, String codActivacionAlarma, Usuario nuevoConfigurador, Central centralOperante) throws LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, CodigoActivacionAlarmaIncorrectoException, HayAlmenosUnoDeLosSensoresApagadosException, EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException {
		// TODO Auto-generated method stub
		Alarma alarmaEncontrada = centralOperante.buscarAlarmaPorId(idAlarma);
		corroborarCodigoActivacionDesactivacion(codActivacionAlarma, alarmaEncontrada);
		centralOperante.corroborarSiElUsuarioEsPermitido(nuevoConfigurador);
		corroborarQueTodosLosSensoresEstenEncendidos(alarmaEncontrada);
		alarmaEncontrada.setEstadoAlarma(true);
		return alarmaEncontrada.getEstadoAlarma();
		
	}
	
	public Boolean activarSensorAlarma(Integer idSensor, Integer idAlarma, String codigoActivacionAlarma, Central centralOperante) throws CodigoActivacionAlarmaIncorrectoException, LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, SensorNoEncontradoException {
		Alarma alarmaEncontrada = centralOperante.buscarAlarmaPorId(idAlarma);
		corroborarCodigoActivacionDesactivacion(codigoActivacionAlarma, alarmaEncontrada);
		Sensor sensorEncontrado = alarmaEncontrada.buscarSensorPorId(idSensor);
		sensorEncontrado.setEstadoSensor(true);
		return true;
	}

	private void corroborarQueTodosLosSensoresEstenEncendidos(Alarma alarmaEncontrada) throws HayAlmenosUnoDeLosSensoresApagadosException {
		// TODO Auto-generated method stub
		for(Sensor recorrerSensores: alarmaEncontrada.getListaDeSensores()) {
			if(recorrerSensores.getEstadoSensor().equals(false)) {
				throw new HayAlmenosUnoDeLosSensoresApagadosException("Al corroborar los sensores, encontramos que uno esta apagado, no se puede encender la alarma");
			}
		}
	}

	private Boolean corroborarCodigoActivacionDesactivacion(String codActivacionAlarma, Alarma alarmaEncontrada) throws CodigoActivacionAlarmaIncorrectoException {
		// TODO Auto-generated method stub
		if(alarmaEncontrada.getCodigoAd().equals(codActivacionAlarma)) {
			return true;
		}
		throw new CodigoActivacionAlarmaIncorrectoException ("El codigo de activacion no coincide con el esperado");
	}

}
