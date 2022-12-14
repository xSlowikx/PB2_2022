package ar.unlam.edu.pb2;

public class Cerradura {
	private Integer claveDeApertura;
	private Integer cantidadDeFallosConsecutivosQueLaBloquean;
	private Boolean estaAbierta;
	private Integer intentosFallidos;
	private Boolean estaBloqueada;
	private final Integer CLAVE_MAESTRA = 152463360;
	
	Cerradura (){
		this.claveDeApertura = 131677;
		this.estaAbierta = false;
	}
	
	public Cerradura (Integer claveDeApertura, Integer cantidadDeFallosConsecutivosQueLaBloquean){
		this.claveDeApertura = claveDeApertura;
		this.cantidadDeFallosConsecutivosQueLaBloquean = cantidadDeFallosConsecutivosQueLaBloquean;
		
		this.estaAbierta = false;
		this.intentosFallidos = 0;
		this.estaBloqueada = false;
	}

	public Integer getClaveDeApertura() {
		return this.claveDeApertura;
	}

	public void setClaveDeApertura(Integer claveDeApertura) {
		this.claveDeApertura = claveDeApertura;
	}

	public Integer getCantidadDeFallosConsecutivosQueLaBloquean() {
		return this.cantidadDeFallosConsecutivosQueLaBloquean;
	}

	public void setCantidadDeFallosConsecutivosQueLaBloquean(Integer cantidadDeFallosConsecutivosQueLaBloquean) {
		this.cantidadDeFallosConsecutivosQueLaBloquean = cantidadDeFallosConsecutivosQueLaBloquean;
	}
	
	public Boolean getEstaAbierta() {
		return this.estaAbierta;
	}

	public void setEstaAbierta(Boolean estaAbierta) {
		this.estaAbierta = estaAbierta;
	}

	public Boolean abrirCerradura(Integer claveIngresada) {
		// TODO Auto-generated method stub
		if(this.claveDeApertura.equals(claveIngresada) && this.intentosFallidos<this.cantidadDeFallosConsecutivosQueLaBloquean) {
			this.estaAbierta = true;
		} else if(this.intentosFallidos<this.cantidadDeFallosConsecutivosQueLaBloquean-1){
			this.intentosFallidos++;
		} else
			this.estaBloqueada = true;
		return this.estaAbierta;
	}
	
	public Boolean getEstaBloqueada () {
		return this.estaBloqueada;
	}
	
	public void cerrarCerradura() {
		this.estaAbierta = false;
		this.estaBloqueada = false;
		this.intentosFallidos = 0;
	}
}
