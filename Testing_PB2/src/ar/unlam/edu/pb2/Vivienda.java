package ar.unlam.edu.pb2;

import java.util.ArrayList;

public class Vivienda {

	private Integer nroLote;
	public Integer getNroLote() {
		return nroLote;
	}


	public void setNroLote(Integer nroLote) {
		this.nroLote = nroLote;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public Integer getAltura() {
		return altura;
	}


	public void setAltura(Integer altura) {
		this.altura = altura;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public Integer getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public ArrayList<Habitante> getHabitantes() {
		return habitantes;
	}


	public void setHabitantes(ArrayList<Habitante> habitantes) {
		this.habitantes = habitantes;
	}


	private String calle;
	private Integer altura;
	private String localidad;
	private Integer codigoPostal;
	private ArrayList<Habitante> habitantes;
	

	public Vivienda(Integer nroLote, String calle, Integer altura, String localidad, Integer codigoPostal) {
		// TODO Auto-generated constructor stub
		this.nroLote = nroLote;
		this.calle = calle;
		this.altura = altura;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
	}
}
