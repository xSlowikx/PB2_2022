package ar.unlam.edu.pb2;

import java.util.ArrayList;

public class Lancha extends Vehiculo implements Acuatico{

	public Lancha(String nombreVehiculo) {
		super(nombreVehiculo);
		// TODO Auto-generated constructor stub
		this.terrenosCompatibles = new ArrayList<>() {{add("Acuatico");}};
	}

	
	public Lancha(Integer codigoVehiculo, String nombreVehiculo) {
		super(codigoVehiculo, nombreVehiculo);
		// TODO Auto-generated constructor stub
	}

}
