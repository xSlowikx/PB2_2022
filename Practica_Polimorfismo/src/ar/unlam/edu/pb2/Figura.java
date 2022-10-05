package ar.unlam.edu.pb2;

public abstract class Figura {
	
	private String color;
	
	public Figura() {
		// TODO Auto-generated constructor stub
		this.color = "Negro";
	}
	
	public abstract Double calcularElArea();
	public abstract Double calcularElPerimetro();
	public abstract void dibujarFigura();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
}
