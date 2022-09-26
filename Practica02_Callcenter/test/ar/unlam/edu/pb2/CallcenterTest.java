package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CallcenterTest {

	@Test
	public void queSePuedaCrearElSoftware() {
		Software nuevoSoftware = new Software("Oeste Cable Color");
		assertNotNull(nuevoSoftware);
	}
	
	@Test
	public void queSePuedaCrearUnaListaDeContactos() {
		Software nuevoSoftware = new Software("Oeste Cable Color");
		Contacto nuevoContacto = new Contacto();
		nuevoSoftware.agregarContacto(nuevoContacto);
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevoSoftware.obtenerCantidadDeContactos();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaCrearUnaListaDeContactosConSusDatos() {
		Software nuevoSoftware = new Software("Oeste Cable Color");
		Contacto nuevoContacto = new Contacto("Alejandro Rios","+540111536682034","aletogu00@gmail.com","Lafayette 2793","1755","Rafael Castillo",ProvinciaSeleccionada.BUENOS_AIRES);
		Contacto nuevoContacto2 = new Contacto("Roberto Rios","+540111536495034","pedroasd@gmail.com","Atlantida 6493","1755","Rafael Castillo",ProvinciaSeleccionada.MENDOZA);
		Contacto nuevoContacto3 = new Contacto("Pedro Rios","+540111536613254","dsaafa@gmail.com","Lafayette 6653","1755","Rafael Castillo",ProvinciaSeleccionada.CHACO);
		Contacto nuevoContacto4 = new Contacto("Jose Rios","+540111536683145","321212@gmail.com","Tokio 2768","1755","Rafael Castillo",ProvinciaSeleccionada.SANTIAGO_DEL_ESTERO);
		Contacto nuevoContacto5 = new Contacto("Hernesto Rios","+540111569742034","66645@gmail.com","Luis Vernet 6658","1755","Rafael Castillo",ProvinciaSeleccionada.TUCUMAN);
		nuevoSoftware.agregarContacto(nuevoContacto);
		nuevoSoftware.agregarContacto(nuevoContacto2);
		nuevoSoftware.agregarContacto(nuevoContacto3);
		nuevoSoftware.agregarContacto(nuevoContacto4);
		nuevoSoftware.agregarContacto(nuevoContacto5);
		Integer valorEsperado = 5;
		Integer valorObtenido = nuevoSoftware.obtenerCantidadDeContactos();
		assertEquals(valorEsperado,valorObtenido);

}
	
	@Test
	public void queSePuedaRealizarUnaLlamadaConExito() {
		Software nuevoSoftware = new Software("Oeste Cable Color");
		Contacto nuevoContacto = new Contacto("Alejandro Rios","+540111536682034","aletogu00@gmail.com","Lafayette 2793","1755","Rafael Castillo",ProvinciaSeleccionada.BUENOS_AIRES);
		Contacto nuevoContacto2 = new Contacto("Roberto Rios","+540111536495034","pedroasd@gmail.com","Atlantida 6493","1755","Rafael Castillo",ProvinciaSeleccionada.MENDOZA);
		Contacto nuevoContacto3 = new Contacto("Pedro Rios","+540111536613254","dsaafa@gmail.com","Lafayette 6653","1755","Rafael Castillo",ProvinciaSeleccionada.CHACO);
		Contacto nuevoContacto4 = new Contacto("Jose Rios","+540111536683145","321212@gmail.com","Tokio 2768","1755","Rafael Castillo",ProvinciaSeleccionada.SANTIAGO_DEL_ESTERO);
		Contacto nuevoContacto5 = new Contacto("Hernesto Rios","+540111569742034","66645@gmail.com","Luis Vernet 6658","1755","Rafael Castillo",ProvinciaSeleccionada.TUCUMAN);
		nuevoSoftware.agregarContacto(nuevoContacto);
		nuevoSoftware.agregarContacto(nuevoContacto2);
		nuevoSoftware.agregarContacto(nuevoContacto3);
		nuevoSoftware.agregarContacto(nuevoContacto4);
		nuevoSoftware.agregarContacto(nuevoContacto5);
		Boolean valorEsperado = true;
		Boolean valorObtenido = nuevoSoftware.realizarNuevaLlamada();
		assertEquals(valorEsperado, valorObtenido);
//		Integer valorEsperado = 5;
//		Integer valorObtenido = nuevoSoftware.obtenerCantidadDeContactos();
//		assertEquals(valorEsperado,valorObtenido);
	}		
		
		@Test
		public void queSePuedaRealizarUnaLlamadaSinExito() {
			Software nuevoSoftware = new Software("Oeste Cable Color");
			Contacto nuevoContacto = new Contacto("Alejandro Rios","+540111536682034","aletogu00@gmail.com","Lafayette 2793","1755","Rafael Castillo",ProvinciaSeleccionada.BUENOS_AIRES);
			Contacto nuevoContacto2 = new Contacto("Roberto Rios","+540111536495034","pedroasd@gmail.com","Atlantida 6493","1755","Rafael Castillo",ProvinciaSeleccionada.MENDOZA);
			Contacto nuevoContacto3 = new Contacto("Pedro Rios","+540111536613254","dsaafa@gmail.com","Lafayette 6653","1755","Rafael Castillo",ProvinciaSeleccionada.CHACO);
			Contacto nuevoContacto4 = new Contacto("Jose Rios","+540111536683145","321212@gmail.com","Tokio 2768","1755","Rafael Castillo",ProvinciaSeleccionada.SANTIAGO_DEL_ESTERO);
			Contacto nuevoContacto5 = new Contacto("Hernesto Rios","+540111569742034","66645@gmail.com","Luis Vernet 6658","1755","Rafael Castillo",ProvinciaSeleccionada.TUCUMAN);
			nuevoSoftware.agregarContacto(nuevoContacto);
			nuevoSoftware.agregarContacto(nuevoContacto2);
			nuevoSoftware.agregarContacto(nuevoContacto3);
			nuevoSoftware.agregarContacto(nuevoContacto4);
			nuevoSoftware.agregarContacto(nuevoContacto5);
			Boolean valorEsperado = false;
			Boolean valorObtenido = nuevoSoftware.realizarNuevaLlamadaSinExito();
			assertEquals(valorEsperado, valorObtenido);
}
		
		@Test
		public void queSePuedanRealizarVariasLlamadasConExito() {
			Software nuevoSoftware = new Software("Oeste Cable Color");
			Contacto nuevoContacto = new Contacto("Alejandro Rios","+540111536682034","aletogu00@gmail.com","Lafayette 2793","1755","Rafael Castillo",ProvinciaSeleccionada.BUENOS_AIRES);
			Contacto nuevoContacto2 = new Contacto("Roberto Rios","+540111536495034","pedroasd@gmail.com","Atlantida 6493","1755","Rafael Castillo",ProvinciaSeleccionada.MENDOZA);
			Contacto nuevoContacto3 = new Contacto("Pedro Rios","+540111536613254","dsaafa@gmail.com","Lafayette 6653","1755","Rafael Castillo",ProvinciaSeleccionada.CHACO);
			Contacto nuevoContacto4 = new Contacto("Jose Rios","+540111536683145","321212@gmail.com","Tokio 2768","1755","Rafael Castillo",ProvinciaSeleccionada.SANTIAGO_DEL_ESTERO);
			Contacto nuevoContacto5 = new Contacto("Hernesto Rios","+540111569742034","66645@gmail.com","Luis Vernet 6658","1755","Rafael Castillo",ProvinciaSeleccionada.TUCUMAN);
			nuevoSoftware.agregarContacto(nuevoContacto);
			nuevoSoftware.agregarContacto(nuevoContacto2);
			nuevoSoftware.agregarContacto(nuevoContacto3);
			nuevoSoftware.agregarContacto(nuevoContacto4);
			nuevoSoftware.agregarContacto(nuevoContacto5);
			Boolean valorEsperado = true;
			Boolean valorObtenido = nuevoSoftware.realizarNuevaLlamada();
			assertEquals(valorEsperado, valorObtenido);
			valorEsperado = true;
			valorObtenido = nuevoSoftware.realizarNuevaLlamada();
			assertEquals(valorEsperado, valorObtenido);
			valorEsperado = true;
			valorObtenido = nuevoSoftware.realizarNuevaLlamada();
			assertEquals(valorEsperado, valorObtenido);
//			Integer valorEsperado = 5;
//			Integer valorObtenido = nuevoSoftware.obtenerCantidadDeContactos();
//			assertEquals(valorEsperado,valorObtenido);
		}	
}
