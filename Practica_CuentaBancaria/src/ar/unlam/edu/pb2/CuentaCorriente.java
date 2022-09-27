package ar.unlam.edu.pb2;

public class CuentaCorriente extends Cuenta {

	private Double deudaBancaria;
	private Double impuestoPorGiro;
	private Double limiteTolerancia;
	
	public CuentaCorriente() {
		super();
		this.deudaBancaria = 0.00;
		this.impuestoPorGiro = 1.05;
		limiteTolerancia = -500.00;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void extraerEfectivoEnPesos(Double dineroExtraido) {
		if(dineroExtraido > getSaldoTotalEnPesos()) {
			this.deudaBancaria = (getSaldoTotalEnPesos() - dineroExtraido) * this.impuestoPorGiro;
			if(deudaBancaria >= limiteTolerancia) {
				setSaldoTotalEnPesos(deudaBancaria);
			} else {
				System.out.println("La tolerancia tiene como limite -$500 y la tuya quedaria establecida en: " + deudaBancaria + " , operacion imposible de realizar");
			}
		} else {
				super.extraerEfectivoEnPesos(dineroExtraido);
		}
	}

	public Double obtenerDeudaBancariaDeLaCuentaCorriente() {
		// TODO Auto-generated method stub
		return this.deudaBancaria;
	}
}
