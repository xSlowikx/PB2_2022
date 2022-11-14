package ar.unlam.edu.pb2;

import java.time.LocalDate;

public class Accion {
	/*
	 * ● Lista de acciones realizadas.Una acción está formada por: ○ Identificador
	 * de acción. ○ La alarma sobre la que se realiza la acción. ○ El usuario que
	 * realiza la acción. ○ Fecha en la que se realiza. ○ Tipo de operación:
	 * CONFUGRACION, ACTIVACION, DESACTIVACION.
	 */

	private Integer identificadorAccion;
	private Alarma alarmaAfectada;
	private Usuario usuarioInterviniente;
	private LocalDate fechaDeLaAccion;
	private AccionRealizada tipoDeOperacionRealizada;

	public Accion(Integer identificadorAccion, Alarma alarmaAfectada, Usuario usuarioInterviniente,LocalDate fechaDeLaAccion, 
			AccionRealizada tipoDeOperacionRealizada) {
		super();
		this.identificadorAccion = identificadorAccion;
		this.alarmaAfectada = alarmaAfectada;
		this.usuarioInterviniente = usuarioInterviniente;
		this.fechaDeLaAccion = fechaDeLaAccion;
		this.tipoDeOperacionRealizada = tipoDeOperacionRealizada;
	}

	public LocalDate getFechaDeLaAccion() {
		return fechaDeLaAccion;
	}

	public void setFechaDeLaAccion(LocalDate fechaDeLaAccion) {
		this.fechaDeLaAccion = fechaDeLaAccion;
	}

	public Integer getIdentificadorAccion() {
		return identificadorAccion;
	}

	public void setIdentificadorAccion(Integer identificadorAccion) {
		this.identificadorAccion = identificadorAccion;
	}

	public Alarma getAlarmaAfectada() {
		return alarmaAfectada;
	}

	public void setAlarmaAfectada(Alarma alarmaAfectada) {
		this.alarmaAfectada = alarmaAfectada;
	}

	public Usuario getUsuarioInterviniente() {
		return usuarioInterviniente;
	}

	public void setUsuarioInterviniente(Usuario usuarioInterviniente) {
		this.usuarioInterviniente = usuarioInterviniente;
	}

	public AccionRealizada getTipoDeOperacionRealizada() {
		return tipoDeOperacionRealizada;
	}

	public void setTipoDeOperacionRealizada(AccionRealizada tipoDeOperacionRealizada) {
		this.tipoDeOperacionRealizada = tipoDeOperacionRealizada;
	}

}
