package ar.unlam.edu.pb2;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Ejercito {

	private Pais paisBeligerante;
	private TreeMap<Integer, Vehiculo> listaDeVehiculos;
	private TreeMap<Integer, Vehiculo> vehiculosEnCombate;

	public Ejercito(Pais paisBeligerante) {
		// TODO Auto-generated constructor stub
		this.paisBeligerante = paisBeligerante;
		this.listaDeVehiculos = new TreeMap<>();
		this.vehiculosEnCombate = new TreeMap<>();
	}

	public void agregarVehiculo(Integer codigoVehiculo, Vehiculo nuevoVehiculo)
			throws VehiculoYaExistenteEnElConvoyException {
		// TODO Auto-generated method stub
//		if(listaDeVehiculos.containsKey(codigoVehiculo))
		for (Entry<Integer, Vehiculo> listaDeVehiculos : listaDeVehiculos.entrySet()) {
			if (listaDeVehiculos.getKey().equals(codigoVehiculo)) {
				throw new VehiculoYaExistenteEnElConvoyException(
						"El codigo de vehiculo ya se encuentra dentro del convoy");
			}

		}
		listaDeVehiculos.put(codigoVehiculo, nuevoVehiculo);

	}

//	public void enviarVehiculoALaBatalla(Vehiculo nuevoTanque, Batalla nuevaBatalla) throws VehiculoNoEncontradoException, TerrenoNoCompatibleConElVehiculoException {
//		// TODO Auto-generated method stub
//		buscarVehiculo(nuevoTanque);
//		compararTerreno(nuevoTanque,nuevaBatalla);
//		vehiculosEnCombate.put(nuevoTanque);
//	}

	public void enviarVehiculoALaBatalla(Integer codigoVehiculo, Batalla nuevaBatalla)
			throws VehiculoNoEncontradoException, TerrenoNoCompatibleConElVehiculoException {
		buscarVehiculo(codigoVehiculo);
		compararTerreno(codigoVehiculo, nuevaBatalla);
		vehiculosEnCombate.put(codigoVehiculo, listaDeVehiculos.get(codigoVehiculo));
	}

//	private Boolean compararTerreno(Vehiculo nuevoTanque, Batalla nuevaBatalla) throws TerrenoNoCompatibleConElVehiculoException {
//		// TODO Auto-generated method stub
////		if(Terrestre.class.isAssignableFrom(nuevoTanque.getClass())) {
////			System.out.println("El tanque es terrestre");
////			return true;
////		}
//		if(nuevoTanque.getTipoDeTerreno().toLowerCase().equals(nuevaBatalla.getTipoDeBatalla().toString().toLowerCase()))
//		{
//			System.out.println("El tipo de terreno es coincidente");
////			System.out.println(Terrestre.class.isAssignableFrom(nuevoTanque.getClass()));
//			return true;
//		}
//		throw new TerrenoNoCompatibleConElVehiculoException("El tipo de terreno de la batalla no es compatible con el vehiculo elegido");
//		}

	private Boolean compararTerreno(Integer codigoVehiculo, Batalla nuevaBatalla)
			throws TerrenoNoCompatibleConElVehiculoException {

		for (Entry<Integer, Vehiculo> listaDeVehiculos : listaDeVehiculos.entrySet()) {

			if (listaDeVehiculos.getKey().equals(codigoVehiculo)) {
				for (String recorridoTerreno : listaDeVehiculos.getValue().getTerrenosCompatibles()) {

					if (recorridoTerreno.toLowerCase()
							.equals(nuevaBatalla.getTipoDeBatalla().toString().toLowerCase())) {
						System.out.println("El tipo de terreno es coincidente");
						return true;
					}
				}
			}
		}
		throw new TerrenoNoCompatibleConElVehiculoException(
				"El tipo de terreno de la batalla no es compatible con el vehiculo elegido");
	}

//	private Boolean buscarVehiculo(Integer codigoVehiculo) throws VehiculoNoEncontradoException{
//		// TODO Auto-generated method stub
//		for (Vehiculo recorridoVehiculos : listaDeVehiculos) {
//			if(recorridoVehiculos.getCodigoVehiculo().equals(nuevoTanque.getCodigoVehiculo())) {
//				return true;
//			}
//	}
//		throw new VehiculoNoEncontradoException("El vehiculo no se encuentra inscripto en la armada");
//	}

	private Boolean buscarVehiculo(Integer codigoVehiculo) throws VehiculoNoEncontradoException {
		if (listaDeVehiculos.containsKey(codigoVehiculo)) {
			return true;
		}
		throw new VehiculoNoEncontradoException("El vehiculo no se encuentra inscripto en la armada");
	}

}