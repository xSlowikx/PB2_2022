package ar.unlam.edu.pb2;

public class Ingeniero extends Empleado {

	private final Double conceptoProductividad = 25000.0;

	public Ingeniero(String nombre, String apellido, Double sueldo, String fNac, Empleado gerente) {
		super(nombre, apellido, sueldo, fNac, gerente);
		// TODO Auto-generated constructor stub
		this.sueldo += this.conceptoProductividad ;
	}

}
