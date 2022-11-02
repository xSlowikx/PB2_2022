package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class testing {

	@Test
	public void testQueExistaElEjercito() {
		Ejercito nuevoEjercito = new Ejercito(Pais.RUSIA);
		assertNotNull(nuevoEjercito);
	}
	
//	@Test
//	public void testQueExistaUnVehiculo () {
//		Vehiculo nuevoVehiculo = new Vehiculo("T34");
//		assertNotNull(nuevoVehiculo);
//	}
//	
	@Test
	public void testQueSePuedaAgregarUnVehiculoAlEjercito () {
		Ejercito nuevoEjercito = new Ejercito(Pais.RUSIA);
		Vehiculo nuevoVehiculo = new Tanque("T34");
		try {
			nuevoEjercito.agregarVehiculo(1, nuevoVehiculo);
		} catch (VehiculoYaExistenteEnElConvoyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevoEjercito.getListaDeVehiculos().size();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void testQueSeCreeUnConvoyDeCincoVehiculosEnElEjercito() {
		Ejercito nuevoEjercito = new Ejercito(Pais.RUSIA);
		Vehiculo nuevoTanqueMediano = new Tanque("T34");
		Vehiculo nuevoTanquePesado = new Tanque("IS-2");
		Vehiculo nuevoAvion = new Avion ("IL-2");
		Vehiculo nuevoLanzamisiles = new Tanque ("Katiusha");
		Vehiculo nuevoCazatanques = new Tanque ("ISU-152");
		try {
			nuevoEjercito.agregarVehiculo(1,nuevoTanqueMediano);
		} catch (VehiculoYaExistenteEnElConvoyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoEjercito.agregarVehiculo(2,nuevoTanquePesado);
		} catch (VehiculoYaExistenteEnElConvoyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoEjercito.agregarVehiculo(3,nuevoAvion);
		} catch (VehiculoYaExistenteEnElConvoyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoEjercito.agregarVehiculo(4,nuevoLanzamisiles);
		} catch (VehiculoYaExistenteEnElConvoyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoEjercito.agregarVehiculo(5,nuevoCazatanques);
		} catch (VehiculoYaExistenteEnElConvoyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Integer valorEsperado = 5;
		Integer valorObtenido = nuevoEjercito.getListaDeVehiculos().size();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void testQueExistaUnaBatalla () {
		Batalla nuevaBatalla = new Batalla ("Kursk");
		assertNotNull(nuevaBatalla);
	}
	
	@Test
	public void testQueSePuedanAgregarPaisesBeligerantesAUnaBatalla () {
		Batalla nuevaBatalla = new Batalla ("Kursk");
		Ejercito ejercitoDefensor = new Ejercito (Pais.RUSIA);
		Ejercito ejercitoAtacante = new Ejercito (Pais.ALEMANIA);
		try {
			nuevaBatalla.agregarDefensor(1,ejercitoDefensor);
		} catch (EjercitoYaAsignadoALaDefensaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevaBatalla.agregarAtacante(1,ejercitoAtacante);
		} catch (EjercitoYaAsignadoAlAtaqueException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevaBatalla.getEjercitosDefensores().size();
		assertEquals(valorEsperado,valorObtenido);
		Integer valorEsperado2 = 1;
		Integer valorObtenido2 = nuevaBatalla.getEjercitosAtacantes().size();
		assertEquals(valorEsperado2,valorObtenido2);
	}
	
	
	@Test
	public void testQueSePuedaCrearUnVehiculoDeTipoTanque() {
		Ejercito nuevoEjercito = new Ejercito (Pais.RUSIA);
		Vehiculo nuevoTanque = new Tanque ("T34");
		assertNotNull(nuevoTanque);
	}
	
	@Test
	public void testQueSePuedaCrearUnVehiculoDeTipoAvion() {
		Ejercito nuevoEjercito = new Ejercito (Pais.RUSIA);
		Vehiculo nuevoAvion = new Avion ("IL-2");
		assertNotNull(nuevoAvion);
	}
	
	@Test
	public void testQueSePuedaCrearUnVehiculoDeTipoLancha() {
		Ejercito nuevoEjercito = new Ejercito (Pais.RUSIA);
		Vehiculo nuevaLancha = new Lancha ("Lanchita");
		assertNotNull(nuevaLancha);
	}
	
	@Test
	public void testQueSePuedaEnviarUnVehiculoALaBatalla () {
		Ejercito nuevoEjercito = new Ejercito (Pais.RUSIA);
		Vehiculo nuevoTanque = new Tanque ("T34");
		try {
			nuevoEjercito.agregarVehiculo(1,nuevoTanque);
		} catch (VehiculoYaExistenteEnElConvoyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Batalla nuevaBatalla = new Batalla ("Kursk",TipoDeBatalla.TERRESTRE);
		try {
			nuevaBatalla.agregarDefensor(1,nuevoEjercito);
		} catch (EjercitoYaAsignadoALaDefensaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoEjercito.enviarVehiculoALaBatalla(1,nuevaBatalla);
		} catch (VehiculoNoEncontradoException | TerrenoNoCompatibleConElVehiculoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevoEjercito.getVehiculosEnCombate().size();
		assertEquals(valorEsperado,valorObtenido);
		
	}
	
	@Test
	public void testQueExistanTiposDeBatalla() {
		Batalla nuevaBatalla = new Batalla ("Kursk",TipoDeBatalla.TERRESTRE);
		System.out.println(nuevaBatalla.getTipoDeBatalla());
	}
	
	@Test
	public void testQueNoCoincidaElVehiculoYTipoDeBatalla() {
		Ejercito nuevoEjercito = new Ejercito (Pais.RUSIA);
		Vehiculo nuevoAvion = new Avion ("IL-2");
		try {
			nuevoEjercito.agregarVehiculo(1,nuevoAvion);
		} catch (VehiculoYaExistenteEnElConvoyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Batalla nuevaBatalla = new Batalla ("Kursk",TipoDeBatalla.TERRESTRE);
		try {
			nuevaBatalla.agregarDefensor(1,nuevoEjercito);
		} catch (EjercitoYaAsignadoALaDefensaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoEjercito.enviarVehiculoALaBatalla(1,nuevaBatalla);
		} catch (VehiculoNoEncontradoException | TerrenoNoCompatibleConElVehiculoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Integer valorEsperado = 0;
		Integer valorObtenido = nuevoEjercito.getVehiculosEnCombate().size();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void testQueSePuedaCrearUnAnfibioYEnviarloAUnaBatallaAcuatica() {
		Ejercito nuevoEjercito = new Ejercito (Pais.RUSIA);
		Vehiculo nuevoAnfibio = new Anfibio ("T-40");
		try {
			nuevoEjercito.agregarVehiculo(1,nuevoAnfibio);
		} catch (VehiculoYaExistenteEnElConvoyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Batalla nuevaBatalla = new Batalla ("Balaton",TipoDeBatalla.ACUATICO);
		try {
			nuevaBatalla.agregarDefensor(1,nuevoEjercito);
		} catch (EjercitoYaAsignadoALaDefensaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoEjercito.enviarVehiculoALaBatalla(1,nuevaBatalla);
		} catch (VehiculoNoEncontradoException | TerrenoNoCompatibleConElVehiculoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevoEjercito.getVehiculosEnCombate().size();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	
}
