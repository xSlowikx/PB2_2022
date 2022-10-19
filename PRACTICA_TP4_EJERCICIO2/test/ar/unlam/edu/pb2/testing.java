package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class testing {

	@Test
	public void queSePuedaCrearElReloj() {
		Reloj nuevoReloj = new Reloj("Xiaomi Mi Band 7");
		assertNotNull(nuevoReloj);
	}

}
