package ar.edu.unlam.pb2.dominio;

import java.util.Comparator;
import java.util.Map.Entry;

public class ordenarPorKeyDescendente implements Comparator<Entry<Integer, Figura>>{
	
	@Override
	public int compare(Entry<Integer, Figura> figura1, Entry<Integer, Figura> figura2) {
		return (figura1.getKey().compareTo(figura2.getKey())) * -1;
	}
	
}
