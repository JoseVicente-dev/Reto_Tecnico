package retoTecnico;

public class Pregunta {
	
	private byte nivel;
	private Respuesta respuestaCorrecta;
	private Respuesta respuestaIncorrecta1;
	private Respuesta respuestaIncorrecta2;
	private Respuesta respuestaIncorrecta3;
	/**
	 * @param nivel
	 * @param respuestaCorrecta
	 * @param respuestaIncorrecta1
	 * @param respuestaIncorrecta2
	 * @param respuestaIncorrecta3
	 */
	public Pregunta(byte nivel, Respuesta respuestaCorrecta, Respuesta respuestaIncorrecta1,
			Respuesta respuestaIncorrecta2, Respuesta respuestaIncorrecta3) {
		super();
		this.nivel = nivel;
		this.respuestaCorrecta = respuestaCorrecta;
		this.respuestaIncorrecta1 = respuestaIncorrecta1;
		this.respuestaIncorrecta2 = respuestaIncorrecta2;
		this.respuestaIncorrecta3 = respuestaIncorrecta3;
	}
	/**
	 * @return the nivel
	 */
	public byte getNivel() {
		return nivel;
	}
	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(byte nivel) {
		this.nivel = nivel;
	}
	/**
	 * @return the respuestaCorrecta
	 */
	public Respuesta getRespuestaCorrecta() {
		return respuestaCorrecta;
	}
	/**
	 * @param respuestaCorrecta the respuestaCorrecta to set
	 */
	public void setRespuestaCorrecta(Respuesta respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}
	/**
	 * @return the respuestaIncorrecta1
	 */
	public Respuesta getRespuestaIncorrecta1() {
		return respuestaIncorrecta1;
	}
	/**
	 * @param respuestaIncorrecta1 the respuestaIncorrecta1 to set
	 */
	public void setRespuestaIncorrecta1(Respuesta respuestaIncorrecta1) {
		this.respuestaIncorrecta1 = respuestaIncorrecta1;
	}
	/**
	 * @return the respuestaIncorrecta2
	 */
	public Respuesta getRespuestaIncorrecta2() {
		return respuestaIncorrecta2;
	}
	/**
	 * @param respuestaIncorrecta2 the respuestaIncorrecta2 to set
	 */
	public void setRespuestaIncorrecta2(Respuesta respuestaIncorrecta2) {
		this.respuestaIncorrecta2 = respuestaIncorrecta2;
	}
	/**
	 * @return the respuestaIncorrecta3
	 */
	public Respuesta getRespuestaIncorrecta3() {
		return respuestaIncorrecta3;
	}
	/**
	 * @param respuestaIncorrecta3 the respuestaIncorrecta3 to set
	 */
	public void setRespuestaIncorrecta3(Respuesta respuestaIncorrecta3) {
		this.respuestaIncorrecta3 = respuestaIncorrecta3;
	}
	@Override
	public String toString() {
		return "Pregunta \n[nivelDeDificultad=" + nivel + ", \nrespuestaCorrecta=" + respuestaCorrecta
				+ ", \nrespuestaIncorrecta1=" + respuestaIncorrecta1 + ", \nrespuestaIncorrecta2="
				+ respuestaIncorrecta2 + ", \nrespuestaIncorrecta3=" + respuestaIncorrecta3 + "]";
	}
	
	
	
	

}
