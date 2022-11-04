package ar.unlam.edu.pb2;

public class Figurita {

	private Integer numeroFigurita;
	private Character grupo;
	private Pais paisOrigen;
	private String nombreJugador;
	private Double valorMercado;

	public Figurita(Integer numeroFigurita, Character grupo, Pais paisOrigen, String nombreJugador, Double valorMercado) {
		// TODO Auto-generated constructor stub
		this.numeroFigurita = numeroFigurita;
		this.grupo = grupo;
		this.paisOrigen = paisOrigen;
		this.nombreJugador = nombreJugador;
		this.valorMercado = valorMercado;
	}

	public Integer getNumeroFigurita() {
		return numeroFigurita;
	}

	public void setNumeroFigurita(Integer numeroFigurita) {
		this.numeroFigurita = numeroFigurita;
	}

	public Character getGrupo() {
		return grupo;
	}

	public void setGrupo(Character grupo) {
		this.grupo = grupo;
	}

	public Pais getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(Pais paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public Double getValorMercado() {
		return valorMercado;
	}

	public void setValorMercado(Double valorMercado) {
		this.valorMercado = valorMercado;
	}
	
}
