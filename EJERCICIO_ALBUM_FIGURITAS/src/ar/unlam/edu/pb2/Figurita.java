package ar.unlam.edu.pb2;

import java.util.Map.Entry;
import java.util.Objects;

public class Figurita implements Comparable<Figurita>{

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

	@Override
	public int hashCode() {
		return Objects.hash(grupo, nombreJugador, numeroFigurita, paisOrigen, valorMercado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figurita other = (Figurita) obj;
		return Objects.equals(grupo, other.grupo) && Objects.equals(nombreJugador, other.nombreJugador)
				&& Objects.equals(numeroFigurita, other.numeroFigurita) && paisOrigen == other.paisOrigen
				&& Objects.equals(valorMercado, other.valorMercado);
	}

	@Override
	public String toString() {
		return "Figurita [numeroFigurita=" + numeroFigurita + ", grupo=" + grupo + ", paisOrigen=" + paisOrigen
				+ ", nombreJugador=" + nombreJugador + ", valorMercado=" + valorMercado + "]";
	}

	@Override
	public int compareTo(Figurita o) {
		// TODO Auto-generated method stub
		int ordenador = this.getGrupo().compareTo(o.getGrupo());
		if( ordenador == 0) {
			ordenador = this.getPaisOrigen().compareTo(o.getPaisOrigen());
			if(ordenador == 0) {
				ordenador = this.getNumeroFigurita().compareTo(o.getNumeroFigurita());
			}
		}
		return ordenador;
	}
	
}
