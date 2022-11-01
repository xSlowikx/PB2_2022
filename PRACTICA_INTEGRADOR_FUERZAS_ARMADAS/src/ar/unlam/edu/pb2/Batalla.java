package ar.unlam.edu.pb2;

import java.util.HashSet;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Batalla {

	private String nombreBatalla;
	private HashSet<Ejercito> ejercitosDefensores;
	private HashSet<Ejercito> ejercitosAtacantes;
	private TipoDeBatalla tipoDeBatalla;

	public Batalla(String nombreBatalla) {
		// TODO Auto-generated constructor stub
		this.nombreBatalla = nombreBatalla;
		this.ejercitosDefensores = new HashSet<>();
		this.ejercitosAtacantes = new HashSet<>();
	}

	public Batalla(String string, TipoDeBatalla tipoDeBatalla) {
		// TODO Auto-generated constructor stub
		this.nombreBatalla = nombreBatalla;
		this.ejercitosDefensores = new HashSet<>();
		this.ejercitosAtacantes = new HashSet<>();
		this.tipoDeBatalla = tipoDeBatalla;
	}

	public void agregarDefensor(Ejercito ejercitoDefensor) {
		// TODO Auto-generated method stub
		ejercitosDefensores.add(ejercitoDefensor);
		
	}

	public void agregarAtacante(Ejercito ejercitoAtacante) {
		// TODO Auto-generated method stub
		ejercitosAtacantes.add(ejercitoAtacante);
		
	}

}
