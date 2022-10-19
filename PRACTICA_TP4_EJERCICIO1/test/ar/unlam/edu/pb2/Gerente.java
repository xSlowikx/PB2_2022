package ar.unlam.edu.pb2;

public class Gerente extends Empleado {

	private Integer cochera;

	public Gerente(String nombre, String apellido, Double sueldo, String fNac, Empleado gerente, Integer cochera) {
		super(nombre, apellido, sueldo, fNac, gerente);
		// TODO Auto-generated constructor stub
		this.cochera = cochera;
	}

	public Integer getCochera() {
		return cochera;
	}

	public void setCochera(Integer cochera) {
		this.cochera = cochera;
	}

	
}
