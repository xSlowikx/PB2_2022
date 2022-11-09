package ar.edu.unlam.pbii.parcial2.c12019.enunciado;

public class CuentaCorriente extends Cuenta {

	private Double limiteDescuebierto;

	public CuentaCorriente(String cbu, Cliente cliente, Double saldo, Double limiteDescuebierto) {
		super(cbu, cliente, saldo);
		this.limiteDescuebierto = limiteDescuebierto;

	}

	@Override
	public void depositar(Double monto) {
		super.incrementarSaldo(monto);
	}

	@Override
	public void extraer(Double monto) throws MontoInsuficienteException, MontoInvalidoException {

		Integer contador = 0;
		if (monto < 0) {
			throw new MontoInvalidoException();

		}
		if (monto > getSaldo() + limiteDescuebierto) {
			throw new MontoInsuficienteException();

		}
		setSaldo(getSaldo() - monto);

	

	}
}
