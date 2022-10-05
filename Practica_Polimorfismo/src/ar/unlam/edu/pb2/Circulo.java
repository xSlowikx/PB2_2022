package ar.unlam.edu.pb2;

public class Circulo extends Figura {

	private Double radio;
	

	public Circulo(Double radio) {
		super();
		this.radio = radio;
	}

	@Override
	public Double calcularElArea() {
		// TODO Auto-generated method stub
		return (this.radio * this.radio * Math.PI);
	}

	@Override
	public Double calcularElPerimetro() {
		// TODO Auto-generated method stub
		return (2 * this.radio * Math.PI);
	}

	@Override
	public void dibujarFigura() {
		// TODO Auto-generated method stub
		System.out.println("Se dibuja un circulo con un area de " + calcularElArea() + " y un perimetro de " + calcularElPerimetro());

	}

	public Double getRadio() {
		return radio;
	}

	public void setRadio(Double radio) {
		this.radio = radio;
	}
	
	
}
