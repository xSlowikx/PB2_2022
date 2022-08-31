package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

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
	}

}
