package ar.unlam.edu.pb2;

import java.util.ArrayList;

public class Avion extends Vehiculo implements Aereo{

	public Avion(String nombreVehiculo) {
		super(nombreVehiculo);
		// TODO Auto-generated constructor stub
		this.terrenosCompatibles = new ArrayList<>() {{add("Aereo");}};
	}

	

	public Avion(Integer codigoVehiculo, String nombreVehiculo) {
		super(codigoVehiculo, nombreVehiculo);
		// TODO Auto-generated constructor stub
	}


}
