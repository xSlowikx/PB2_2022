package ar.unlam.edu.pb2;

public class Tanque extends Vehiculo implements Terrestre{

	public Tanque(String nombreVehiculo) {
		super(nombreVehiculo);
		// TODO Auto-generated constructor stub
	}

	public Tanque(String nombreVehiculo, Integer codigoVehiculo) {
		super(nombreVehiculo, codigoVehiculo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipoDeTerreno() {
		// TODO Auto-generated method stub
		return "Terrestre";
	}

}
