package ar.unlam.edu.pb2;

public interface Activable {

	/*
	 * Activar o desactivar una alarma: ○ public boolean
	 * activarDesactivarAlarma(Alarma alarma, String codigoActivacionAlarma). Cada
	 * operación debe registrar la acción realizada sobre la alarma con tipo
	 * “ACTIVACION” o “DESACTIVACION” según corresponda.
	 */

	public void activarDesactivarAlarma(Alarma alarmaRecibida, String codigoActivacionAlarma, Central centralOperante);
}
