package ar.unlam.edu.pb2;

import java.time.LocalDate;

public class Activador extends Usuario implements Activable {

	public Activador(Integer dniUsuario, String nombreUsuario) {
		super(dniUsuario, nombreUsuario);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Boolean activarDesactivarAlarma(Alarma alarmaRecibida, String codigoActivacionAlarma, Central centralOperante) throws LaAlarmaNoSeEncuentraAgregadaEnLaCentralException, EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException, CodigoActivacionAlarmaIncorrectoException, HayAlmenosUnoDeLosSensoresApagadosException {
		// TODO Auto-generated method stub
		Alarma alarmaEncontrada = centralOperante.buscarAlarmaPorId(alarmaRecibida.getIdAlarma());
		corroborarCodigoActivacionDesactivacion(codigoActivacionAlarma, alarmaEncontrada);
		centralOperante.corroborarSiElUsuarioEsPermitido(this);
		corroborarQueTodosLosSensoresEstenEncendidos(alarmaEncontrada);
		alarmaEncontrada.setEstadoAlarma(true);
		
		Accion nuevaAccionRealizada = new Accion (2,alarmaEncontrada,this,LocalDate.of(2022, 11, 15), AccionRealizada.ACTIVACION);
		alarmaEncontrada.getListaDeAccionesRealizadas().add(nuevaAccionRealizada);
		
		return alarmaEncontrada.getEstadoAlarma();
	}

	private Boolean corroborarCodigoActivacionDesactivacion(String codActivacionAlarma, Alarma alarmaEncontrada) throws CodigoActivacionAlarmaIncorrectoException {
		// TODO Auto-generated method stub
		if(alarmaEncontrada.getCodigoAd().equals(codActivacionAlarma)) {
			return true;
		}
		throw new CodigoActivacionAlarmaIncorrectoException ("El codigo de activacion no coincide con el esperado");
	}
	
	private Boolean corroborarQueTodosLosSensoresEstenEncendidos(Alarma alarmaEncontrada) throws HayAlmenosUnoDeLosSensoresApagadosException {
		// TODO Auto-generated method stub
		for(Sensor recorrerSensores: alarmaEncontrada.getListaDeSensores()) {
			if(recorrerSensores.getEstadoSensor().equals(false)) {
				throw new HayAlmenosUnoDeLosSensoresApagadosException("Al corroborar los sensores, encontramos que uno esta apagado, no se puede encender la alarma");
			}
		}
		return true;
	}
}
