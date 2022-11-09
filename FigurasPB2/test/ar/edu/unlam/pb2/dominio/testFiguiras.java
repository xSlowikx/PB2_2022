package ar.edu.unlam.pb2.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class testFiguiras {

	@Test
	public void queSeMuestreUnaColeccion() {
		pruebita prueba = new pruebita();
		Figura cuadrado = new Cuadrado("cuadrado", 12.3, null);
		Figura cuadrado2 = new Cuadrado("cuadrado2", 12.2, null);
		Figura triangulo = new Triangulo("triangulo", 10.1, null);
		prueba.añadirFigura(2, triangulo);
		prueba.añadirFigura(1, cuadrado);
		prueba.añadirFigura(3, cuadrado2);
		Integer valorEsperado = 3;
		Integer valorObtenido = prueba.getFigurasMap().size();
		Map<Integer, Figura> mapaFiguras = prueba.getFigurasMap();
		for (Map.Entry<Integer, Figura> entry : mapaFiguras.entrySet()) {
			System.out.println("Figura: " + entry.getKey() + "Valor: " + entry.getValue().toString());
		}
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queSeMuestreElMapOrdenadoPorKey() {
		pruebita prueba = new pruebita();
		Figura cuadrado = new Cuadrado("cuadrado", 12.3, null);
		Figura cuadrado2 = new Cuadrado("cuadrado2", 12.2, null);
		Figura triangulo = new Triangulo("triangulo", 10.1, null);
		prueba.añadirFigura(2, triangulo);
		prueba.añadirFigura(1, cuadrado);
		prueba.añadirFigura(3, cuadrado2);
		Set<Entry<Integer, Figura>> entrySet = prueba.getFigurasMap().entrySet();
		List<Entry<Integer, Figura>> listaDondeVaElSet = new ArrayList<>(entrySet);
		Collections.sort(listaDondeVaElSet, new ordenarPorKeyDescendente());

//		listaDondeVaElSet.forEach(recorrido -> {
//			System.out.println(recorrido.getKey() + "\t" + recorrido.getValue());
//		});

		for (Entry<Integer, Figura> entryActual : listaDondeVaElSet) {
			System.out.println(entryActual.getKey() + "\t" + entryActual.getValue());
		}
	}

	@Test
	public void queSeMuestreUnSetOrdenadoPorNombre() {

		pruebita prueba = new pruebita();

		Figura cuadrado = new Cuadrado("Cuadrado", 12.3, "1");
		Figura cuadrado2 = new Cuadrado("Cuadrado", 15.0, "2");
		Figura triangulo = new Triangulo("Triangulo", 13.51, "4");
		Figura cuadrado3 = new Cuadrado("Cuadrado", 16.2, "4");
		Figura cuadrado4 = new Cuadrado("Cuadrado", 15.1, "4");
		Figura cuadrado5 = new Cuadrado("Cuadrado", 81.5, "3");
		Figura triangulo2 = new Triangulo("Triangulo", 55.1, "3");
		Figura triangulo3 = new Triangulo("Triangulo", 60.13, "1");
		Figura triangulo4 = new Triangulo("Triangulo", 15.12, "1");
		Figura triangulo5 = new Triangulo("Triangulo", 19.51, "3");

		prueba.añadirFiguraSet(triangulo);
		prueba.añadirFiguraSet(cuadrado);
		prueba.añadirFiguraSet(triangulo2);
		prueba.añadirFiguraSet(cuadrado2);
		prueba.añadirFiguraSet(triangulo3);
		prueba.añadirFiguraSet(cuadrado3);
		prueba.añadirFiguraSet(triangulo4);
		prueba.añadirFiguraSet(cuadrado4);
		prueba.añadirFiguraSet(triangulo5);
		prueba.añadirFiguraSet(cuadrado5);

		Set<Figura> figurasSet = prueba.getFigurasSet();
		List<Figura> listaParaSet = new ArrayList<>(figurasSet);

		Collections.sort(listaParaSet);

		for (Figura figura : listaParaSet) {
			System.out.println(figura.toString());
		}

		Integer valorEsperado = 10;
		Integer valorObtenido = prueba.getFigurasSet().size();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void testQueSeMuestreElMapOrdenadoPorValue() {
		pruebita prueba = new pruebita();

		Figura cuadrado = new Cuadrado("Cuadrado", 12.3, "1");
		Figura cuadrado2 = new Cuadrado("Cuadrado", 15.0, "2");
		Figura triangulo = new Triangulo("Triangulo", 13.51, "4");
		Figura cuadrado3 = new Cuadrado("Cuadrado", 16.2, "4");
		Figura cuadrado4 = new Cuadrado("Cuadrado", 15.1, "4");
		Figura cuadrado5 = new Cuadrado("Cuadrado", 81.5, "3");
		Figura triangulo2 = new Triangulo("Triangulo", 55.1, "3");
		Figura triangulo3 = new Triangulo("Triangulo", 60.13, "1");
		Figura triangulo4 = new Triangulo("Triangulo", 15.12, "1");
		Figura triangulo5 = new Triangulo("Triangulo", 19.51, "3");

		prueba.añadirFigura(2,cuadrado);
		prueba.añadirFigura(7,triangulo4);
		prueba.añadirFigura(4,cuadrado2);
		prueba.añadirFigura(5,triangulo3);
		prueba.añadirFigura(1,triangulo);
		prueba.añadirFigura(10,cuadrado5);
		prueba.añadirFigura(6,cuadrado3);
		prueba.añadirFigura(3,triangulo2);
		prueba.añadirFigura(8,cuadrado4);
		prueba.añadirFigura(9,triangulo5);
		
		prueba.ordenarMostrarMapaDeFigurasOrdenadas();
	}

}
