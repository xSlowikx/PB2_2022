package ar.unlam.edu.pb2;

public class Reloj {

	private String marca;
	private double distanciaRecorrida;
	private double tiempoTranscurrido;
	private ZonasCardiacas zonaCardiaca;
	private Double ritmo;

	public Reloj(String marca) {
		// TODO Auto-generated constructor stub
		super();
		this.marca = marca;
		this.distanciaRecorrida = 0.0;
		this.tiempoTranscurrido = 0.0;
		this.zonaCardiaca = ZonasCardiacas.DESCANSO;
		
	}

}
