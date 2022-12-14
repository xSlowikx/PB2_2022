package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCerradura {

	@Test
	public void queExistaLaCerradura() {
		Cerradura nuevaCerradura = new Cerradura ();
		assertNotNull(nuevaCerradura);
}
	@Test
	public void queEsteCerradaLaCerradura() {
		Cerradura nuevaCerradura = new Cerradura ();
		Boolean valorEsperado = false;
		Boolean valorObtenido = nuevaCerradura.getEstaAbierta();
		assertEquals(valorEsperado,valorObtenido);
	}
	@Test
	public void queSeAbraLaCerradura() {
		Cerradura nuevaCerradura = new Cerradura(131677,3);
		Boolean valorEsperado = true;
		Boolean valorObtenido = nuevaCerradura.abrirCerradura(131677);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queNoSeAbraLaCerradura () {
		Cerradura nuevaCerradura = new Cerradura (131677,3);
		Boolean valorEsperado = false;
		Boolean valorObtenido = nuevaCerradura.abrirCerradura(152463360);
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSeBloqueeSiSuperaLaCantidadPermitidaDeIntentos() {
		Cerradura nuevaCerradura = new Cerradura (131677,3);
		Boolean valorEsperado = true;
		nuevaCerradura.abrirCerradura(1524);
		nuevaCerradura.abrirCerradura(1524);
		nuevaCerradura.abrirCerradura(1524);
		Boolean valorObtenido = nuevaCerradura.getEstaBloqueada();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSeCierreLaCerradura () {
		Cerradura nuevaCerradura = new Cerradura (131677,3);
		Boolean valorEsperado = false;
		nuevaCerradura.cerrarCerradura();
		Boolean valorObtenido = nuevaCerradura.getEstaAbierta();
		assertEquals(valorEsperado,valorObtenido);
		
	}
	
	@Test
	//El resultado de este test es false, no deberia estar bloqueada porque no la estamos bloqueando manualmente.
	public void saberSiFueBloqueada () {
		Cerradura nuevaCerradura = new Cerradura (131677,3);
		Boolean valorEsperado = false;
		Boolean valorObtenido = nuevaCerradura.getEstaBloqueada();
		Boolean resultado;
		assertEquals(valorEsperado,valorObtenido); 
			
		}
	
}