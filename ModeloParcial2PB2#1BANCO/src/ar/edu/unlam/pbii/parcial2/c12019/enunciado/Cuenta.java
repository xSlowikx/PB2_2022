package ar.edu.unlam.pbii.parcial2.c12019.enunciado;

public abstract class Cuenta {

	private String cbu;
	private Cliente cliente;
	private Double saldo;

	public Cuenta(String cbu, Cliente cliente, Double saldo) {
		super();
		this.cbu = cbu;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public void incrementarSaldo(Double monto) {
		this.saldo += monto;

	}

	public void decrementarSaldo(Double monto) {
		this.saldo -= monto;

	}

	// Lanzar la excepción MontoInvalidoException
	public abstract void depositar(Double monto) throws MontoInvalidoException;

	// Lanzar las excepciones MontoInsuficienteException, MontoInvalidoException
	public abstract void extraer(Double monto) throws MontoInsuficienteException, MontoInvalidoException;

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;

	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cbu == null) ? 0 : cbu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (cbu == null) {
			if (other.cbu != null)
				return false;
		} else if (!cbu.equals(other.cbu))
			return false;
		return true;
	}

}
