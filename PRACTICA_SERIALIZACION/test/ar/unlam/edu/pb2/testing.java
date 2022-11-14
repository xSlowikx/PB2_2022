package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Collections;

import org.junit.Test;

import com.google.gson.*;

public class testing {

	@Test
	public void testQueExistaElFichero() {
		Fichero ficheroCentral = new Fichero("A1");
		assertNotNull(ficheroCentral);
	}

	@Test
	public void testQueElFicheroTengaUnaListaDeCarpetas() {
		Fichero ficheroCentral = new Fichero("EMPLEADOS");
		Carpeta nuevaCarpeta = new Carpeta(Area.MANTENIMIENTO);

		try {
			ficheroCentral.agregarNuevaCarpeta(nuevaCarpeta);
		} catch (CarpetaYaColocadaEnElFicheroException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Integer valorEsperado = 1;
		Integer valorObtenido = ficheroCentral.getRegistroDeCarpetas().size();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void testQueSePuedaAgregarUnRegistroDeEmpleadoDeMantenimientoALaCarpetaCorrespondiente() {
		Fichero ficheroCentral = new Fichero("EMPLEADOS");
		Carpeta nuevaCarpeta = new Carpeta(Area.MANTENIMIENTO);

		try {
			ficheroCentral.agregarNuevaCarpeta(nuevaCarpeta);
		} catch (CarpetaYaColocadaEnElFicheroException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Empleado nuevoEmpleadoMantenimiento = new Empleado(5150, "Ernesto Guevara", Area.MANTENIMIENTO,
				LocalDate.of(2022, 3, 25));
		try {
			ficheroCentral.agregarNuevoRegistroDeEmpleado(nuevoEmpleadoMantenimiento, nuevaCarpeta);
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Integer valorEsperado = 1;
		Integer valorObtenido = null;
		try {
			valorObtenido = ficheroCentral.obtenerRegistrosDeUnaCarpeta(Area.MANTENIMIENTO).size();
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void testQueSePuedanAgregarCincoRegistrosYTransformarSerializarLaCarpeta() {

		Fichero ficheroCentral = new Fichero("EMPLEADOS");
		Carpeta nuevaCarpeta = new Carpeta(Area.MANTENIMIENTO);

		try {
			ficheroCentral.agregarNuevaCarpeta(nuevaCarpeta);
		} catch (CarpetaYaColocadaEnElFicheroException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Empleado nuevoEmpleadoMantenimiento = new Empleado(5150, "Ernesto Guevara", Area.MANTENIMIENTO,
				LocalDate.of(2022, 3, 25));
		Empleado nuevoEmpleadoMantenimiento2 = new Empleado(2340, "Pedro Rueda", Area.MANTENIMIENTO,
				LocalDate.of(2022, 3, 25));
		Empleado nuevoEmpleadoMantenimiento3 = new Empleado(2241, "Jorge Evaris", Area.MANTENIMIENTO,
				LocalDate.of(2022, 3, 25));
		Empleado nuevoEmpleadoMantenimiento4 = new Empleado(6984, "Miguel Aranda", Area.MANTENIMIENTO,
				LocalDate.of(2022, 3, 25));
		Empleado nuevoEmpleadoMantenimiento5 = new Empleado(6195, "Gonzales Smith", Area.MANTENIMIENTO,
				LocalDate.of(2022, 3, 25));

		try {
			ficheroCentral.agregarNuevoRegistroDeEmpleado(nuevoEmpleadoMantenimiento, nuevaCarpeta);
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			ficheroCentral.agregarNuevoRegistroDeEmpleado(nuevoEmpleadoMantenimiento2, nuevaCarpeta);
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			ficheroCentral.agregarNuevoRegistroDeEmpleado(nuevoEmpleadoMantenimiento3, nuevaCarpeta);
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			ficheroCentral.agregarNuevoRegistroDeEmpleado(nuevoEmpleadoMantenimiento4, nuevaCarpeta);
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			ficheroCentral.agregarNuevoRegistroDeEmpleado(nuevoEmpleadoMantenimiento5, nuevaCarpeta);
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		FileOutputStream archivoContenedor = null;
		ObjectOutputStream objetoSerializable = null;

		try {
			archivoContenedor = new FileOutputStream(
					"C:\\Users\\Slowik\\Desktop\\Programacion Basica II\\archivoDestino.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			objetoSerializable = new ObjectOutputStream(archivoContenedor);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

		try {
			objetoSerializable.writeObject(ficheroCentral);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

		try {
			archivoContenedor.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		try {
			objetoSerializable.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}

		Integer valorEsperado = 5;
		Integer valorObtenido = null;

		try {
			valorObtenido = ficheroCentral.obtenerRegistrosDeUnaCarpeta(Area.MANTENIMIENTO).size();
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void testQueSePuedaObtenerElObjetoSerializado() {

		FileInputStream archivoRecibido = null;
		ObjectInputStream objetoRecibido = null;

		try {
			archivoRecibido = new FileInputStream(
					"C:\\Users\\Slowik\\Desktop\\Programacion Basica II\\archivoDestino.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			objetoRecibido = new ObjectInputStream(archivoRecibido);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Fichero ficheroRecibido = null;

		try {
			ficheroRecibido = (Fichero) objetoRecibido.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		for (Carpeta recorridoCarpetas : ficheroRecibido.getRegistroDeCarpetas()) {

			System.out.println("Carpeta del area " + recorridoCarpetas.getAreaEstablecida()
					+ ", mostrando registros de empleados ordenados por codigo: ");

			Collections.sort(recorridoCarpetas.getRegistrosDeEmpleado());

			for (Empleado recorridoEmpleados : recorridoCarpetas.getRegistrosDeEmpleado()) {
				System.out.println(recorridoEmpleados);
			}
		}

	}

	@Test
	public void testQueSePuedaSerializarYDeserealizarConGson() {

		Fichero ficheroCentral = new Fichero("EMPLEADOS");
		Carpeta nuevaCarpeta = new Carpeta(Area.MANTENIMIENTO);

		try {
			ficheroCentral.agregarNuevaCarpeta(nuevaCarpeta);
		} catch (CarpetaYaColocadaEnElFicheroException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Empleado nuevoEmpleadoMantenimiento = new Empleado(5150, "Ernesto Guevara", Area.MANTENIMIENTO,
				LocalDate.of(2022, 3, 25));
		Empleado nuevoEmpleadoMantenimiento2 = new Empleado(2340, "Pedro Rueda", Area.MANTENIMIENTO,
				LocalDate.of(2022, 3, 25));
		Empleado nuevoEmpleadoMantenimiento3 = new Empleado(2241, "Jorge Evaris", Area.MANTENIMIENTO,
				LocalDate.of(2022, 3, 25));
		Empleado nuevoEmpleadoMantenimiento4 = new Empleado(6984, "Miguel Aranda", Area.MANTENIMIENTO,
				LocalDate.of(2022, 3, 25));
		Empleado nuevoEmpleadoMantenimiento5 = new Empleado(6195, "Gonzales Smith", Area.MANTENIMIENTO,
				LocalDate.of(2022, 3, 25));

		try {
			ficheroCentral.agregarNuevoRegistroDeEmpleado(nuevoEmpleadoMantenimiento, nuevaCarpeta);
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			ficheroCentral.agregarNuevoRegistroDeEmpleado(nuevoEmpleadoMantenimiento2, nuevaCarpeta);
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			ficheroCentral.agregarNuevoRegistroDeEmpleado(nuevoEmpleadoMantenimiento3, nuevaCarpeta);
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			ficheroCentral.agregarNuevoRegistroDeEmpleado(nuevoEmpleadoMantenimiento4, nuevaCarpeta);
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			ficheroCentral.agregarNuevoRegistroDeEmpleado(nuevoEmpleadoMantenimiento5, nuevaCarpeta);
		} catch (CarpetaDelAreaEspecificadaNoEncontradaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Gson nuevoGson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		String jSonRecibido = nuevoGson.toJson(ficheroCentral);

		System.out.println(jSonRecibido);

		Fichero ficheroRecibidoDelJsonString = nuevoGson.fromJson(jSonRecibido, Fichero.class);

		System.out.println("\nFichero: " + ficheroRecibidoDelJsonString.getIdentificacionFichero());

		for (Carpeta carpetasEncontradas : ficheroRecibidoDelJsonString.getRegistroDeCarpetas()) {

			System.out.println("Carpeta encontrada: " + carpetasEncontradas.getAreaEstablecida());

			System.out.println("Registros de empleados declarados: " + "\n");

			for (Empleado registrosEncontrados : carpetasEncontradas.getRegistrosDeEmpleado()) {

				System.out.println(registrosEncontrados);
			}

		}

		FileWriter nuevoFileWriter = null;

		try {
			nuevoFileWriter = new FileWriter(
					"C:\\Users\\Slowik\\Desktop\\Programacion Basica II\\archivoDestinoJsonPrueba.txt");
			nuevoGson.toJson(ficheroCentral, nuevoFileWriter);
			nuevoFileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		FileReader nuevoFileReader = null;
		Fichero objetoFicheroLeidoDeLTxt = null;

		try {
			nuevoFileReader = new FileReader(
					"C:\\Users\\Slowik\\Desktop\\Programacion Basica II\\archivoDestinoJsonPrueba.txt");

			objetoFicheroLeidoDeLTxt = nuevoGson.fromJson(nuevoFileReader, Fichero.class);

			System.out.println("\n" + objetoFicheroLeidoDeLTxt);

			nuevoFileReader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
