package ar.unlam.edu.pb2;

import java.util.ArrayList;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioFinal extends Usuario {

	private ArrayList<Figurita> coleccionDeFiguritas;
	private TreeMap <String,Figurita> listaDeFiguritasYaPegadas;

	public UsuarioFinal(String nombreUsuario) {
		super(nombreUsuario);
		// TODO Auto-generated constructor stub
		this.coleccionDeFiguritas = new ArrayList<>();
		this.listaDeFiguritasYaPegadas = new TreeMap<>();
	}

	@Override
	public void agregarFigurita(Figurita nuevaFigurita, Album nuevoAlbum)
			throws FiguritaNoExistenteEnLaBaseDeDatosException {
		// TODO Auto-generated method stub
		String claveDeBusqueda = obtenerClaveDeBusqueda(nuevaFigurita);
//		String searchedKey = nuevaFigurita.getPaisOrigen().toString() + nuevaFigurita.getNumeroFigurita().toString();
		buscarFigurita(claveDeBusqueda,nuevoAlbum);
		coleccionDeFiguritas.add(nuevaFigurita);
		
	}

	private String obtenerClaveDeBusqueda(Figurita nuevaFigurita) {
		// TODO Auto-generated method stub
		return nuevaFigurita.getPaisOrigen().toString() + nuevaFigurita.getNumeroFigurita().toString();
	}

	@Override
	public void buscarFigurita(String searchedKey, Album nuevoAlbum) throws FiguritaNoExistenteEnLaBaseDeDatosException {
		// TODO Auto-generated method stub
		if(!nuevoAlbum.getListaDeFiguritas().containsKey(searchedKey)) {
			throw new FiguritaNoExistenteEnLaBaseDeDatosException ("La figurita que intentas agregar no existe en la base de datos");
		}
		
	}
	
	public ArrayList<Figurita> getColeccionDeFiguritas() {
		return coleccionDeFiguritas;

	}
	
	public void pegarFigurita(Figurita figuritaParaPegar,Album albumDestino) throws FiguritaNoExistenteEnLaBaseDeDatosException, FiguritaYaPegadaEnElAlbumException, NoTenesLaFiguritaQueQueresPegarOIntercambiarException {
		revisarSiTieneLaFiguritaEnSuMazo(figuritaParaPegar);
		String claveDeBusqueda = obtenerClaveDeBusqueda(figuritaParaPegar);
		buscarFigurita(claveDeBusqueda, albumDestino);
		revisarSiYaEstaPegada(claveDeBusqueda);
		listaDeFiguritasYaPegadas.put(claveDeBusqueda, figuritaParaPegar);
		
	}

	private Boolean revisarSiTieneLaFiguritaEnSuMazo(Figurita figuritaParaPegar) throws NoTenesLaFiguritaQueQueresPegarOIntercambiarException {
		// TODO Auto-generated method stub
		for(Figurita recorridoMazo : coleccionDeFiguritas) {
			if(recorridoMazo.getNumeroFigurita().equals(figuritaParaPegar.getNumeroFigurita())) {
				return true;
			}
		}
		throw new NoTenesLaFiguritaQueQueresPegarOIntercambiarException("La figurita que queres pegar o intercambiar, no la tenes en tu mazo");
		
	}

	private void revisarSiYaEstaPegada(String claveDeBusqueda) throws FiguritaYaPegadaEnElAlbumException {
		// TODO Auto-generated method stub
		if(listaDeFiguritasYaPegadas.containsKey(claveDeBusqueda)) {
			throw new FiguritaYaPegadaEnElAlbumException ("La figurita que intentas pegar ya se encuentra pegada");
		}
	}
	
	public void intercambiarFigurita(Usuario nuevoUsuarioFinal, Figurita figuritaEntregada, Figurita figuritaRecibida, Album nuevoAlbum) throws NoTenesLaFiguritaQueQueresPegarOIntercambiarException, FiguritaYaAgregadaEnLaBaseDeDatosException, FiguritaNoExistenteEnLaBaseDeDatosException, FiguritaYaPegadaEnElAlbumException {
		revisarSiYaEstaPegada(obtenerClaveDeBusqueda(figuritaRecibida));
		((UsuarioFinal)nuevoUsuarioFinal).revisarSiYaEstaPegada(obtenerClaveDeBusqueda(figuritaEntregada));
		revisarSiTieneLaFiguritaEnSuMazo(figuritaEntregada);
		((UsuarioFinal) nuevoUsuarioFinal).revisarSiTieneLaFiguritaEnSuMazo(figuritaRecibida);
		quitarFiguritaDelMazo(figuritaEntregada);
		nuevoUsuarioFinal.agregarFigurita(figuritaEntregada, nuevoAlbum);
		((UsuarioFinal) nuevoUsuarioFinal).quitarFiguritaDelMazo(figuritaRecibida);
		agregarFigurita(figuritaRecibida, nuevoAlbum);
		System.out.println("Intercambio realizado con exito");
	}


	private void quitarFiguritaDelMazo(Figurita figuritaEntregada) {
		// TODO Auto-generated method stub
		this.coleccionDeFiguritas.remove(figuritaEntregada);
	

}
}
