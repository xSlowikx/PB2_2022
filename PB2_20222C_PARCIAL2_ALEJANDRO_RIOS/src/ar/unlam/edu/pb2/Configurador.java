package ar.unlam.edu.pb2;

public class Configurador extends Usuario implements Configurable{

	public Configurador(Integer dniUsuario, String nombreUsuario) {
		super(dniUsuario, nombreUsuario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agregarUsuarioAUnaAlarma(Integer dniUsuarioAgregado, Integer idAlarma, String codConfiguracionAlarma,
			Central centralOperante) throws ElUsuarioNoSeEncuentraAgregadoEnLaCentralException,
			LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, CodigoAlarmaIncorrectoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarSensorAUnaAlarma(Integer idAlarma, String codConfiguracionAlarma, Sensor sensorRecibido,
			Central centralOperante) throws LaAlarmaNoSeEncuentraAgregadaEnLaCentralException,
			ElUsuarioNoSeEncuentraAgregadoEnLaCentralException, CodigoAlarmaIncorrectoException,
			EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException, SensorDuplicadoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activarSensorDeUnaAlarma(Integer numeroSensor, Integer idAlarma, String codConfiguracionAlarma,
			Central centralOperante) throws LaAlarmaYaSeEncuentraActivadaException,
			LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, ElUsuarioNoSeEncuentraAgregadoEnLaCentralException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarAccionALaListaDeAccionesDeLaAlarma(Integer idAlarma, Central centralOperante) {
		// TODO Auto-generated method stub
		
	}
}
