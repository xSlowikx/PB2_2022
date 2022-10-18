package ar.edu.unlam.pb2;


public abstract class Cuenta {
	
	private Integer numCuenta;
	private Double saldo;
	private Titular titular;
	private String tipo;
	
	public Cuenta (Integer numCuenta, Double saldo, Titular titular) {
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.titular = titular;
	}
	
	public Cuenta(Integer numCuenta, Titular titular) {
		//titular ya registrado
		super();
		this.numCuenta = numCuenta;
		this.titular = titular;
		this.saldo = 0.0;
	}



	public Cuenta(Integer numCuenta, Integer dni, String nombre, String apellido) {
		//titular no registrado
		super();
		this.titular = new Titular(nombre, apellido, dni);
		this.numCuenta = numCuenta;
		this.saldo = 0.0;
	}



	public Cuenta() {
	
	}

	public abstract Boolean extraer(Double monto) throws MontoInsuficienteException;
		
	
	public void depositar(Double monto) {
		this.saldo += monto;
	}

	public Integer getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(Integer numCuenta) {
		this.numCuenta = numCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	
	public abstract String getTipo();
	
	public Double division (Double numerador, Double denominador) throws Exception {
		if(denominador!=0) {
			return numerador/denominador;
		}
		throw new Exception("No se puede dividir por 0");

	}
}
