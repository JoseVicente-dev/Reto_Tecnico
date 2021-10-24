package retoTecnico;

public class Respuesta {
	
	private byte indice;
	private String enunciado;
	private boolean respuestaCorrecta;
	
	/**
	 * @param indice
	 * @param enunciado
	 * @param respuestaCorrecta
	 */
	public Respuesta(byte indice, String enunciado, boolean respuestaCorrecta) {
		super();
		this.indice = indice;
		this.enunciado = enunciado;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	/**
	 * @return the indice
	 */
	public byte getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(byte indice) {
		this.indice = indice;
	}

	/**
	 * @return the enunciado
	 */
	public String getEnunciado() {
		return enunciado;
	}

	/**
	 * @param enunciado the enunciado to set
	 */
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	/**
	 * @return the respuestaCorrecta
	 */
	public boolean isRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	/**
	 * @param respuestaCorrecta the respuestaCorrecta to set
	 */
	public void setRespuestaCorrecta(boolean respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	@Override
	public String toString() {
		return "Respuesta \n[indice=" + indice + ", \nenunciado=" + enunciado + ", \nrespuestaCorrecta="
				+ respuestaCorrecta + "]";
	}
	
	
	
	

}
