package ar.unlam.edu.pb2;

public class Activador extends Usuario implements Activable {

	public Activador(Integer dniUsuario, String nombreUsuario) {
		super(dniUsuario, nombreUsuario);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void activarDesactivarAlarma(Alarma alarmaRecibida, String codigoActivacionAlarma, Central centralOperante) {
		// TODO Auto-generated method stub
		
	}

}
