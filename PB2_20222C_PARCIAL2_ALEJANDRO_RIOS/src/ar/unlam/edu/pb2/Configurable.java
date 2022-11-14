package ar.unlam.edu.pb2;

public interface Configurable {

	/*
	 * Los usuarios configuradores podrán:
	 * 
	 * ● Agregar un usuario a la lista de usuarios válidos de una alarma
	 * determinada. Para lograr esta operación de deberá pasar por parámetro: ○ DNI
	 * del usuario a agregar. ○ Identificador de la alarma. ○ Código de
	 * configuración de la alarma. ○ Este método debe lanzar una excepción
	 * CodigoAlarmaIncorrectoException en caso de no coincidir el código de
	 * configuración ingresado con el de la alarma.
	 * 
	 * ● Agregar sensor a una alarma indicando: ○ Identificador de la alarma. ○
	 * Código de configuración de la alarma. ○ Sensor que se agrega a la lista de
	 * sensores. ○ Este método debe lanzar una excepción SensorDuplicadoException en
	 * caso de ya existir un sensor con el mismo identificador.
	 * 
	 * ● Activar un sensor de alarma indicando: ○ Identificador del sensor. ○
	 * Identificador de la alarma . ○ Código de configuración de la alarma.
	 */
	public void agregarUsuarioAUnaAlarma(Integer dniUsuarioAgregado, Integer idAlarma, String codConfiguracionAlarma, Central centralOperante) throws ElUsuarioNoSeEncuentraAgregadoEnLaCentralException, LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, CodigoAlarmaIncorrectoException;
	
	public void agregarSensorAUnaAlarma(Integer idAlarma, String codConfiguracionAlarma, Sensor sensorRecibido, Central centralOperante) throws LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, ElUsuarioNoSeEncuentraAgregadoEnLaCentralException, CodigoAlarmaIncorrectoException, EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException, SensorDuplicadoException;
	
	public void activarSensorDeUnaAlarma(Integer numeroSensor, Integer idAlarma, String codConfiguracionAlarma, Central centralOperante) throws LaAlarmaYaSeEncuentraActivadaException, LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, ElUsuarioNoSeEncuentraAgregadoEnLaCentralException;
	
	public void agregarAccionALaListaDeAccionesDeLaAlarma(Integer idAlarma, Central centralOperante);
}
