package ar.unlam.edu.pb2;

public abstract class Usuario {
	
	protected String nombreUsuario;

	public Usuario (String nombreUsuario){
		this.nombreUsuario = nombreUsuario;
	}
			
	public abstract void agregarFigurita(Figurita nuevaFigurita, Album nuevoAlbum) throws FiguritaYaAgregadaEnLaBaseDeDatosException, FiguritaNoExistenteEnLaBaseDeDatosException;
	
	public abstract void buscarFigurita(String searchedKey, Album nuevoAlbum) throws FiguritaYaAgregadaEnLaBaseDeDatosException, FiguritaNoExistenteEnLaBaseDeDatosException;
}
