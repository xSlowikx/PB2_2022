package ar.edu.unlam.pb2;

public class CajaAhorro extends Cuenta {
	
	
	public CajaAhorro(Integer numCuenta, Integer dni, String nombre, String apellido) {
		super(numCuenta, dni, nombre, apellido);
	}

	

	public String getTipo() {
		return "CajaAhorro";
	}
	
	@Override
	public Boolean extraer(Double monto) throws MontoInsuficienteException {
		if (monto <= getSaldo()) {
			setSaldo(getSaldo()-monto);
			return true;
		}
		throw new MontoInsuficienteException("No contas con fondos suficientes capo");
	}
}
