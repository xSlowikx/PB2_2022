package ar.unlam.edu.pb2;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Fichero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String identificacionFichero;
	private Set<Carpeta> registroDeCarpetas;

	public Fichero(String identificacionFichero) {
		// TODO Auto-generated constructor stub
		this.identificacionFichero = identificacionFichero;
		this.registroDeCarpetas = new HashSet<>();
	}

	public void agregarNuevaCarpeta(Carpeta carpetaParaAgregar) throws CarpetaYaColocadaEnElFicheroException {
		// TODO Auto-generated method stub
		if (registroDeCarpetas.contains(carpetaParaAgregar)) {
			throw new CarpetaYaColocadaEnElFicheroException(
					"La carpeta que estas intentando agregar al fichero ya se encuentra ahi");
		}
		registroDeCarpetas.add(carpetaParaAgregar);
	}

	public void agregarNuevoRegistroDeEmpleado(Empleado registroParaAgregar, Carpeta carpetaDestino) throws CarpetaDelAreaEspecificadaNoEncontradaException {
		// TODO Auto-generated method stub
		Carpeta carpetaEncontrada = buscarCarpeta(carpetaDestino.getAreaEstablecida());
		carpetaEncontrada.getRegistrosDeEmpleado().add(registroParaAgregar);
	}

	public List<Empleado> obtenerRegistrosDeUnaCarpeta(Area areaDeLaCarpetaBuscada)
			throws CarpetaDelAreaEspecificadaNoEncontradaException {
		// TODO Auto-generated method stub
		Carpeta carpetaEncontrada = buscarCarpeta(areaDeLaCarpetaBuscada);
		return carpetaEncontrada.getRegistrosDeEmpleado();
	}

	private Carpeta buscarCarpeta(Area areaDeLaCarpetaBuscada) throws CarpetaDelAreaEspecificadaNoEncontradaException {
		// TODO Auto-generated method stub
		for (Carpeta recorridoCarpetas : this.registroDeCarpetas) {
			if (recorridoCarpetas.getAreaEstablecida().equals(areaDeLaCarpetaBuscada)) {
				return recorridoCarpetas;
			}
		}
		throw new CarpetaDelAreaEspecificadaNoEncontradaException(
				"La carpeta del area especificada no se encuentra agregada aun al fichero");

	}
}
