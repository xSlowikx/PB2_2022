package ar.unlam.edu.pb2;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Vehiculo {

	private Integer codigoVehiculo;
	private String nombreVehiculo;
	protected ArrayList<String> terrenosCompatibles;

	public Vehiculo(String nombreVehiculo) {
		// TODO Auto-generated constructor stub
		this.nombreVehiculo = nombreVehiculo;
	}
	
	public Vehiculo(Integer codigoVehiculo, String nombreVehiculo) {
		// TODO Auto-generated constructor stub
		this.codigoVehiculo = codigoVehiculo;
		this.nombreVehiculo = nombreVehiculo;
	}
}