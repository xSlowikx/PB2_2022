package ar.edu.unlam.pb2.dominio;

import java.util.Comparator;
import java.util.Map.Entry;

public class ordenarMapaPorValoresDeFigura implements Comparator<Entry<Integer,Figura>> {

	@Override
	public int compare(Entry<Integer, Figura> figura1, Entry<Integer, Figura> figura2) {
		// TODO Auto-generated method stub
		int variableAuxiliar = figura1.getValue().getCuadrante().compareTo(figura2.getValue().getCuadrante());
		if (variableAuxiliar == 0) {
			variableAuxiliar = figura1.getValue().getNombre().compareTo(figura2.getValue().getNombre());
			if (variableAuxiliar == 0) {
				variableAuxiliar = figura1.getValue().getMedidas().compareTo(figura2.getValue().getMedidas());
			}
		}
		return variableAuxiliar;
	}

}
