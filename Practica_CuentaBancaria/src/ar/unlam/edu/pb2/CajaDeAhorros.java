package ar.unlam.edu.pb2;

public class CajaDeAhorros extends Cuenta {

	private Integer contadorExtraccionesDiarias;
	private Double impuesto;

	public Integer getContadorExtraccionesDiarias() {
		return contadorExtraccionesDiarias;
	}

	public void setContadorExtraccionesDiarias(Integer contadorExtraccionesDiarias) {
		this.contadorExtraccionesDiarias = contadorExtraccionesDiarias;
	}

	public Double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public CajaDeAhorros() {
		super();
		this.contadorExtraccionesDiarias = 0;
		this.impuesto = 1.06;
	}

	@Override
	public void extraerEfectivoEnPesos(Double dineroExtraido) {
		if(dineroExtraido <= getSaldoTotalEnPesos() && contadorExtraccionesDiarias < 3) {
			setSaldoTotalEnPesos(getSaldoTotalEnPesos() - dineroExtraido);
			contadorExtraccionesDiarias++;
		} else if((dineroExtraido * this.impuesto) <= getSaldoTotalEnPesos()) {
			setSaldoTotalEnPesos(getSaldoTotalEnPesos() - (dineroExtraido * this.impuesto));
			contadorExtraccionesDiarias++;
		} else {
			System.out.println("El monto a extraer excede el monto total disponible para la extraccion");
		}
	}
}
