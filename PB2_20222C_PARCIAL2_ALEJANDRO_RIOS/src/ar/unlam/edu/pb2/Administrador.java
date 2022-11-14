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

	public Boolean agregarUsuarioEnLaCentral(Usuario usuarioParaAgregar, Central centralDestino) {
		// TODO Auto-generated method stub
		centralDestino.getListaDeUsuarios().add(usuarioParaAgregar);
		return true;
	}

	public void agregarUsuarioAUnaAlarma(Integer dniUsuarioAgregado, Integer idAlarma, String codConfiguracionAlarma, Central centralOperante) throws ElUsuarioNoSeEncuentraAgregadoEnLaCentralException, LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, CodigoAlarmaIncorrectoException {
		// TODO Auto-generated method stub
//		corroborarQueExistaElUsuarioEnLaCentral(dniUsuarioAgregado,centralOperante);
//		corroborarQueExistaLaAlarmaEnLaCentral(idAlarma,centralOperante);
		Alarma alarmaEncontrada = centralOperante.buscarAlarmaPorId(idAlarma);
		Usuario usuarioEncontrado = centralOperante.buscarUsuarioPorDni(dniUsuarioAgregado);
		corroborarCodigo(codConfiguracionAlarma,alarmaEncontrada);
		alarmaEncontrada.agregarUsuario(usuarioEncontrado);
	}

	private void corroborarCodigo(String codConfiguracionAlarma, Alarma alarmaEncontrada) throws CodigoAlarmaIncorrectoException {
		// TODO Auto-generated method stub
		if(!alarmaEncontrada.getCodigoConf().equals(codConfiguracionAlarma)) {
			throw new CodigoAlarmaIncorrectoException ("El codigo de configuracion no coincide con el esperado");
		}
	}

	public void agregarSensorAUnaAlarma(Integer idAlarma, String codConfiguracionAlarma, Sensor sensorRecibido, Integer dniUsuarioConfigurador, Central centralOperante) throws LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, ElUsuarioNoSeEncuentraAgregadoEnLaCentralException, CodigoAlarmaIncorrectoException, EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException, SensorDuplicadoException {
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = centralOperante.buscarUsuarioPorDni(dniUsuarioConfigurador);
		centralOperante.corroborarSiElUsuarioEsPermitido(this,usuarioEncontrado);
		Alarma alarmaEncontrada = centralOperante.buscarAlarmaPorId(idAlarma);
		corroborarCodigo(codConfiguracionAlarma, alarmaEncontrada);
		alarmaEncontrada.agregarSensor(sensorRecibido);	
	}

	public String activarDesactivarAlarma(Integer idAlarma, String codActivacionAlarma, Usuario nuevoConfigurador, Central centralOperante) throws LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, CodigoActivacionAlarmaIncorrectoException, HayAlmenosUnoDeLosSensoresApagadosException {
		// TODO Auto-generated method stub
		Alarma alarmaEncontrada = centralOperante.buscarAlarmaPorId(idAlarma);
		corroborarCodigoActivacionDesactivacion(codActivacionAlarma, alarmaEncontrada);
		corroborarQueTodosLosSensoresEstenEncendidos(alarmaEncontrada);
		return "Alarma activada con exito";
	}

	private void corroborarQueTodosLosSensoresEstenEncendidos(Alarma alarmaEncontrada) throws HayAlmenosUnoDeLosSensoresApagadosException {
		// TODO Auto-generated method stub
		for(Sensor recorrerSensores: alarmaEncontrada.getListaDeSensores()) {
			if(recorrerSensores.getEstadoSensor().equals(false)) {
				throw new HayAlmenosUnoDeLosSensoresApagadosException("Al corroborar los sensores, encontramos que uno esta apagado, no se puede encender la alarma");
			}
		}
	}

	private void corroborarCodigoActivacionDesactivacion(String codActivacionAlarma, Alarma alarmaEncontrada) throws CodigoActivacionAlarmaIncorrectoException {
		// TODO Auto-generated method stub
		if(!alarmaEncontrada.getCodigoAd().equals(codActivacionAlarma)) {
			throw new CodigoActivacionAlarmaIncorrectoException ("El codigo de activacion no coincide con el esperado");
		}
	}

}
