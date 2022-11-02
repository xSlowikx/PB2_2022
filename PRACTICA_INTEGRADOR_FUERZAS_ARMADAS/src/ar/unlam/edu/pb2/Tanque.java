package ar.unlam.edu.pb2;

import java.util.ArrayList;

public class Tanque extends Vehiculo implements Terrestre{

	public Tanque(String nombreVehiculo) {
		super(nombreVehiculo);
		this.terrenosCompatibles = new ArrayList<>() {{add("Terrestre");}};
	}

	
	
	public Tanque(Integer codigoVehiculo, String nombreVehiculo) {
		super(codigoVehiculo, nombreVehiculo);
		// TODO Auto-generated constructor stub
	}
}
