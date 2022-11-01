package ar.unlam.edu.pb2;

public class Avion extends Vehiculo implements Aereo{

	public Avion(String nombreVehiculo) {
		super(nombreVehiculo);
		// TODO Auto-generated constructor stub
	}

	public Avion(String nombreVehiculo, Integer codigoVehiculo) {
		super(nombreVehiculo, codigoVehiculo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipoDeTerreno() {
		// TODO Auto-generated method stub
		return "Aereo";
	}

}
