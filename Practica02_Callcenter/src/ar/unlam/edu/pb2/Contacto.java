package ar.unlam.edu.pb2;

public class Contacto {

	private String nombreApellido;
	private String numCelular;
	private String eMail;
	private String direccion;
	private String codPostal;
	private String localidad;
	private ProvinciaSeleccionada provincia;
	private Boolean cliente;
	private Boolean deseaSerLlamado;

	public Contacto() {
		
	}
	
	public Contacto(String nombreApellido, String numCelular, String eMail, String direccion, String codPostal, String localidad,
			ProvinciaSeleccionada provincia) {
		// TODO Auto-generated constructor stub
		this.nombreApellido = nombreApellido;
		this.numCelular = numCelular;
		this.eMail = eMail;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.cliente = false;
		this.deseaSerLlamado = true;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodPostasl() {
		return codPostal;
	}

	public void setCodPostasl(String codPostasl) {
		this.codPostal = codPostasl;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public ProvinciaSeleccionada getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaSeleccionada provincia) {
		this.provincia = provincia;
	}

	public Boolean getCliente() {
		return cliente;
	}

	public void setCliente(Boolean cliente) {
		this.cliente = cliente;
	}

	public Boolean getDeseaSerLlamado() {
		return deseaSerLlamado;
	}

	public void setDeseaSerLlamado(Boolean deseaSerLlamado) {
		this.deseaSerLlamado = deseaSerLlamado;
	}
	
	public String toString () {
	
		return this.nombreApellido + " / " + this.eMail + " / " + this.numCelular;
		
	}
	

//	 private Celular celular;
//
//	 
//	 private class Celular{
//		 private String codPais;
//		 private String codArea;
//		 private String numCelular;
//	 }
	 
//	public static void nuevoCelular(String codPais, String codArea, String numCelular) {
//		// TODO Auto-generated method stub
//		
//		this.celular.codPais = codPais;
//		this.celular.codArea = codArea;
//		this.celular.numCelular = numCelular;
//		
//	}

}
