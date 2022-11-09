package ar.edu.unlam.pbii.parcial2.c12019.enunciado;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



public class Banco {

	private Set<Cuenta> listaDeCuentas;

	public Banco() {

		listaDeCuentas = new HashSet<Cuenta>();

	}

	// Lanzar las siguientes excepciones MontoInvalidoException,
	// MontoInsuficienteException, CuentaInvalidaException
	public void transfer(Double monto, String cbuOrigen, String cbuDestino)
			throws MontoInvalidoException, MontoInsuficienteException, CuentaInvalidaException {

		Cuenta origen = this.buscarCuentaPorCbu(cbuOrigen);
		Cuenta destino = this.buscarCuentaPorCbu(cbuDestino);

		origen.extraer(monto);
		destino.depositar(monto);

	}

	public Boolean existeCuenta(Cuenta cuenta) {
		for (Cuenta c : listaDeCuentas) {
			if (c.getCbu().equals(cuenta.getCbu())) {
				return true;
			}
		}
		return false;

	}

	public Boolean agregarCuenta(Cuenta cuenta) {
		return listaDeCuentas.add(cuenta);
	}

	// Lanzar la excepcion CuentaInvalidaException
	public Cuenta buscarCuentaPorCbu(String cbu) throws CuentaInvalidaException {
		for (Cuenta cuenta : listaDeCuentas) {
			if (cuenta.getCbu().equals(cbu))
				return cuenta;
		}

		throw new CuentaInvalidaException();

	}

	public Integer obtenerCantidadDeCuentas() {
		return listaDeCuentas.size();
	}

	public TreeSet<Cuenta> obtenerListaCuentasOrdenadaPorNombreCliente(Comparator ordenarCuenta) {

		TreeSet<Cuenta> cuentasOrdenadasPorNombre = new TreeSet<Cuenta>(ordenarCuenta);

		return cuentasOrdenadasPorNombre;

	}

	public List<CuentaCorriente> obtenerListaCuentaCorriente() {

		List<CuentaCorriente> listaCuentaCorriente = new LinkedList<CuentaCorriente>();

		for (Cuenta cuenta : listaDeCuentas) {
			if (cuenta instanceof CuentaCorriente) {
				listaCuentaCorriente.add((CuentaCorriente) cuenta);
			}
		}
		return listaCuentaCorriente;

	}

}