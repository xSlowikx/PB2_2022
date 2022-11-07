package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class testing {

	@Test
	public void testQueSePuedaCrearUnAlbum() {
		try {
			assertNotNull(crearAlbum());
		} catch (NoSePuedeCrearElAlbumException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testQueSePuedaCrearUnaFigurita() {
		try {
			assertNotNull(crearAlbum());
		} catch (NoSePuedeCrearElAlbumException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Figurita nuevaFigurita = new Figurita(1, 'C', Pais.ARGENTINA, "Leandro Paredes", 45000000.0);
		assertNotNull(nuevaFigurita);
	}

	@Test
	public void testQueSePuedaCrearUnAdministrador() {
		Usuario nuevoAdministrador = new Administrador("Pep Guardiola");
		assertNotNull(nuevoAdministrador);
	}

	@Test
	public void testQueSePuedaCrearUnUsuarioFinal() {
		Usuario nuevoAdministrador = new UsuarioFinal("Coscu");
		assertNotNull(nuevoAdministrador);
	}

	@Test
	public void testQueUnAdministradorPuedaAgregarUnaFigurita() {
		Album nuevoAlbum = new Album();
		Usuario nuevoAdministrador = new Administrador("Pep Guardiola");
		Figurita nuevaFigurita = new Figurita(1, 'C', Pais.ARGENTINA, "Leandro Paredes", 45000000.0);
		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevoAlbum.getListaDeFiguritas().size();
	}

	@Test
	public void testQueUnUsuarioFinalPuedaAgregarUnaFigurita() {

		Album nuevoAlbum = new Album();
		Usuario nuevoAdministrador = new Administrador("Pep Guardiola");
		Usuario nuevoUsuarioFinal = new UsuarioFinal("Ricardo Moyo");

		Figurita nuevaFigurita = new Figurita(5, 'C', Pais.ARGENTINA, "Leandro Paredes", 45000000.0);
		Figurita nuevaFigurita2 = new Figurita(27, 'C', Pais.ARGENTINA, "Guido Rodriguez", 25000000.0);
		Figurita nuevaFigurita3 = new Figurita(9, 'C', Pais.ARGENTINA, "Lautaro Martinez", 100000000.0);
		Figurita nuevaFigurita4 = new Figurita(1, 'C', Pais.ARGENTINA, "Emiliano Martinez", 50000000.0);
		Figurita nuevaFigurita5 = new Figurita(21, 'C', Pais.ARGENTINA, "Paulo Dybala", 150000000.0);

		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita2, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita3, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita4, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita5, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			nuevoUsuarioFinal.agregarFigurita(nuevaFigurita3, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Integer valorEsperado = 1;
		Integer valorObtenido = ((UsuarioFinal) nuevoUsuarioFinal).getColeccionDeFiguritas().size();
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void testQueLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() {

	}

	@Test
	public void testQueUnAdministradorNoPuedaAgregarUnaFiguritaExistente() {
		Album nuevoAlbum = new Album();
		Usuario nuevoAdministrador = new Administrador("Pep Guardiola");

		Figurita nuevaFigurita = new Figurita(5, 'C', Pais.ARGENTINA, "Leandro Paredes", 45000000.0);
		Figurita nuevaFigurita2 = new Figurita(27, 'C', Pais.ARGENTINA, "Guido Rodriguez", 25000000.0);
		Figurita nuevaFigurita3 = new Figurita(9, 'C', Pais.ARGENTINA, "Lautaro Martinez", 100000000.0);

		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita3, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita3, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Integer valorEsperado = 2;
		Integer valorObtenido = nuevoAlbum.getListaDeFiguritas().size();
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void testqueUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() {
		Album nuevoAlbum = new Album();
		Usuario nuevoAdministrador = new Administrador("Pep Guardiola");
		Usuario nuevoUsuarioFinal = new UsuarioFinal("Ricardo Moyo");

		Figurita nuevaFigurita = new Figurita(5, 'C', Pais.ARGENTINA, "Leandro Paredes", 45000000.0);
		Figurita nuevaFigurita2 = new Figurita(27, 'C', Pais.ARGENTINA, "Guido Rodriguez", 25000000.0);
		Figurita nuevaFigurita3 = new Figurita(9, 'C', Pais.ARGENTINA, "Lautaro Martinez", 100000000.0);
		Figurita nuevaFigurita4 = new Figurita(1, 'C', Pais.ARGENTINA, "Emiliano Martinez", 50000000.0);

		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita3, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoAdministrador.agregarFigurita(nuevaFigurita2, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoUsuarioFinal.agregarFigurita(nuevaFigurita, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoUsuarioFinal.agregarFigurita(nuevaFigurita3, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoUsuarioFinal.agregarFigurita(nuevaFigurita, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoUsuarioFinal.agregarFigurita(nuevaFigurita4, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Integer valorEsperado = 3;
		Integer valorObtenido = ((UsuarioFinal) nuevoUsuarioFinal).getColeccionDeFiguritas().size();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void testQueUnUsuarioFinalPuedaPegarUnaFigurita()
			throws NoSePuedeCrearElAlbumException, NoSePuedoCrearUnAdministradorException {

		Album nuevoAlbum = crearAlbum();
		Usuario nuevoAdministrador = crearAdministrador();
		for (Figurita recorridoBombo : crearBomboDeFiguritas()) {
			try {
				nuevoAdministrador.agregarFigurita(recorridoBombo, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		Usuario nuevoUsuarioFinal = new UsuarioFinal("Ricardo Moyo");

		for (Figurita recorridoMazoUsuario : crearMazoDeFiguritasDelUsuarioFinal()) {
			try {
				nuevoUsuarioFinal.agregarFigurita(recorridoMazoUsuario, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		for (Figurita recorridoMazoUsuario : ((UsuarioFinal) nuevoUsuarioFinal).getColeccionDeFiguritas()) {
			try {
				((UsuarioFinal) nuevoUsuarioFinal).pegarFigurita(recorridoMazoUsuario, nuevoAlbum);
			} catch (FiguritaNoExistenteEnLaBaseDeDatosException | FiguritaYaPegadaEnElAlbumException
					| NoTenesLaFiguritaQueQueresPegarOIntercambiarException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		Integer valorEsperado = 10;
		Integer valorObtenido = ((UsuarioFinal) nuevoUsuarioFinal).getListaDeFiguritasYaPegadas().size();
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void testQueUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida()
			throws NoSePuedeCrearElAlbumException, NoSePuedoCrearUnAdministradorException {

		Album nuevoAlbum = crearAlbum();
		Usuario nuevoAdministrador = crearAdministrador();
		for (Figurita recorridoBombo : crearBomboDeFiguritas()) {
			try {
				nuevoAdministrador.agregarFigurita(recorridoBombo, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		Usuario nuevoUsuarioFinal = new UsuarioFinal("Ricardo Moyo");

		for (Figurita recorridoMazoUsuario : crearMazoDeFiguritasDelUsuarioFinal()) {
			try {
				nuevoUsuarioFinal.agregarFigurita(recorridoMazoUsuario, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		for (Figurita recorridoMazoUsuario : ((UsuarioFinal) nuevoUsuarioFinal).getColeccionDeFiguritas()) {
			try {
				((UsuarioFinal) nuevoUsuarioFinal).pegarFigurita(recorridoMazoUsuario, nuevoAlbum);
			} catch (FiguritaNoExistenteEnLaBaseDeDatosException | FiguritaYaPegadaEnElAlbumException
					| NoTenesLaFiguritaQueQueresPegarOIntercambiarException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		Figurita nuevaFigurita7 = new Figurita(17, 'C', Pais.ARGENTINA, "Joaquin Correa", 150000000.0);
		Figurita nuevaFigurita8 = new Figurita(4, 'C', Pais.ARGENTINA, "Huevo Acuña", 150000000.0);
		Figurita nuevaFigurita9 = new Figurita(2, 'C', Pais.ARGENTINA, "Cristian Romero", 150000000.0);

		try {
			nuevoUsuarioFinal.agregarFigurita(nuevaFigurita8, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoUsuarioFinal.agregarFigurita(nuevaFigurita7, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoUsuarioFinal.agregarFigurita(nuevaFigurita9, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			((UsuarioFinal) nuevoUsuarioFinal).pegarFigurita(nuevaFigurita7, nuevoAlbum);
		} catch (FiguritaNoExistenteEnLaBaseDeDatosException | FiguritaYaPegadaEnElAlbumException
				| NoTenesLaFiguritaQueQueresPegarOIntercambiarException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			((UsuarioFinal) nuevoUsuarioFinal).pegarFigurita(nuevaFigurita7, nuevoAlbum);
		} catch (FiguritaNoExistenteEnLaBaseDeDatosException | FiguritaYaPegadaEnElAlbumException
				| NoTenesLaFiguritaQueQueresPegarOIntercambiarException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			((UsuarioFinal) nuevoUsuarioFinal).pegarFigurita(nuevaFigurita7, nuevoAlbum);
		} catch (FiguritaNoExistenteEnLaBaseDeDatosException | FiguritaYaPegadaEnElAlbumException
				| NoTenesLaFiguritaQueQueresPegarOIntercambiarException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		Integer valorEsperado = 10;
		Integer valorObtenido = ((UsuarioFinal) nuevoUsuarioFinal).getListaDeFiguritasYaPegadas().size();
		assertEquals(valorEsperado, valorObtenido);

		Integer valorEsperado1 = 13;
		Integer valorObtenido2 = ((UsuarioFinal) nuevoUsuarioFinal).getColeccionDeFiguritas().size();
		assertEquals(valorEsperado1, valorObtenido2);
	}

	@Test
	public void testQueSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales()
			throws NoSePuedeCrearElAlbumException, NoSePuedoCrearUnAdministradorException {

		Album nuevoAlbum = crearAlbum();

		Usuario nuevoAdministrador = crearAdministrador();

		for (Figurita recorridoBombo : crearBomboDeFiguritas()) {
			try {
				nuevoAdministrador.agregarFigurita(recorridoBombo, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		Usuario nuevoUsuarioFinal = new UsuarioFinal("Ricardo Moyo");
		Usuario nuevoUsuarioFinal2 = new UsuarioFinal("Roberto Petinato");

		for (Figurita recorridoMazoUsuario : crearMazoDeFiguritasDelUsuarioFinal()) {
			try {
				nuevoUsuarioFinal.agregarFigurita(recorridoMazoUsuario, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		for (Figurita recorridoMazoUsuario : crearMazoDeFiguritasDelUsuarioFinal2()) {
			try {
				nuevoUsuarioFinal2.agregarFigurita(recorridoMazoUsuario, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		Figurita nuevaFigurita8 = new Figurita(4, 'C', Pais.ARGENTINA, "Huevo Acuña", 150000000.0);
		Figurita nuevaFigurita6 = new Figurita(9, 'E', Pais.ESPAÑA, "Alvaro Morata", 45000000.0);

		try {
			nuevoUsuarioFinal.agregarFigurita(nuevaFigurita8, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoUsuarioFinal2.agregarFigurita(nuevaFigurita6, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		try {
			((UsuarioFinal) nuevoUsuarioFinal2).intercambiarFigurita(nuevoUsuarioFinal, nuevaFigurita6, nuevaFigurita8,
					nuevoAlbum);
		} catch (NoTenesLaFiguritaQueQueresPegarOIntercambiarException | FiguritaYaAgregadaEnLaBaseDeDatosException
				| FiguritaNoExistenteEnLaBaseDeDatosException | FiguritaYaPegadaEnElAlbumException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println(((UsuarioFinal) nuevoUsuarioFinal).getColeccionDeFiguritas().size());
		System.out.println(((UsuarioFinal) nuevoUsuarioFinal2).getColeccionDeFiguritas().size());

	}

	@Test
	public void testQueNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga()
			throws NoSePuedeCrearElAlbumException, NoSePuedoCrearUnAdministradorException {

		Album nuevoAlbum = crearAlbum();

		Usuario nuevoAdministrador = crearAdministrador();

		for (Figurita recorridoBombo : crearBomboDeFiguritas()) {
			try {
				nuevoAdministrador.agregarFigurita(recorridoBombo, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		Usuario nuevoUsuarioFinal = new UsuarioFinal("Ricardo Moyo");
		Usuario nuevoUsuarioFinal2 = new UsuarioFinal("Roberto Petinato");

		for (Figurita recorridoMazoUsuario : crearMazoDeFiguritasDelUsuarioFinal()) {
			try {
				nuevoUsuarioFinal.agregarFigurita(recorridoMazoUsuario, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		for (Figurita recorridoMazoUsuario : crearMazoDeFiguritasDelUsuarioFinal2()) {
			try {
				nuevoUsuarioFinal2.agregarFigurita(recorridoMazoUsuario, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		Figurita nuevaFigurita8 = new Figurita(4, 'C', Pais.ARGENTINA, "Huevo Acuña", 150000000.0);
		Figurita nuevaFigurita6 = new Figurita(9, 'E', Pais.ESPAÑA, "Alvaro Morata", 45000000.0);

		try {
			nuevoUsuarioFinal.agregarFigurita(nuevaFigurita8, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
//		try {
//			nuevoUsuarioFinal2.agregarFigurita(nuevaFigurita6, nuevoAlbum);
//		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}

		try {
			((UsuarioFinal) nuevoUsuarioFinal2).intercambiarFigurita(nuevoUsuarioFinal, nuevaFigurita6, nuevaFigurita8,
					nuevoAlbum);
		} catch (NoTenesLaFiguritaQueQueresPegarOIntercambiarException | FiguritaYaAgregadaEnLaBaseDeDatosException
				| FiguritaNoExistenteEnLaBaseDeDatosException | FiguritaYaPegadaEnElAlbumException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println(((UsuarioFinal) nuevoUsuarioFinal).getColeccionDeFiguritas().size());
		System.out.println(((UsuarioFinal) nuevoUsuarioFinal2).getColeccionDeFiguritas().size());

	}
	
	@Test
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() throws NoSePuedeCrearElAlbumException, NoSePuedoCrearUnAdministradorException {
		
		Album nuevoAlbum = crearAlbum();

		Usuario nuevoAdministrador = crearAdministrador();

		for (Figurita recorridoBombo : crearBomboDeFiguritas()) {
			try {
				nuevoAdministrador.agregarFigurita(recorridoBombo, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		Usuario nuevoUsuarioFinal = new UsuarioFinal("Ricardo Moyo");
		Usuario nuevoUsuarioFinal2 = new UsuarioFinal("Roberto Petinato");

		for (Figurita recorridoMazoUsuario : crearMazoDeFiguritasDelUsuarioFinal()) {
			try {
				nuevoUsuarioFinal.agregarFigurita(recorridoMazoUsuario, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		for (Figurita recorridoMazoUsuario : crearMazoDeFiguritasDelUsuarioFinal2()) {
			try {
				nuevoUsuarioFinal2.agregarFigurita(recorridoMazoUsuario, nuevoAlbum);
			} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		Figurita nuevaFigurita8 = new Figurita(4, 'C', Pais.ARGENTINA, "Huevo Acuña", 150000000.0);
		Figurita nuevaFigurita6 = new Figurita(9, 'E', Pais.ESPAÑA, "Alvaro Morata", 45000000.0);

		try {
			nuevoUsuarioFinal.agregarFigurita(nuevaFigurita6, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			nuevoUsuarioFinal2.agregarFigurita(nuevaFigurita8, nuevoAlbum);
		} catch (FiguritaYaAgregadaEnLaBaseDeDatosException | FiguritaNoExistenteEnLaBaseDeDatosException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			((UsuarioFinal)nuevoUsuarioFinal).pegarFigurita(nuevaFigurita6, nuevoAlbum);
		} catch (FiguritaNoExistenteEnLaBaseDeDatosException | FiguritaYaPegadaEnElAlbumException
				| NoTenesLaFiguritaQueQueresPegarOIntercambiarException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		try {
			((UsuarioFinal) nuevoUsuarioFinal2).intercambiarFigurita(nuevoUsuarioFinal, nuevaFigurita6, nuevaFigurita8,
					nuevoAlbum);
		} catch (NoTenesLaFiguritaQueQueresPegarOIntercambiarException | FiguritaYaAgregadaEnLaBaseDeDatosException
				| FiguritaNoExistenteEnLaBaseDeDatosException | FiguritaYaPegadaEnElAlbumException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		System.out.println(((UsuarioFinal) nuevoUsuarioFinal).getColeccionDeFiguritas().size());
		System.out.println(((UsuarioFinal) nuevoUsuarioFinal2).getColeccionDeFiguritas().size());

	
	}

	private Album crearAlbum() throws NoSePuedeCrearElAlbumException {
		// TODO Auto-generated method stub
		Album nuevoAlbum = new Album();
		if (nuevoAlbum != null) {
			return nuevoAlbum;
		}
		throw new NoSePuedeCrearElAlbumException("Album no creado");
	}

	private Usuario crearAdministrador() throws NoSePuedoCrearUnAdministradorException {
		Usuario nuevoAdministrador = new Administrador("Pep Guardiola");
		if (nuevoAdministrador != null) {
			return nuevoAdministrador;
		}
		throw new NoSePuedoCrearUnAdministradorException("Administrador no creado");

	}

	private HashSet<Figurita> crearBomboDeFiguritas() {

		HashSet<Figurita> figuritasParaAgregar = new HashSet<>();

		Figurita nuevaFigurita = new Figurita(5, 'C', Pais.ARGENTINA, "Leandro Paredes", 45000000.0);
		Figurita nuevaFigurita2 = new Figurita(27, 'C', Pais.ARGENTINA, "Guido Rodriguez", 25000000.0);
		Figurita nuevaFigurita3 = new Figurita(9, 'C', Pais.ARGENTINA, "Lautaro Martinez", 100000000.0);
		Figurita nuevaFigurita4 = new Figurita(1, 'C', Pais.ARGENTINA, "Emiliano Martinez", 50000000.0);
		Figurita nuevaFigurita5 = new Figurita(21, 'C', Pais.ARGENTINA, "Paulo Dybala", 150000000.0);
		Figurita nuevaFigurita6 = new Figurita(11, 'C', Pais.ARGENTINA, "Angel Di Maria", 50000000.0);
		Figurita nuevaFigurita7 = new Figurita(17, 'C', Pais.ARGENTINA, "Joaquin Correa", 150000000.0);
		Figurita nuevaFigurita8 = new Figurita(4, 'C', Pais.ARGENTINA, "Huevo Acuña", 150000000.0);
		Figurita nuevaFigurita9 = new Figurita(2, 'C', Pais.ARGENTINA, "Cristian Romero", 150000000.0);
		Figurita nuevaFigurita10 = new Figurita(10, 'C', Pais.ARGENTINA, "Lionel Messi", 150000000.0);
		Figurita nuevaFigurita11 = new Figurita(10, 'G', Pais.BRASIL, "Neymar Jr.", 250000000.0);
		Figurita nuevaFigurita12 = new Figurita(1, 'C', Pais.ESPAÑA, "David De Gea", 100000000.0);
		Figurita nuevaFigurita13 = new Figurita(10, 'E', Pais.ESPAÑA, "Gavi", 120000000.0);
		Figurita nuevaFigurita14 = new Figurita(9, 'E', Pais.ESPAÑA, "Alvaro Morata", 45000000.0);
		Figurita nuevaFigurita15 = new Figurita(5, 'G', Pais.BRASIL, "Casemiro", 125000000.0);
		Figurita nuevaFigurita16 = new Figurita(11, 'E', Pais.ESPAÑA, "Traore", 75000000.0);

		figuritasParaAgregar.add(nuevaFigurita);
		figuritasParaAgregar.add(nuevaFigurita2);
		figuritasParaAgregar.add(nuevaFigurita3);
		figuritasParaAgregar.add(nuevaFigurita4);
		figuritasParaAgregar.add(nuevaFigurita5);
		figuritasParaAgregar.add(nuevaFigurita6);
		figuritasParaAgregar.add(nuevaFigurita7);
		figuritasParaAgregar.add(nuevaFigurita8);
		figuritasParaAgregar.add(nuevaFigurita9);
		figuritasParaAgregar.add(nuevaFigurita10);
		figuritasParaAgregar.add(nuevaFigurita11);
		figuritasParaAgregar.add(nuevaFigurita12);
		figuritasParaAgregar.add(nuevaFigurita13);
		figuritasParaAgregar.add(nuevaFigurita14);
		figuritasParaAgregar.add(nuevaFigurita15);
		figuritasParaAgregar.add(nuevaFigurita16);

		return figuritasParaAgregar;
	}

	private HashSet<Figurita> crearMazoDeFiguritasDelUsuarioFinal() {

		HashSet<Figurita> figuritasParaAgregar = new HashSet<>();

		Figurita nuevaFigurita = new Figurita(5, 'C', Pais.ARGENTINA, "Leandro Paredes", 45000000.0);
		Figurita nuevaFigurita2 = new Figurita(27, 'C', Pais.ARGENTINA, "Guido Rodriguez", 25000000.0);
		Figurita nuevaFigurita3 = new Figurita(9, 'C', Pais.ARGENTINA, "Lautaro Martinez", 100000000.0);
		Figurita nuevaFigurita4 = new Figurita(1, 'C', Pais.ARGENTINA, "Emiliano Martinez", 50000000.0);
		Figurita nuevaFigurita5 = new Figurita(21, 'C', Pais.ARGENTINA, "Paulo Dybala", 150000000.0);
		Figurita nuevaFigurita6 = new Figurita(11, 'C', Pais.ARGENTINA, "Angel Di Maria", 50000000.0);
		Figurita nuevaFigurita7 = new Figurita(17, 'C', Pais.ARGENTINA, "Joaquin Correa", 150000000.0);
		Figurita nuevaFigurita8 = new Figurita(4, 'C', Pais.ARGENTINA, "Huevo Acuña", 150000000.0);
		Figurita nuevaFigurita9 = new Figurita(2, 'C', Pais.ARGENTINA, "Cristian Romero", 150000000.0);
		Figurita nuevaFigurita10 = new Figurita(10, 'C', Pais.ARGENTINA, "Lionel Messi", 150000000.0);

		figuritasParaAgregar.add(nuevaFigurita);
		figuritasParaAgregar.add(nuevaFigurita2);
		figuritasParaAgregar.add(nuevaFigurita3);
		figuritasParaAgregar.add(nuevaFigurita4);
		figuritasParaAgregar.add(nuevaFigurita5);
		figuritasParaAgregar.add(nuevaFigurita6);
		figuritasParaAgregar.add(nuevaFigurita7);
		figuritasParaAgregar.add(nuevaFigurita8);
		figuritasParaAgregar.add(nuevaFigurita9);
		figuritasParaAgregar.add(nuevaFigurita10);

		return figuritasParaAgregar;
	}

	private HashSet<Figurita> crearMazoDeFiguritasDelUsuarioFinal2() {

		HashSet<Figurita> figuritasParaAgregar = new HashSet<>();

		Figurita nuevaFigurita = new Figurita(10, 'G', Pais.BRASIL, "Neymar Jr.", 250000000.0);
		Figurita nuevaFigurita3 = new Figurita(1, 'C', Pais.ESPAÑA, "David De Gea", 100000000.0);
		Figurita nuevaFigurita4 = new Figurita(10, 'E', Pais.ESPAÑA, "Gavi", 120000000.0);
		Figurita nuevaFigurita6 = new Figurita(9, 'E', Pais.ESPAÑA, "Alvaro Morata", 45000000.0);
		Figurita nuevaFigurita8 = new Figurita(5, 'G', Pais.BRASIL, "Casemiro", 125000000.0);
		Figurita nuevaFigurita9 = new Figurita(11, 'E', Pais.ESPAÑA, "Traore", 75000000.0);
		Figurita nuevaFigurita2 = new Figurita(27, 'C', Pais.ARGENTINA, "Guido Rodriguez", 25000000.0);
		Figurita nuevaFigurita5 = new Figurita(21, 'C', Pais.ARGENTINA, "Paulo Dybala", 150000000.0);
		Figurita nuevaFigurita7 = new Figurita(17, 'C', Pais.ARGENTINA, "Joaquin Correa", 150000000.0);
		Figurita nuevaFigurita10 = new Figurita(10, 'C', Pais.ARGENTINA, "Lionel Messi", 150000000.0);

		figuritasParaAgregar.add(nuevaFigurita);
		figuritasParaAgregar.add(nuevaFigurita2);
		figuritasParaAgregar.add(nuevaFigurita3);
		figuritasParaAgregar.add(nuevaFigurita4);
		figuritasParaAgregar.add(nuevaFigurita5);
		figuritasParaAgregar.add(nuevaFigurita6);
		figuritasParaAgregar.add(nuevaFigurita7);
		figuritasParaAgregar.add(nuevaFigurita8);
		figuritasParaAgregar.add(nuevaFigurita9);
		figuritasParaAgregar.add(nuevaFigurita10);

		return figuritasParaAgregar;
	}
}
