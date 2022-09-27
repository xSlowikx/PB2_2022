package ar.unlam.edu.pb2;

public class Cuenta {

	private Double saldoTotalEnPesos;
	private Double saldoTotalEnDolares;
	
	public Cuenta() {
		super();
		this.saldoTotalEnPesos = 0.00;
		this.saldoTotalEnDolares = 0.00;
	}

	public Double getSaldoTotalEnPesos() {
		return saldoTotalEnPesos;
	}

	public void setSaldoTotalEnPesos(Double saldoTotalEnPesos) {
		this.saldoTotalEnPesos = saldoTotalEnPesos;
	}

	public Double getSaldoTotalEnDolares() {
		return saldoTotalEnDolares;
	}

	public void setSaldoTotalEnDolares(Double saldoTotalEnDolares) {
		this.saldoTotalEnDolares = saldoTotalEnDolares;
	}

	public void depositarEfectivoEnPesos(Double dineroDepositado) {
		// TODO Auto-generated method stub
		setSaldoTotalEnPesos(dineroDepositado);
	}
	
	public void extraerEfectivoEnPesos(Double dineroExtraido) {
		if(dineroExtraido <= getSaldoTotalEnPesos()) {
			setSaldoTotalEnPesos(getSaldoTotalEnPesos() - dineroExtraido);
		}else {
			System.out.println("El monto a extraer excede el monto total disponible para la extraccion");			
		}
	}
}
