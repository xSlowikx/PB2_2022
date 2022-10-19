package ar.unlam.edu.pb2;

import java.util.HashSet;

public class Empresa {

	private String nombreDeLaEmpresa;
	private HashSet<Empleado> listaDeEmpleados;

	public Empresa(String nombreDeLaEmpresa) {
		// TODO Auto-generated constructor stub
		super();
		this.nombreDeLaEmpresa = nombreDeLaEmpresa;
		this.listaDeEmpleados = new HashSet<>();
	}

	public void agregarEmpleado(Empleado nuevoEmpleado) {
		// TODO Auto-generated method stub
		this.listaDeEmpleados.add(nuevoEmpleado);
	}

	public String getNombreDeLaEmpresa() {
		return nombreDeLaEmpresa;
	}

	public void setNombreDeLaEmpresa(String nombreDeLaEmpresa) {
		this.nombreDeLaEmpresa = nombreDeLaEmpresa;
	}

	public HashSet<Empleado> getListaDeEmpleados() {
		return listaDeEmpleados;
	}

	public void setListaDeEmpleados(HashSet<Empleado> listaDeEmpleados) {
		this.listaDeEmpleados = listaDeEmpleados;
	}
	
	
	
}
