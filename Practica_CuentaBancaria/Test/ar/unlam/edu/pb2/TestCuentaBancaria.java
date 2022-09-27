package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaBancaria {

	@Test
	public void queSePuedaCrearUnaCuenta() {
		Cuenta nuevaCuenta = new Cuenta ();
		assertNotNull(nuevaCuenta);
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaSueldo() {
		CuentaSueldo nuevaCuentaSueldo = new CuentaSueldo ();
		assertNotNull(nuevaCuentaSueldo);
	}
	
	@Test
	public void queSePuedaDepositarEnLaCuentaSueldo() {
		CuentaSueldo nuevaCuentaSueldo = new CuentaSueldo ();
		nuevaCuentaSueldo.depositarEfectivoEnPesos(10000.00);
		Double valorEsperado = 10000.00;
		Double valorObtenido = nuevaCuentaSueldo.getSaldoTotalEnPesos();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaExtraerEnLaCuentaSueldo() {
		CuentaSueldo nuevaCuentaSueldo = new CuentaSueldo ();
		nuevaCuentaSueldo.depositarEfectivoEnPesos(10000.00);
		nuevaCuentaSueldo.extraerEfectivoEnPesos(8500.00);
		Double valorEsperado = 1500.00;
		Double valorObtenido = nuevaCuentaSueldo.getSaldoTotalEnPesos();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaCrearUnaCajaDeAhorros() {
		CajaDeAhorros nuevaCajaDeAhorros = new CajaDeAhorros();
		assertNotNull(nuevaCajaDeAhorros);
	}
	
	@Test
	public void queSePuedaDepositarEnLaCajaDeAhorros() {
		CajaDeAhorros nuevaCajaDeAhorros = new CajaDeAhorros();
		nuevaCajaDeAhorros.depositarEfectivoEnPesos(15000.00);
		Double valorEsperado = 15000.00;
		Double valorObtenido = nuevaCajaDeAhorros.getSaldoTotalEnPesos();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaExtraerEnLaCajaDeAhorros() {
		CajaDeAhorros nuevaCajaDeAhorros = new CajaDeAhorros();
		nuevaCajaDeAhorros.depositarEfectivoEnPesos(20000.00);
		nuevaCajaDeAhorros.extraerEfectivoEnPesos(5000.00);
		nuevaCajaDeAhorros.extraerEfectivoEnPesos(3000.00);
		nuevaCajaDeAhorros.extraerEfectivoEnPesos(4000.00);
		nuevaCajaDeAhorros.extraerEfectivoEnPesos(1500.00);
		nuevaCajaDeAhorros.extraerEfectivoEnPesos(1500.00);
		Double valorEsperado = 4820.00;
		Double valorObtenido = nuevaCajaDeAhorros.getSaldoTotalEnPesos();
		assertEquals(valorEsperado, valorObtenido);
		System.out.println(valorObtenido + " Es el monto final restante en la Caja de Ahorro para ser retirado");
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaCorriente() {
		CuentaCorriente nuevaCuentaCorriente = new CuentaCorriente();
		assertNotNull(nuevaCuentaCorriente);
	}
	
	@Test
	public void queSePuedaDepositarEnLaCuentaCorriente() {
		CuentaCorriente nuevaCuentaCorriente = new CuentaCorriente();
		nuevaCuentaCorriente.depositarEfectivoEnPesos(15000.00);
		Double valorEsperado = 15000.00;
		Double valorObtenido = nuevaCuentaCorriente.getSaldoTotalEnPesos();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaRealizarUnGiroBancario() {
		CuentaCorriente nuevaCuentaCorriente = new CuentaCorriente();
		nuevaCuentaCorriente.depositarEfectivoEnPesos(5000.00);
		nuevaCuentaCorriente.extraerEfectivoEnPesos(5400.00);
		Double valorEsperado = -420.00;
		Double valorObtenido = nuevaCuentaCorriente.getSaldoTotalEnPesos();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void obtenerDeudaBancariaDeLaCuentaCorriente() {
		CuentaCorriente nuevaCuentaCorriente = new CuentaCorriente();
		nuevaCuentaCorriente.depositarEfectivoEnPesos(5000.00);
		nuevaCuentaCorriente.extraerEfectivoEnPesos(5476.00);
		Double deudaBancaria = nuevaCuentaCorriente.obtenerDeudaBancariaDeLaCuentaCorriente();
		System.out.println(deudaBancaria + " Es la deuda que tenes actualmente con el banco, pendiente de pago...");
		System.out.println(nuevaCuentaCorriente.getSaldoTotalEnPesos());
	}
	
}
