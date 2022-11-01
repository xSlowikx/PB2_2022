package ar.unlam.edu.pb2;

public class Lancha extends Vehiculo implements Acuatico{

	public Lancha(String nombreVehiculo) {
		super(nombreVehiculo);
		// TODO Auto-generated constructor stub
	}

	public Lancha(String nombreVehiculo, Integer codigoVehiculo) {
		super(nombreVehiculo, codigoVehiculo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipoDeTerreno() {
		// TODO Auto-generated method stub
		return "Acuatico";
	}

}
