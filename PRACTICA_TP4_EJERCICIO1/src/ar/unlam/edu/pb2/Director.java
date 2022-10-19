package ar.unlam.edu.pb2;

public class Director extends Empleado {
	
	private final Double extraPorPuesto = 1.50;
	private Integer cochera;
	
	public Director(String nombre, String apellido, Double sueldo, String fNac,Empleado gerente,Integer cochera) {
		super(nombre, apellido, sueldo, fNac, gerente);
		// TODO Auto-generated constructor stub
		this.cochera = cochera;
		this.sueldo = sueldo * this.extraPorPuesto;
	}

	public Integer getCochera() {
		return cochera;
	}

	public void setCochera(Integer cochera) {
		this.cochera = cochera;
	}

	
}
