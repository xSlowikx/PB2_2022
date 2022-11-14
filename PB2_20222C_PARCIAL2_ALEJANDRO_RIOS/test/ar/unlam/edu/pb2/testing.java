package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class testing {

	@Test
	public void testQueSePuedaRegistrarUnaAlarmaEnLaCentral() {
		Central centralOperante = new Central("Monitor");
		Usuario nuevoAdministrador = new Administrador(41823462, "Jorge");
		Alarma alarmaDeHumo = new Alarma(1, "1234", "9999", "Detector de Humo X25");
		((Administrador) nuevoAdministrador).registrarAlarma(alarmaDeHumo, centralOperante);
		Integer valorEsperado = 1;
		Integer valorObtenido = centralOperante.obtenerCantidadDeAlarmasRegistradas();
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void testQueSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma() {

		Central centralOperante = new Central("Monitor");
		Usuario nuevoAdministrador = new Administrador(41823462, "Jorge");
		Alarma alarmaDeHumo = new Alarma(1, "1234", "9999", "Detector de Humo X25");
		Usuario nuevoConfigurador = new Configurador(55548879, "Hernesto");

		((Administrador) nuevoAdministrador).agregarUsuarioEnLaCentral(nuevoConfigurador, centralOperante);
		;
		((Administrador) nuevoAdministrador).registrarAlarma(alarmaDeHumo, centralOperante);

		try {
			((Administrador) nuevoAdministrador).agregarUsuarioAUnaAlarma(55548879, 1, "9999", centralOperante);
		} catch (ElUsuarioNoSeEncuentraAgregadoEnLaCentralException | LaAlarmaNoSeEncuentraAgregadaEnLaCentralException
				| CodigoAlarmaIncorrectoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Integer valorEsperado = 1;
		Integer valorObtenido = null;
		try {
			valorObtenido = centralOperante.buscarAlarmaPorId(1).getListaDeUsuariosValidos().size();
		} catch (LaAlarmaNoSeEncuentraAgregadaEnLaCentralException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test(expected = CodigoAlarmaIncorrectoException.class)
	public void testQueAlAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceCodigoAlarmaIncorrectoException()
			throws CodigoAlarmaIncorrectoException {
		Central centralOperante = new Central("Monitor");
		Usuario nuevoAdministrador = new Administrador(41823462, "Jorge");
		Alarma alarmaDeHumo = new Alarma(1, "1234", "9999", "Detector de Humo X25");
		Usuario nuevoConfigurador = new Configurador(55548879, "Hernesto");

		((Administrador) nuevoAdministrador).agregarUsuarioEnLaCentral(nuevoConfigurador, centralOperante);
		;
		((Administrador) nuevoAdministrador).registrarAlarma(alarmaDeHumo, centralOperante);

		try {
			((Administrador) nuevoAdministrador).agregarUsuarioAUnaAlarma(55548879, 1, "123555", centralOperante);
		} catch (ElUsuarioNoSeEncuentraAgregadoEnLaCentralException
				| LaAlarmaNoSeEncuentraAgregadaEnLaCentralException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Integer valorEsperado = 0;
		Integer valorObtenido = null;
		try {
			valorObtenido = centralOperante.buscarAlarmaPorId(1).getListaDeUsuariosValidos().size();
		} catch (LaAlarmaNoSeEncuentraAgregadaEnLaCentralException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test(expected = SensorDuplicadoException.class)
	public void testQueAlAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceSensorDuplicadoException()
			throws SensorDuplicadoException {

		Central centralOperante = new Central("Monitor");
		Usuario nuevoAdministrador = new Administrador(41823462, "Jorge");
		Alarma alarmaDeHumo = new Alarma(1, "1234", "9999", "Detector de Humo X25");
		Usuario nuevoConfigurador = new Configurador(55548879, "Hernesto");
		Sensor sensorTemperatura = new Sensor(1);
//		Sensor sensorTemperatura2 = new Sensor(1,false);

		((Administrador) nuevoAdministrador).agregarUsuarioEnLaCentral(nuevoConfigurador, centralOperante);
		;
		((Administrador) nuevoAdministrador).registrarAlarma(alarmaDeHumo, centralOperante);

		try {
			((Administrador) nuevoAdministrador).agregarSensorAUnaAlarma(1, "9999", sensorTemperatura, 55548879,
					centralOperante);
		} catch (LaAlarmaNoSeEncuentraAgregadaEnLaCentralException | ElUsuarioNoSeEncuentraAgregadoEnLaCentralException
				| CodigoAlarmaIncorrectoException
				| EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			((Administrador) nuevoAdministrador).agregarSensorAUnaAlarma(1, "9999", sensorTemperatura, 55548879,
					centralOperante);
		} catch (LaAlarmaNoSeEncuentraAgregadaEnLaCentralException | ElUsuarioNoSeEncuentraAgregadoEnLaCentralException
				| CodigoAlarmaIncorrectoException
				| EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Test(expected = HayAlmenosUnoDeLosSensoresApagadosException.class)
	public void testQueNoSePuedaActivarUnaAlarmaSiHayAlmenosUnSensorDesactivado() throws HayAlmenosUnoDeLosSensoresApagadosException {
		Central centralOperante = new Central("Monitor");
		Usuario nuevoAdministrador = new Administrador(41823462, "Jorge");
		Alarma alarmaDeHumo = new Alarma(1, "1234", "9999", "Detector de Humo X25");
		Usuario nuevoConfigurador = new Configurador(55548879, "Hernesto");
		Sensor sensorTemperatura = new Sensor (1);
		Sensor sensorHumedad = new Sensor (2);
		
		((Administrador) nuevoAdministrador).agregarUsuarioEnLaCentral(nuevoConfigurador, centralOperante);
		;
		((Administrador) nuevoAdministrador).registrarAlarma(alarmaDeHumo, centralOperante);
		
		try {
			((Administrador)nuevoAdministrador).agregarSensorAUnaAlarma(1,"9999",sensorTemperatura,55548879,centralOperante);
		} catch (LaAlarmaNoSeEncuentraAgregadaEnLaCentralException | ElUsuarioNoSeEncuentraAgregadoEnLaCentralException
				| CodigoAlarmaIncorrectoException | EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException | SensorDuplicadoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			((Administrador)nuevoAdministrador).agregarSensorAUnaAlarma(1,"9999",sensorHumedad,55548879,centralOperante);
		} catch (LaAlarmaNoSeEncuentraAgregadaEnLaCentralException | ElUsuarioNoSeEncuentraAgregadoEnLaCentralException
				| CodigoAlarmaIncorrectoException | EsteUsuarioNoTieneLosPermisosNecesariosParaAgregarUnSensorException | SensorDuplicadoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			((Administrador)nuevoAdministrador).activarDesactivarAlarma(1,"1234",nuevoConfigurador,centralOperante);
		} catch (LaAlarmaNoSeEncuentraAgregadaEnLaCentralException | CodigoActivacionAlarmaIncorrectoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
