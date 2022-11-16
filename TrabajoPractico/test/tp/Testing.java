package tp;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Testing {

	@Test
	public void queSeCreeUnaPersonaConUnaListaDeMateriasYListaDeTemas() {

		/* Creamos a la persona */

		Persona persona = new Persona("Juan", 1);

		/* Nos fijamos que exista la persona */

		assertNotNull(persona);

		/* Creamos las materias y los temas de las mismas */

		Materia mat = new Materia(1, "matematica");
		Materia progra = new Materia(2, "programacion");

		Tema tema2 = new Tema(2, "Java");
		Tema tema = new Tema(1, "Polinomios");

		/* Agregamos todo a nuestro objeto persona */

		persona.agregarMateria(mat);
		persona.agregarMateria(progra);

		persona.agregarTemaAMateria(tema, mat);
		persona.agregarTemaAMateria(tema2, progra);

		/* Corroboramos que nuestra persona tenga 2 materias */

		Integer valorEsperado = 2;
		Integer valorObtenido = persona.getMaterias().size();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queSePuedaSerializar() {

		Tema tema = new Tema(1, "Polinomios");
		Tema tema2 = new Tema(2, "Java");

		Materia matematica = new Materia(1, "matematica");
		Materia programacion = new Materia(2, "programacion");

		Persona persona = new Persona("Juan", 1);

		persona.agregarMateria(matematica);
		persona.agregarMateria(programacion);

		persona.agregarTemaAMateria(tema, matematica);
		persona.agregarTemaAMateria(tema2, programacion);

		Boolean esperado = false;

		/*
		 * Declaramos e inicializamos un OutputStream para escribir datos en un archivo
		 * externo
		 */

		FileOutputStream fos = null;

		/*
		 * Declaramos e inicializamos el objeto que nos permitira escribir datos en el
		 * OutputStream que declaramos previamente, unicamente vamos a poder escribir
		 * objetos y tipos de datos que implementen la clase Serializable
		 */

		ObjectOutputStream oos = null;

		/*
		 * Creamos una nueva instancia de OutputStream indicandole el path (ubicacion)
		 * del archivo, si existe lo captura y si no, lo crea en el momento, caso
		 * contrario lanzara una excepcion de no encontrar la ubicacion o no poder crear
		 * el archivo por alguna razon.
		 */
		try {
			fos = new FileOutputStream("C:\\Users\\ale_e\\Desktop\\ARCHIVOS_TP_PB2\\ArchivoDestinoSerializable.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * Creamos una nueva instancia del ObjectOutputStream y le enviamos el
		 * OutputStream que instanciamos antes (fos)
		 */

		try {
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * Con nuestro oos, utilizamos el metodo writeObject para escribir el objeto que
		 * le estamos enviando dentro del archivo
		 */

		try {
			oos.writeObject(persona);

			esperado = true; // si llega hasta esta linea, el objeto fue escrito
								// correctamente dentro de nuestro archivo.
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * Cerramos los streams previamente usados
		 */

		try {
			fos.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try {
			oos.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		assertTrue(esperado);

	}

	@Test
	public void queSePuedaDeserealizar() {

		/*
		 * Declaramos el objeto persona donde guardaremos lo que obtengamos del archivo,
		 * y esta vez declaramos streams de tipo input, porque vamos a estar retornando
		 * los valores que guardamos en el anterior test
		 */

		Persona persona = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Boolean esperado = false;

		/*
		 * Instanciamos nuestro InputStream indicandole el archivo con el que vamos a
		 * trabajar
		 */

		try {
			fis = new FileInputStream(("C:\\Users\\ale_e\\Desktop\\ARCHIVOS_TP_PB2\\ArchivoDestinoSerializable.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * Instanciamos el objeto que nos va a permitir leer de nuestro input,
		 * indicandole el mismo
		 */

		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * Leemos el objeto contenido en nuestro archivo y lo asignamos a nuestro objeto
		 * persona que declaramos al comienzo, realizando un casteo a la clase del mismo
		 */

		try {
			persona = (Persona) ois.readObject();
			esperado = true;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * Mostramos nuestro objeto persona para corroborar que la deserealizacion sea
		 * exitosa
		 */

		assertNotNull(persona);
		
		System.out.println(persona.toString());
		assertTrue(esperado);
	}

	@Test
	public void queSePuedaSerializarConGson() {

		/* Construimos nuestro objeto persona como en los anteriores test */

		Boolean esperado = false;
		Tema tema = new Tema(1, "Polinomios");
		Tema tema2 = new Tema(2, "Java");

		Materia mat = new Materia(1, "matematica");
		Materia progra = new Materia(2, "programacion");

		Persona persona = new Persona("Juan", 1);

		persona.agregarMateria(mat);
		persona.agregarMateria(progra);

		persona.agregarTemaAMateria(tema, mat);
		persona.agregarTemaAMateria(tema2, progra);

		/*
		 * Declaramos un objeto tipo Gson e instanciamos un GsonBuilder:
		 * 
		 * -- setPrettyPrinting() lo utilizamos para poder dejar el codigo identado y
		 * legible
		 * 
		 * --serializeNulls() se utiliza para serializar alguna instancia nula dentro de
		 * nuestro objeto, si no es definida, el atributo que sea nulo no va a estar
		 * presente en nuestro archivo
		 * 
		 * -- create() para crear la instancia de gson basandose en la configuracion
		 * establecida
		 */

		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

		/*
		 * Declaramos un writer de tipo FileWriter para poder escribir en el path
		 * (ubicacion) que le enviamos
		 */

		Writer writer = null;

		/*
		 * Instanciamos nuestro writer para poder acceder al archivo donde guardaremos
		 * nuestro JSON string
		 */

		try {
			writer = new FileWriter("C:\\Users\\ale_e\\Desktop\\ARCHIVOS_TP_PB2\\ArchivoDestinoJSON.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		/*
		 * Utilizando nuestro objeto Gson instanciado anteriormente, utilizamos el
		 * metodo toJson y le enviamos el objeto a serializar y nuestro writer, para que
		 * sepa donde escribir el objeto.
		 */

		gson.toJson(persona, writer);

		/* Cerramos el stream de nuestro archivo */

		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		esperado = true;

		assertTrue(esperado);

	}

	@Test
	public void queSePuedaDeserializarGson() {
		Boolean esperado = false;
		Persona persona = null;

		/* Creamos nuestro Gson builder nuevamente, al igual que cuando serializamos */

		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

		Reader reader = null;

		/*
		 * Previo al try, declaramos un objeto de tipo Reader para luego instanciarlo,
		 * especificando el path (ubicacion) del cual obtendremos el JSON a deserealizar
		 */

		try {
			reader = new FileReader("C:\\Users\\ale_e\\Desktop\\ARCHIVOS_TP_PB2\\ArchivoDestinoJSON.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * Con nuestro GsonBuilder instanciado anteriormente, utilizamos el metodo
		 * fromJson para obtener el JSON Element contenido en el reader, especificamos
		 * el reader mismo que utilizaremos y el tipo de clase que vamos a obtener. Con
		 * todo esto, lo asignamos a una variable de tipo Persona inicializada al
		 * comienzo
		 */

		persona = gson.fromJson(reader, Persona.class);

		/* Cerramos el stream de nuestro archivo */

		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		/*
		 * Mostramos nuestra persona con su metodo toString() para corroborar que no
		 * haya perdida de informacion
		 */

		assertNotNull(persona);
		
		System.out.println(persona.toString());

		esperado = true;

		assertTrue(esperado);
	}

	@Test
	public void queSePuedaSerializarJackson() {

		/*
		 * Declaramos, instanciamos y creamos nuevamente nuestro objeto persona como en
		 * los anteriores test
		 */

		Boolean esperado = false;

		Tema tema = new Tema(1, "Polinomios");
		Tema tema2 = new Tema(2, "Java");

		Materia mat = new Materia(1, "matematica");
		Materia progra = new Materia(2, "programacion");

		Persona persona = new Persona("Juan", 1);

		persona.agregarMateria(mat);
		persona.agregarMateria(progra);

		persona.agregarTemaAMateria(tema, mat);
		persona.agregarTemaAMateria(tema2, progra);

		/*
		 * Utilizando Jackson, vamos a declarar e instanciar un XmlMapper, el cual nos
		 * permitira realizar la serializacion de nuestro objeto a XML
		 * 
		 * Debemos utilizar el metodo enable para habilitar la indentacion del output,
		 * para que el formato sea comprensible y no se vea todo en una misma linea
		 * 
		 * El metodo configure que esta comentado, permite que si por alguna razon
		 * alguno de nuestros elementos no tiene los getters y setters definidos, el
		 * objeto se pueda serializar de todas maneras, pero los campos de estos
		 * atributos van a estar vacios en el XML resultante (por ende al deserealizar,
		 * vamos a obtener nulos)
		 */

		XmlMapper xmlMapper = new XmlMapper();
//		xmlMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

		/*
		 * Nuevamente declaramos e instanciamos nuestro FileWriter para acceder al
		 * archivo que contendra el objeto serializado a XML
		 */

		Writer writer = null;

		try {
			writer = new FileWriter("C:\\Users\\ale_e\\Desktop\\ARCHIVOS_TP_PB2\\ArchivoDestinoXML.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * Con nuestro xmlMapper creado anteriormente, utilizamos el método writeValue
		 * para poder escribir en el archivo y le enviamos el writer instanciado
		 * anteriormente y el objeto que queremos serializar
		 */

		try {
			xmlMapper.writeValue(writer, persona);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		/* Cerramos el stream de nuestro archivo */

		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		esperado = true;
		assertTrue(esperado);
	}

	@Test
	public void queSePuedaDeserializarJackson() {
		Boolean esperado = false;

		/*
		 * Anterior a cualquier proceso de deserealizacion con JACKSON, se debe
		 * corroborar que todos los objetos que van a formar parte de la
		 * deserealizacion, posean los constructores por defecto (asi se especifica en
		 * la guia de utilizacion de JACKSON al deserealizar xml desde un archivo)
		 */

		/* Declaramos el objeto de tipo Persona donde guardaremos los datos recibidos */

		Persona personaRecibida = null;

		/* Nuevamente declaramos nuestro objeto XmlMapper */

		XmlMapper xmlMapper = new XmlMapper();
//		xmlMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		/*
		 * Declaramos, inicializamos e instanciamos nuestro objeto reader como lo hemos
		 * hecho anteriormente
		 */

		Reader reader = null;

		try {
			reader = new FileReader("C:\\Users\\ale_e\\Desktop\\ARCHIVOS_TP_PB2\\ArchivoDestinoXML.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * A traves de nuestro XmlMapper, utilizamos el metodo readValue para poder leer
		 * el archivo, enviandole en sus parametros nuestro reader y el tipo de clase
		 * que esperamos obtener.
		 * 
		 * Todo esto lo asignamos a la variable persona declarada en un comienzo
		 */

		try {
			personaRecibida = xmlMapper.readValue(reader, Persona.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		/* Cerramos el stream de nuestro archivo */

		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		esperado = true;

		/*
		 * Mostramos el objeto que recibimos desde el archivo para corroborar que no
		 * haya perdida de informacion
		 */

		assertNotNull(personaRecibida);
		
		System.out.println(personaRecibida.toString());

		assertTrue(esperado);

	}

}
