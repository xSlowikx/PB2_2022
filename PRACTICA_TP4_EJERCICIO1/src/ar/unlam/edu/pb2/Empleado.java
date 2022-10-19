package ar.unlam.edu.pb2;

public class Empleado {

	private String nombre;
	private String apellido;
	protected Double sueldo;
	private String fNac;
	private Empleado gerente;
	private CargoEjercido cargoEjercido;

	public Empleado(String nombre, String apellido, Double sueldo, String fNac, Empleado gerente) {
		// TODO Auto-generated constructor stub
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
		this.fNac = fNac;
		this.gerente = gerente;
		this.cargoEjercido = CargoEjercido.EMPLEADO;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public String getfNac() {
		return fNac;
	}

	public void setfNac(String fNac) {
		this.fNac = fNac;
	}

	public Empleado getGerente() {
		return gerente;
	}

	public void setGerente(Empleado gerente) {
		this.gerente = gerente;
	}

	public CargoEjercido getCargoEjercido() {
		return cargoEjercido;
	}

	public void setCargoEjercido(CargoEjercido cargoEjercido) {
		this.cargoEjercido = cargoEjercido;
	}
	
	
}
