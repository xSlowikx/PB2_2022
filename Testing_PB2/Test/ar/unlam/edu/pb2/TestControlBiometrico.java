package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestControlBiometrico {

	@Test
	public void queExistaElSoftware() {
		Software nuevoSoftware = new Software ();
		assertNotNull(nuevoSoftware);
	}
	
	@Test
	public void queSeRegistreUnUsuario() {
		Software nuevoSoftware = new Software ("La Matrix",10);
		nuevoSoftware.registrarUnUsuario(1, "Ledesma", TipoDeEmpleado.GERENTE, 25500.00);
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevoSoftware.getUsuarios().size();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSeObtengaUnUsuarioPorNumeroDeUsuario() {
		Software nuevoSoftware = new Software("La Matrix",10);
		nuevoSoftware.registrarUnUsuario(1, "Ledesma",TipoDeEmpleado.GERENTE, 25500.00);
		nuevoSoftware.registrarUnUsuario(2, "Lopez",TipoDeEmpleado.ADMINISTRATIVO, 12500.00);
		nuevoSoftware.registrarUnUsuario(3, "Benitez",TipoDeEmpleado.OPERARIO, 35000.00);
		nuevoSoftware.registrarUnUsuario(4, "Beltran",TipoDeEmpleado.OPERARIO, 75500.00);
		nuevoSoftware.registrarUnUsuario(5, "Gonzalez",TipoDeEmpleado.ADMINISTRATIVO, 45500.00);
		nuevoSoftware.registrarUnUsuario(6, "Benavidez",TipoDeEmpleado.OPERARIO, 55500.00);
		nuevoSoftware.registrarUnUsuario(7, "Shacoscu",TipoDeEmpleado.ADMINISTRATIVO, 95500.00);
		nuevoSoftware.registrarUnUsuario(8, "Martinez",TipoDeEmpleado.OPERARIO, 115500.00);
		nuevoSoftware.registrarUnUsuario(9, "Melchor",TipoDeEmpleado.GERENTE, 225500.00);
		nuevoSoftware.registrarUnUsuario(10, "Garcia",TipoDeEmpleado.ADMINISTRATIVO, 12500.00);
		Integer valorEsperado = 3;
		ArrayList<Usuario> usuarioTest = nuevoSoftware.getUsuarios();
		for (Usuario usuarioRecorrido: usuarioTest) {
			Integer valorObtenido = usuarioRecorrido.getNumeroDeUsuario();
			if(valorEsperado == valorObtenido) {
				System.out.println("El usuario se encuentra en la lista, es: " + usuarioRecorrido.getApellido());
			}
				
			}
	}
	
	@Test
	public void queSeObtengaElUsuarioGerenteDeMayorSueldo() {
		Software nuevoSoftware = new Software("La Matrix",10);
		nuevoSoftware.registrarUnUsuario(1, "Ledesma",TipoDeEmpleado.GERENTE, 25500.00);
		nuevoSoftware.registrarUnUsuario(2, "Lopez",TipoDeEmpleado.ADMINISTRATIVO, 12500.00);
		nuevoSoftware.registrarUnUsuario(3, "Benitez",TipoDeEmpleado.OPERARIO, 35000.00);
		nuevoSoftware.registrarUnUsuario(4, "Beltran",TipoDeEmpleado.OPERARIO, 75500.00);
		nuevoSoftware.registrarUnUsuario(5, "Gonzalez",TipoDeEmpleado.GERENTE, 45500.00);
		nuevoSoftware.registrarUnUsuario(6, "Benavidez",TipoDeEmpleado.OPERARIO, 55500.00);
		nuevoSoftware.registrarUnUsuario(7, "Shacoscu",TipoDeEmpleado.GERENTE, 95500.00);
		nuevoSoftware.registrarUnUsuario(8, "Martinez",TipoDeEmpleado.OPERARIO, 555000.00);
		nuevoSoftware.registrarUnUsuario(9, "Melchor",TipoDeEmpleado.GERENTE, 225500.00);
		nuevoSoftware.registrarUnUsuario(10, "Garcia",TipoDeEmpleado.ADMINISTRATIVO, 12500.00);
		Double valorEsperado = 225500.00;
		ArrayList <Usuario> usuarioTest = nuevoSoftware.getUsuarios();
		Double valorMaximo = 0.00;
		for(Usuario usuarioRecorrido: usuarioTest) {
			Double valorObtenido = usuarioRecorrido.getSueldo();
			if (valorObtenido > valorMaximo && (TipoDeEmpleado.GERENTE.equals(usuarioRecorrido.getTipoDeEmpleado()))) {
				valorMaximo = valorObtenido;
			}
		}
		for(Usuario usuarioRecorrido: usuarioTest) {
			if(Double.compare(valorMaximo, usuarioRecorrido.getSueldo()) == 0) {
				System.out.println("El gerente de mayor sueldo es: " + usuarioRecorrido.getApellido());
			}
		}
		assertEquals(valorEsperado,valorMaximo);
	}

}
