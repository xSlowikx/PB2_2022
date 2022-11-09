package ar.edu.unlam.pbii.parcial2.c12019.enunciado;

import java.util.Comparator;

public class OrdenClientePorNombre implements Comparator<Cuenta> {

	@Override
	public int compare(Cuenta c1, Cuenta c2) {

		return c1.getCliente().getNombre().compareTo(c2.getCliente().getNombre());

	}

}
