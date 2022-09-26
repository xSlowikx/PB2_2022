package ar.unlam.edu.pb2;

import java.util.ArrayList;

public class Software {

	private String nombrePropietario;
	private ArrayList<Contacto> listaDeContactos ;

	public Software(String nombrePropietario) {
		// TODO Auto-generated constructor stub
		this.nombrePropietario = nombrePropietario;
		this.listaDeContactos = new ArrayList<>();
	}
	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}


	public ArrayList<Contacto> getContactos() {
		// TODO Auto-generated method stub
		return listaDeContactos;
	}

	public void agregarContacto(Contacto nuevoContacto) {
		// TODO Auto-generated method stub
		this.listaDeContactos.add(nuevoContacto);
	}

	public Integer obtenerCantidadDeContactos() {
		// TODO Auto-generated method stub
		return listaDeContactos.size();
	}
	
	public Boolean realizarNuevaLlamada() {
		// TODO Auto-generated method stub
		Contacto candidatoObtenido = buscarCandidato(listaDeContactos);
		candidatoObtenido.setCliente(true);
		candidatoObtenido.setDeseaSerLlamado(false);
		System.out.println(candidatoObtenido + " Llamada con exito");
		return (candidatoObtenido.getCliente() && !candidatoObtenido.getDeseaSerLlamado());
	}
	
	public Boolean realizarNuevaLlamadaSinExito() {
		// TODO Auto-generated method stub
		Contacto candidatoObtenido = buscarCandidato(listaDeContactos);
		System.out.println(candidatoObtenido + " Llamada sin exito");
		return (candidatoObtenido.getCliente() && !candidatoObtenido.getDeseaSerLlamado());
	}
	
	private Contacto buscarCandidato(ArrayList<Contacto> listaDeContactos) {
		// TODO Auto-generated method stub
		for(Contacto recorridoCandidatos: listaDeContactos) {
			if(recorridoCandidatos.getCliente().equals(false) && recorridoCandidatos.getDeseaSerLlamado().equals(true)){
				return recorridoCandidatos;
			}
			System.out.println(recorridoCandidatos + " Ya es cliente");
			System.out.println(recorridoCandidatos.geteMail().contains("@"));
		}
		return null;
	}
}
