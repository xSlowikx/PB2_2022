package ar.unlam.edu.pb2;

import java.util.Objects;

public class Sensor {
	
	private Integer numeroSensor;
	private Boolean estadoSensor;
	
	public Sensor (Integer numeroSensor ) {
		this.numeroSensor = numeroSensor;
		this.estadoSensor = false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estadoSensor, numeroSensor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		return Objects.equals(estadoSensor, other.estadoSensor) && Objects.equals(numeroSensor, other.numeroSensor);
	}

	public Integer getNumeroSensor() {
		return numeroSensor;
	}

	public void setNumeroSensor(Integer numeroSensor) {
		this.numeroSensor = numeroSensor;
	}

	public Boolean getEstadoSensor() {
		return estadoSensor;
	}

	public void setEstadoSensor(Boolean estadoSensor) {
		this.estadoSensor = estadoSensor;
	}
	
}
