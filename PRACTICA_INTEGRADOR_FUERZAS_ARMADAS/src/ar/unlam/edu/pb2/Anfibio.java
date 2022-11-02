package ar.unlam.edu.pb2;

import java.util.ArrayList;

public class Anfibio extends Vehiculo implements Terrestre, Acuatico{

	public Anfibio(String nombreVehiculo) {
		super(nombreVehiculo);
		this.terrenosCompatibles = new ArrayList<>() {{add("Terrestre");add("Acuatico");}};
	}

	
	
	public Anfibio(Integer codigoVehiculo, String nombreVehiculo) {
		super(codigoVehiculo, nombreVehiculo);
		// TODO Auto-generated constructor stub
		this.terrenosCompatibles = new ArrayList<>() {{add("Terrestre");add("Acuatico");}};
	}
}
