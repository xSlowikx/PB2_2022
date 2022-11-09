package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class pruebita {

	private Map<Integer, Figura> figurasMap;
	private List<Figura> figurasColl;
	private Set<Figura> figurasSet;

	public pruebita() {
		this.figurasMap = new LinkedHashMap<>();
		this.figurasColl = new ArrayList<>();
		this.figurasSet = new TreeSet<>();
	}

	public void añadirFigura(Integer key, Figura figura) {
		this.figurasMap.put(key, figura);
	}

	public void añadirFigura(Figura figura) {
		this.figurasColl.add(figura);
	}

	public void añadirFiguraSet(Figura figura) {
		this.figurasSet.add(figura);
	}

	public Map<Integer, Figura> getFigurasMap() {
		return figurasMap;
	}

	public void setFigurasMap(Map<Integer, Figura> figurasMap) {
		this.figurasMap = figurasMap;
	}

	public List<Figura> getFigurasColl() {
		return figurasColl;
	}

	public void setFigurasColl(List<Figura> figurasColl) {
		this.figurasColl = figurasColl;
	}

	public Set<Figura> getFigurasSet() {
		return figurasSet;
	}

	public void setFigurasSet(Set<Figura> figurasSet) {
		this.figurasSet = figurasSet;
	}

	public void ordenarMostrarMapaDeFigurasOrdenadas() {
		// TODO Auto-generated method stub
		
//		Set<Entry<Integer,Figura>> mapMetidoEnSet = figurasMap.entrySet();
		
		//Metemos nuestro LinkedHashMap dentro de una lista que reciba el entry.
		List<Entry<Integer,Figura>> mapMetidoEnList = new ArrayList <>(figurasMap.entrySet());
		
		Collections.sort(mapMetidoEnList, new ordenarMapaPorValoresDeFigura());
		
		//Ordenamos nuestra lista segun el implements comparable y el override del compareTo
//		mapMetidoEnList.sort(Entry.comparingByValue());
		
		//Borramos el mapa actual
		figurasMap.clear();
		
		//Reemplazamos el mapa con los valores de la lista, al ser un linkedhashmap va a insertarse como venga de la lista
		for (Entry<Integer,Figura> recorridoDeLaLista : mapMetidoEnList) {
			figurasMap.put(recorridoDeLaLista.getKey(), recorridoDeLaLista.getValue());
		}
		
		//Mostramos la lista
		for (Entry<Integer,Figura> recorridoDeLaLista : mapMetidoEnList) {
			System.out.println(recorridoDeLaLista.getKey() + "\t" + recorridoDeLaLista.getValue());
		}
		
//		System.out.println(figurasMap.toString());
		
		//Mostramos el mapa
		
		Iterator it = figurasMap.keySet().iterator();
		while(it.hasNext()){
		  Integer key = (Integer) it.next();
		  System.out.println("Clave: " + key + " -> Valor: " + figurasMap.get(key));
		}
	}

}
