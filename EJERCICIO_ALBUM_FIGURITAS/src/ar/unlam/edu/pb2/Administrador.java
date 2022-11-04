package ar.unlam.edu.pb2;

public class Administrador extends Usuario {

	public Administrador(String nombreUsuario) {
		super(nombreUsuario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agregarFigurita(Figurita nuevaFigurita, Album nuevoAlbum) throws FiguritaYaAgregadaEnLaBaseDeDatosException {
		// TODO Auto-generated method stub
		String claveDeBusqueda = obtenerClaveDeBusqueda(nuevaFigurita);
		buscarFigurita(claveDeBusqueda, nuevoAlbum);
		nuevoAlbum.getListaDeFiguritas().put(claveDeBusqueda, nuevaFigurita);

	}

	private String obtenerClaveDeBusqueda(Figurita nuevaFigurita) {
		// TODO Auto-generated method stub
		return nuevaFigurita.getPaisOrigen().toString() + nuevaFigurita.getNumeroFigurita().toString();
	}
	
	public void buscarFigurita(String searchedKey, Album nuevoAlbum) throws FiguritaYaAgregadaEnLaBaseDeDatosException {
		if (nuevoAlbum.getListaDeFiguritas().containsKey(searchedKey)) {
			throw new FiguritaYaAgregadaEnLaBaseDeDatosException("La figurita ya se encuentra agregada a la base de datos del sistema");
		}
		// TODO Auto-generated method stub
	}

}
