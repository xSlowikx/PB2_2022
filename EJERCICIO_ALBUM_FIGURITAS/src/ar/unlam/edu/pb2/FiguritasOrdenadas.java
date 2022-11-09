package ar.unlam.edu.pb2;

import java.util.Comparator;
import java.util.Map.Entry;

public class FiguritasOrdenadas implements Comparator <Entry<String, Figurita>> {

	@Override
	public int compare(Entry <String, Figurita> figurita1, Entry <String, Figurita> figurita2) {
		// TODO Auto-generated method stub
		int ordenador = figurita1.getValue().getGrupo().compareTo(figurita2.getValue().getGrupo());
		if( ordenador == 0) {
			ordenador = figurita1.getValue().getPaisOrigen().compareTo(figurita2.getValue().getPaisOrigen());
			if(ordenador == 0) {
				ordenador = figurita1.getValue().getNumeroFigurita().compareTo(figurita2.getValue().getNumeroFigurita());
			}
		}
		return ordenador;
	}

}
