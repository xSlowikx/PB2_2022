package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTurismo {

	@Test
	public void test() {
		Secretaria nuevaSecretaria = new Secretaria ("Rio Cuarto");
		nuevaSecretaria.agregarVivienda(0001,"Lafayette",2793,"Rafael Castillo",1755);
		nuevaSecretaria.agregarHabitanteEnUnaVivienda(0001,"DNI",41823462,"Alejandro","Rios","29/03/1999");
		
	}

}
