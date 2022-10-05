package ar.unlam.edu.pb2;

public class Rectangulo extends Figura {
	
	private Double ladoA;
	private Double ladoB;

	public Rectangulo(Double ladoA, Double ladoB) {
		super();
		this.ladoA = ladoA;
		this.ladoB = ladoB;
	}

	@Override
	public Double calcularElArea() {
		// TODO Auto-generated method stub
		return (this.ladoA * this.ladoB);
	}

	@Override
	public Double calcularElPerimetro() {
		// TODO Auto-generated method stub
		return (this.ladoA*2) + (this.ladoB*2);
	}

	@Override
	public void dibujarFigura() {
		// TODO Auto-generated method stub
		System.out.println("Se dibuja un rectangulo con un area de " + calcularElArea() + "y un perimetro de " + calcularElPerimetro());
	}

	public Double getBase() {
		return ladoA;
	}

	public void setBase(Double base) {
		this.ladoA = base;
	}

	public Double getAltura() {
		return ladoB;
	}

	public void setLadoB(Double altura) {
		this.ladoB = altura;
	}

	
}
