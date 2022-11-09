package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class testing {

	@Test
	public void testQueExistaUnEmpleado() {
		Empleado nuevoEmpleado = new Empleado ();
		assertNotNull(nuevoEmpleado);
	}

}
