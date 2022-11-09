package ar.edu.unlam.pbii.parcial2.c12019.enunciado;

public class CajaDeAhorro extends Cuenta {

	private Integer cantidadExtraccines;

	public CajaDeAhorro(String cbu, Cliente cliente, Double saldo, Integer cantidadExtraccines) {
		super(cbu, cliente, saldo);

		this.cantidadExtraccines = cantidadExtraccines;

	}

	@Override
	public void depositar(Double monto) throws MontoInvalidoException {
		if (monto > 0) {
			setSaldo(getSaldo() + monto);
		} else {
			throw new MontoInvalidoException();
		}

	}

	@Override
	public void extraer(Double monto) throws MontoInsuficienteException, MontoInvalidoException {
		Integer contador = 0;
		if (monto < 0) {
			throw new MontoInvalidoException();

		}
		if (monto > getSaldo()) {
			throw new MontoInsuficienteException();

		}
		setSaldo(getSaldo() - monto);

	}

}
