package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Iterator;

public class Banco {

	private ArrayList<Cuenta> cuentas;

	public Banco() {
		this.cuentas = new ArrayList<>();
	}

	public void agregarCuenta(Cuenta cuenta) {
		this.cuentas.add(cuenta);
	}

	public Boolean transferir(Double monto, Cuenta origen, Cuenta destino) throws MontoInsuficienteException {
		if(origen.extraer(monto)) {
			destino.depositar(monto);
			return true;
		}
		return false;
	}

	public Boolean transferir(Integer numCuentaOrigen, Integer numCuentaDestino, Double monto) throws CuentaNoEncontradaException, MontoInsuficienteException {
		Cuenta origen = buscarCuenta(numCuentaOrigen);
		Cuenta destino = buscarCuenta(numCuentaDestino);
		return transferir(monto, origen, destino);
	}

	public Cuenta buscarCuenta(Integer numCuenta) throws CuentaNoEncontradaException {
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getNumCuenta().equals(numCuenta)) {
				return cuenta;
			}
		}
		throw new CuentaNoEncontradaException("No se encontro la cuenta");
	}
	
	public Integer obtenerSumatoriaDePuntosDeCuentasCorrientes() {
		Integer total = 0;
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getTipo().equals("CuentaCorriente")) {
				total += ((CuentaCorriente)cuenta).getPuntos();
			}
		}
		return total;
	}
}
