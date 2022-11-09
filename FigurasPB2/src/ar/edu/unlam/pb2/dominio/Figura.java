package ar.edu.unlam.pb2.dominio;

import java.util.Comparator;
import java.util.Objects;

public class Figura implements Comparable<Figura> {

	protected String nombre;
	protected Double medidas;
	private String cuadrante;

	public Figura() {

	}

	public Figura(String nombre, Double medidas, String cuadrante) {
		this.nombre = nombre;
		this.medidas = medidas;
		this.cuadrante = cuadrante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getMedidas() {
		return medidas;
	}

	public void setMedidas(Double medidas) {
		this.medidas = medidas;
	}

	@Override
	public int compareTo(Figura o) {
		int variableAuxiliar = this.getCuadrante().compareTo(o.getCuadrante());
		if (variableAuxiliar == 0) {
			variableAuxiliar = this.getNombre().compareTo(o.getNombre());
			if (variableAuxiliar == 0) {
				variableAuxiliar = this.getMedidas().compareTo(o.getMedidas());
			}
		}
		return variableAuxiliar;
	}

	@Override
	public int hashCode() {
		return Objects.hash(medidas, nombre, cuadrante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figura other = (Figura) obj;
		return Objects.equals(medidas, other.medidas) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(cuadrante, other.cuadrante);
	}

	@Override
	public String toString() {
		return "Figura [nombre=" + nombre + ", medidas=" + medidas + ", cuadrante=" + cuadrante + "]";
	}

	public String getCuadrante() {
		return cuadrante;
	}

	public void setCuadrante(String cuadrante) {
		this.cuadrante = cuadrante;
	}

}
