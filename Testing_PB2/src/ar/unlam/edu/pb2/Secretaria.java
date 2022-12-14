package ar.unlam.edu.pb2;

import java.util.ArrayList;

public class Secretaria {

	private String nombre;
	private ArrayList<Vivienda> viviendas;

	public Secretaria(String nombreSecretaria) {
		// TODO Auto-generated constructor stub
		this.nombre = nombreSecretaria;
		this.viviendas = new ArrayList<>();
	}

	public void agregarVivienda(Integer nroLote, String calle, Integer altura, String localidad, Integer codigoPostal) {
		// TODO Auto-generated method stub
		Vivienda nuevaVivienda = new Vivienda (nroLote,calle,altura,localidad,codigoPostal);
		this.viviendas.add(nuevaVivienda);
		
	}

	public void agregarHabitanteEnUnaVivienda(Integer nroLote, String tipoDoc, Integer numeroDoc, String nombre, String apellido, String fechaNacimiento) {
		// TODO Auto-generated method stub
		Habitante nuevoHabitante = new Habitante(nroLote,tipoDoc,numeroDoc,nombre,apellido,fechaNacimiento);
		for(Vivienda recorridoVivienda: viviendas) {
			if(recorridoVivienda.getNroLote().equals(nroLote)) {
			}
		}
		
		
	}

	public ArrayList<Vivienda> getViviendas() {
		return viviendas;
	}

	public void setViviendas(ArrayList<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}

}
