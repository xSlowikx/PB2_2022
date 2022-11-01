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
//	@Test
//	public void testQueSePuedaAgregarUnVehiculoAlEjercito () {
//		Ejercito nuevoEjercito = new Ejercito(Pais.RUSIA);
//		Vehiculo nuevoVehiculo = new Vehiculo("T34");
//		nuevoEjercito.agregarVehiculo(nuevoVehiculo);
//		Integer valorEsperado = 1;
//		Integer valorObtenido = nuevoEjercito.getListaDeVehiculos().size();
//		assertEquals(valorEsperado,valorObtenido);
//	}
	
//	@Test
//	public void testQueSeCreeUnConvoyDeCincoVehiculosEnElEjercito() {
//		Ejercito nuevoEjercito = new Ejercito(Pais.RUSIA);
//		Vehiculo nuevoTanqueMediano = new Vehiculo("T34");
//		Vehiculo nuevoTanquePesado = new Vehiculo("IS-2");
//		Vehiculo nuevoAvion = new Vehiculo ("IL-2");
//		Vehiculo nuevoLanzamisiles = new Vehiculo ("Katiusha");
//		Vehiculo nuevoCazatanques = new Vehiculo ("ISU-152");
//		nuevoEjercito.agregarVehiculo(nuevoTanqueMediano);
//		nuevoEjercito.agregarVehiculo(nuevoTanquePesado);
//		nuevoEjercito.agregarVehiculo(nuevoAvion);
//		nuevoEjercito.agregarVehiculo(nuevoLanzamisiles);
//		nuevoEjercito.agregarVehiculo(nuevoCazatanques);
//		Integer valorEsperado = 5;
//		Integer valorObtenido = nuevoEjercito.getListaDeVehiculos().size();
//		assertEquals(valorEsperado,valorObtenido);
//	}
	
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
		nuevaBatalla.agregarDefensor(ejercitoDefensor);
		nuevaBatalla.agregarAtacante(ejercitoAtacante);
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
		Vehiculo nuevoTanque = new Tanque ("T34",1);
		nuevoEjercito.agregarVehiculo(nuevoTanque);
		Batalla nuevaBatalla = new Batalla ("Kursk",TipoDeBatalla.TERRESTRE);
		nuevaBatalla.agregarDefensor(nuevoEjercito);
		try {
			nuevoEjercito.enviarVehiculoALaBatalla(nuevoTanque,nuevaBatalla);
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
		Vehiculo nuevoAvion = new Avion ("IL-2",2);
		nuevoEjercito.agregarVehiculo(nuevoAvion);
		Batalla nuevaBatalla = new Batalla ("Kursk",TipoDeBatalla.TERRESTRE);
		nuevaBatalla.agregarDefensor(nuevoEjercito);
		try {
			nuevoEjercito.enviarVehiculoALaBatalla(nuevoAvion,nuevaBatalla);
		} catch (VehiculoNoEncontradoException | TerrenoNoCompatibleConElVehiculoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Integer valorEsperado = 0;
		Integer valorObtenido = nuevoEjercito.getVehiculosEnCombate().size();
		assertEquals(valorEsperado,valorObtenido);
	}
}
