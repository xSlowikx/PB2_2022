package ar.unlam.edu.pb2;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Vehiculo {

	private Integer codigoVehiculo;
	private String nombreVehiculo;

	public Vehiculo(String nombreVehiculo) {
		// TODO Auto-generated constructor stub
		this.nombreVehiculo = nombreVehiculo;
	}
	
	public Vehiculo(String nombreVehiculo, Integer codigoVehiculo) {
		// TODO Auto-generated constructor stub
		this.nombreVehiculo = nombreVehiculo;
		this.codigoVehiculo = codigoVehiculo;
	}

	public abstract String getTipoDeTerreno();

}
