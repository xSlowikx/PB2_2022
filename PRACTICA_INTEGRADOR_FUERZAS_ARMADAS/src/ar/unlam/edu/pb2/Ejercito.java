package ar.unlam.edu.pb2;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class Ejercito {

	private Pais paisBeligerante;
	private HashSet<Vehiculo> listaDeVehiculos;
	private HashSet<Vehiculo> vehiculosEnCombate;

	public Ejercito(Pais paisBeligerante) {
		// TODO Auto-generated constructor stub
		this.paisBeligerante = paisBeligerante;
		this.listaDeVehiculos = new HashSet<>();
		this.vehiculosEnCombate = new HashSet<>();
	}

	public void agregarVehiculo(Vehiculo nuevoVehiculo) {
		// TODO Auto-generated method stub
		listaDeVehiculos.add(nuevoVehiculo);
		
	}

	public void enviarVehiculoALaBatalla(Vehiculo nuevoTanque, Batalla nuevaBatalla) throws VehiculoNoEncontradoException, TerrenoNoCompatibleConElVehiculoException {
		// TODO Auto-generated method stub
		buscarVehiculo(nuevoTanque);
		compararTerreno(nuevoTanque,nuevaBatalla);
		vehiculosEnCombate.add(nuevoTanque);
	}
	
	private Boolean compararTerreno(Vehiculo nuevoTanque, Batalla nuevaBatalla) throws TerrenoNoCompatibleConElVehiculoException {
		// TODO Auto-generated method stub
//		if(Terrestre.class.isAssignableFrom(nuevoTanque.getClass())) {
//			System.out.println("El tanque es terrestre");
//			return true;
//		}
		if(nuevoTanque.getTipoDeTerreno().toLowerCase().equals(nuevaBatalla.getTipoDeBatalla().toString().toLowerCase()))
		{
			System.out.println("El tipo de terreno es coincidente");
			System.out.println(Terrestre.class.isAssignableFrom(nuevoTanque.getClass()));
			return true;
		}
		throw new TerrenoNoCompatibleConElVehiculoException("El tipo de terreno de la batalla no es compatible con el vehiculo elegido");
		}

	private Boolean buscarVehiculo(Vehiculo nuevoTanque) throws VehiculoNoEncontradoException{
		// TODO Auto-generated method stub
		for (Vehiculo recorridoVehiculos : listaDeVehiculos) {
			if(recorridoVehiculos.getCodigoVehiculo().equals(nuevoTanque.getCodigoVehiculo())) {
				return true;
			}
	}
		throw new VehiculoNoEncontradoException("El vehiculo no se encuentra inscripto en la armada");
	}

	
}