package ar.unlam.edu.pb2;

import java.time.LocalDate;

public class Configurador extends Usuario implements Configurable{

	public Configurador(Integer dniUsuario, String nombreUsuario) {
		super(dniUsuario, nombreUsuario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agregarUsuarioAUnaAlarma(Integer dniUsuarioAgregado, Integer idAlarma, String codConfiguracionAlarma,
			Central centralOperante) throws ElUsuarioNoSeEncuentraAgregadoEnLaCentralException,
			LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, CodigoAlarmaIncorrectoException, ElUsuarioYaSeEncuentraValidadoEnLaAlarmaException {
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = centralOperante.buscarUsuarioPorDni(dniUsuarioAgregado);
		Alarma alarmaEncontrada = centralOperante.buscarAlarmaPorId(idAlarma);
		corroborarCodigoConfiguracion(codConfiguracionAlarma,alarmaEncontrada);
		alarmaEncontrada.agregarUsuario(usuarioEncontrado);
		
		Accion nuevaAccionRealizada = new Accion (1,alarmaEncontrada,usuarioEncontrado,LocalDate.of(2022, 11, 15), AccionRealizada.CONFIGURACION);
		alarmaEncontrada.getListaDeAccionesRealizadas().add(nuevaAccionRealizada);
	}

	@Override
	public void agregarSensorAUnaAlarma(Integer idAlarma, String codConfiguracionAlarma, Sensor sensorRecibido,
			Central centralOperante) throws LaAlarmaNoSeEncuentraAgregadaEnLaCentralException,
			ElUsuarioNoSeEncuentraAgregadoEnLaCentralException, CodigoAlarmaIncorrectoException,
			EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException, SensorDuplicadoException {
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = centralOperante.buscarUsuarioPorDni(this.getDniUsuario());
		centralOperante.corroborarSiElUsuarioEsPermitido(usuarioEncontrado);
		Alarma alarmaEncontrada = centralOperante.buscarAlarmaPorId(idAlarma);
		corroborarCodigoConfiguracion(codConfiguracionAlarma, alarmaEncontrada);
		alarmaEncontrada.agregarSensor(sensorRecibido);	
		Accion nuevaAccionRealizada = new Accion (3,alarmaEncontrada,usuarioEncontrado,LocalDate.of(2022, 11, 15), AccionRealizada.CONFIGURACION);
		alarmaEncontrada.getListaDeAccionesRealizadas().add(nuevaAccionRealizada);
		
	}

	@Override
	public Boolean activarSensorDeUnaAlarma(Integer numeroSensor, Integer idAlarma, String codConfiguracionAlarma,
			Central centralOperante) throws LaAlarmaYaSeEncuentraActivadaException,
			LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, ElUsuarioNoSeEncuentraAgregadoEnLaCentralException, CodigoAlarmaIncorrectoException, SensorNoEncontradoException {
		// TODO Auto-generated method stub
		Alarma alarmaEncontrada = centralOperante.buscarAlarmaPorId(idAlarma);
		corroborarCodigoConfiguracion(codConfiguracionAlarma, alarmaEncontrada);
		Sensor sensorEncontrado = alarmaEncontrada.buscarSensorPorId(numeroSensor);
		sensorEncontrado.setEstadoSensor(true);
		
		Accion nuevaAccionRealizada = new Accion (4,alarmaEncontrada,this,LocalDate.of(2022, 11, 15), AccionRealizada.CONFIGURACION);
		alarmaEncontrada.getListaDeAccionesRealizadas().add(nuevaAccionRealizada);
		
		return true;
		
	}

	@Override
	public void agregarAccionALaListaDeAccionesDeLaAlarma(Integer idAlarma, Central centralOperante) {
		// TODO Auto-generated method stub
		
	}
	
	private Boolean corroborarCodigoConfiguracion(String codConfiguracionAlarma, Alarma alarmaEncontrada) throws CodigoAlarmaIncorrectoException {
		// TODO Auto-generated method stub
		if(alarmaEncontrada.getCodigoConf().equals(codConfiguracionAlarma)) {
			return true;
		}
		throw new CodigoAlarmaIncorrectoException ("El codigo de configuracion no coincide con el esperado");
	}
	
	
}
