package retoTecnico;

import java.util.Arrays;

public class Pregunta {

	private byte nivel;
	private String enunciado;
	private Respuesta[] respuestas = new Respuesta[4];
	private byte seleccion;

	/**
	 * @param nivel
	 * @param enunciado
	 */
	public Pregunta(byte nivel, String enunciado) {
		super();
		this.nivel = nivel;
		this.enunciado = enunciado;
	}

	public void generarRespuestas(String enunciadoV, String enunciadoF1, String enunciadoF2, String enunciadoF3) {
		byte indiceV = (byte) (Math.random() * 4);

		Respuesta correcta = new Respuesta(indiceV, enunciado, true);
		respuestas[indiceV] = correcta;

		byte indiceF1;
		byte indiceF2;
		byte indiceF3;

		if (indiceV == 0) {
			indiceF1 = 1;
			indiceF2 = 2;
			indiceF3 = 3;
		} else if (indiceV == 1) {
			indiceF1 = 0;
			indiceF2 = 2;
			indiceF3 = 3;
		} else if (indiceV == 2) {
			indiceF1 = 0;
			indiceF2 = 1;
			indiceF3 = 3;
		} else {
			indiceF1 = 0;
			indiceF2 = 1;
			indiceF3 = 2;
		}

		Respuesta incorrecta1 = new Respuesta(indiceF1, enunciadoF1, false);
		Respuesta incorrecta2 = new Respuesta(indiceF2, enunciadoF2, false);
		Respuesta incorrecta3 = new Respuesta(indiceF3, enunciadoF3, false);

		respuestas[indiceF1] = incorrecta1;
		respuestas[indiceF2] = incorrecta2;
		respuestas[indiceF3] = incorrecta3;

	}

	public boolean verificarRespuestaCorrecta() {
		return respuestas[getSeleccion()].isRespuestaCorrecta();
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
	 * @return the seleccion
	 */
	public byte getSeleccion() {
		return seleccion;
	}

	/**
	 * @param seleccion the seleccion to set
	 */
	public void setSeleccion(byte seleccion) {
		this.seleccion = seleccion;
	}

	/**
	 * @return the respuestas
	 */
	public Respuesta[] getRespuestas() {
		return respuestas;
	}

	@Override
	public String toString() {
		return "Pregunta \n[nivel=" + nivel + ", \nenunciado=" + enunciado + ", \nrespuestas="
				+ Arrays.toString(respuestas) + ", \nseleccion=" + seleccion + "]";
	}

}
