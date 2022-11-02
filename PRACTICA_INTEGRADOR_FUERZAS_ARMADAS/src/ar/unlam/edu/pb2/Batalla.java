package ar.unlam.edu.pb2;

import java.util.HashSet;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Batalla {

	private String nombreBatalla;
	private TreeMap<Integer,Ejercito> ejercitosDefensores;
	private TreeMap<Integer,Ejercito> ejercitosAtacantes;
	private TipoDeBatalla tipoDeBatalla;

	public Batalla(String nombreBatalla) {
		// TODO Auto-generated constructor stub
		this.nombreBatalla = nombreBatalla;
		this.ejercitosDefensores = new TreeMap<>();
		this.ejercitosAtacantes = new TreeMap<>();
	}

	public Batalla(String nombreBatalla, TipoDeBatalla tipoDeBatalla) {
		// TODO Auto-generated constructor stub
		this.nombreBatalla = nombreBatalla;
		this.ejercitosDefensores = new TreeMap<>();
		this.ejercitosAtacantes = new TreeMap<>();
		this.tipoDeBatalla = tipoDeBatalla;
	}

	public void agregarDefensor(Integer codigoPais, Ejercito ejercitoDefensor) throws EjercitoYaAsignadoALaDefensaException {
		// TODO Auto-generated method stub
		if(ejercitosDefensores.containsKey(codigoPais)) {
			throw new EjercitoYaAsignadoALaDefensaException ("Este ejercito ya se encuentra dentro de la lista de defensores");
		}
		ejercitosDefensores.put(codigoPais, ejercitoDefensor);
		
	}

	public void agregarAtacante(Integer codigoPais, Ejercito ejercitoAtacante) throws EjercitoYaAsignadoAlAtaqueException {
		// TODO Auto-generated method stub
		if(ejercitosAtacantes.containsKey(codigoPais)) {
			throw new EjercitoYaAsignadoAlAtaqueException ("Este ejercito ya se encuentra dentro de la lista de atacantes");
		}
		ejercitosAtacantes.put(codigoPais, ejercitoAtacante);
		
	}

}
