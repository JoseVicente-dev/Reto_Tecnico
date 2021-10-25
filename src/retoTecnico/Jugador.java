package retoTecnico;

public class Jugador {

	private int identificacion;
	private String nombres;
	private String apellidos;
	private int puntaje = 0;
	private String fechaParticipacion;
	private String estado;
	private int nivelMaximoAlcanzado;

	/**
	 * @param identificacion
	 * @param nombres
	 * @param apellidos
	 * @param fechaParticipacion
	 * @param estado
	 * @param nivelMaximoAlcanzado
	 */
	public Jugador(int identificacion, String nombres, String apellidos, String fechaParticipacion
			) {
		super();
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaParticipacion = fechaParticipacion;
		
	}
	
	public void aumentarPuntaje(int premio) {
		setPuntaje(getPuntaje()+premio);
	}

	/**
	 * @return the identificacion
	 */
	public int getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the puntaje
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * @param puntaje the puntaje to set
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	/**
	 * @return the fechaParticipacion
	 */
	public String getFechaParticipacion() {
		return fechaParticipacion;
	}

	/**
	 * @param fechaParticipacion the fechaParticipacion to set
	 */
	public void setFechaParticipacion(String fechaParticipacion) {
		this.fechaParticipacion = fechaParticipacion;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the nivelMaximoAlcanzado
	 */
	public int getNivelMaximoAlcanzado() {
		return nivelMaximoAlcanzado;
	}

	/**
	 * @param nivelMaximoAlcanzado the nivelMaximoAlcanzado to set
	 */
	public void setNivelMaximoAlcanzado(int nivelMaximoAlcanzado) {
		this.nivelMaximoAlcanzado = nivelMaximoAlcanzado;
	}

	@Override
	public String toString() {
		return "Jugador \n[identificacion=" + identificacion + ", \nnombres=" + nombres + ", \napellidos=" + apellidos
				+ ", \npuntaje=" + puntaje + ", \nfechaParticipacion=" + fechaParticipacion + ", \nestado=" + estado
				+ ", \nnivelMaximoAlcanzado=" + nivelMaximoAlcanzado + "]";
	}
	
	

}
