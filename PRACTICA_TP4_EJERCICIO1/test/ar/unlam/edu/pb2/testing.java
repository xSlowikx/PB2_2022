package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class testing {

	@Test
	public void queSePuedaCrearMiEmpresa() {
		Empresa nuevaEmpresa = new Empresa ("SALCHIPAPAS");
		assertNotNull(nuevaEmpresa);
	}
	
	@Test
	public void queSePuedaAgregarUnEmpleadoAMiEmpresa () {
		Empresa nuevaEmpresa = new Empresa ("SALCHIPAPAS");
		Empleado nuevoEmpleado = new Empleado ("Hernan","Ortega",70000.0,"29/03/1993",null);
		nuevaEmpresa.agregarEmpleado(nuevoEmpleado);
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevaEmpresa.getListaDeEmpleados().size();
		assertEquals(valorEsperado,valorObtenido);
	}

	@Test
	public void queSePuedaAgregarUnDirectivoALaEmpresa() {
		Empresa nuevaEmpresa = new Empresa ("SALCHIPAPAS");
		Empleado nuevoDirectivo = new Director ("Pedro","Fuensalida",350000.0,"01/05/1975",null,1);
		nuevaEmpresa.agregarEmpleado(nuevoDirectivo);
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevaEmpresa.getListaDeEmpleados().size();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarUnGerenteALaEmpresa() {
		Empresa nuevaEmpresa = new Empresa ("SALCHIPAPAS");
		Empleado nuevoGerente = new Gerente ("Pedro","Petrozo",175000.0,"01/05/1995",null,2);
		nuevaEmpresa.agregarEmpleado(nuevoGerente);
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevaEmpresa.getListaDeEmpleados().size();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarUnIngenieroALaEmpresa() {
		Empresa nuevaEmpresa = new Empresa ("SALCHIPAPAS");
		Empleado nuevoIngeniero = new Ingeniero ("Pablo","Mendoza",100000.0,"17/09/2003",null);
		nuevaEmpresa.agregarEmpleado(nuevoIngeniero);
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevaEmpresa.getListaDeEmpleados().size();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarUnGerenteAUnEmpleado() {
		Empresa nuevaEmpresa = new Empresa ("SALCHIPAPAS");
		Empleado nuevoGerente = new Gerente ("Pedro","Petrozo",175000.0,"01/05/1995",null,2);
		Empleado nuevoIngeniero = new Ingeniero ("Pablo","Mendoza",100000.0,"17/09/2003",nuevoGerente);
		Empleado nuevoEmpleado = new Ingeniero ("Pablo","Mendoza",100000.0,"17/09/2003",nuevoGerente);
		nuevaEmpresa.agregarEmpleado(nuevoGerente);
		nuevaEmpresa.agregarEmpleado(nuevoIngeniero);
		nuevaEmpresa.agregarEmpleado(nuevoEmpleado);
//		Integer valorEsperado = 3;
//		Integer valorObtenido = nuevaEmpresa.getListaDeEmpleados().size();
//		assertEquals(valorEsperado,valorObtenido);
		Gerente valorObtenido = (Gerente) nuevoIngeniero.getGerente(); 
		System.out.println(valorObtenido instanceof Gerente);
	}
	
}
