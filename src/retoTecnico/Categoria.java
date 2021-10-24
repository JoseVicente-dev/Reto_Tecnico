package retoTecnico;

import java.util.Arrays;

public class Categoria {

	private byte ronda;
	private Pregunta[] preguntas = new Pregunta[5];
	private int premio;
	private boolean superada = false;

	/**
	 * @param ronda
	 * @param premio
	 */
	public Categoria(byte ronda, int premio) {
		super();
		this.ronda = ronda;
		this.premio = premio;
	}

	public void generarRespuestas(String enunciadoP1, String enunciadoP2, String enunciadoP3, String enunciadoP4,
			String enunciadoP5) {

		Pregunta pregunta1 = new Pregunta(this.ronda, enunciadoP1);
		Pregunta pregunta2 = new Pregunta(this.ronda, enunciadoP2);
		Pregunta pregunta3 = new Pregunta(this.ronda, enunciadoP3);
		Pregunta pregunta4 = new Pregunta(this.ronda, enunciadoP4);
		Pregunta pregunta5 = new Pregunta(this.ronda, enunciadoP5);

		preguntas[0] = pregunta1;
		preguntas[1] = pregunta2;
		preguntas[2] = pregunta3;
		preguntas[3] = pregunta4;
		preguntas[4] = pregunta5;

	}

	public Pregunta preguntaAlAzar() {

		byte indiceP = (byte) (Math.random() * 5);

		Pregunta preguntaSeleccionada = preguntas[indiceP];

		return preguntaSeleccionada;

	}

	public void categoriaSuperada() {
		if (preguntaAlAzar().verificarRespuestaCorrecta()) {
			setSuperada(true);
		}
	}

	/**
	 * @return the ronda
	 */
	public byte getRonda() {
		return ronda;
	}

	/**
	 * @param ronda the ronda to set
	 */
	public void setRonda(byte ronda) {
		this.ronda = ronda;
	}

	/**
	 * @return the premio
	 */
	public int getPremio() {
		return premio;
	}

	/**
	 * @param premio the premio to set
	 */
	public void setPremio(int premio) {
		this.premio = premio;
	}

	/**
	 * @return the superada
	 */
	public boolean isSuperada() {
		return superada;
	}

	/**
	 * @param superada the superada to set
	 */
	public void setSuperada(boolean superada) {
		this.superada = superada;
	}

	/**
	 * @return the preguntas
	 */
	public Pregunta[] getPreguntas() {
		return preguntas;
	}

	@Override
	public String toString() {
		return "Categoria \n[ronda=" + ronda + ", \npreguntas=" + Arrays.toString(preguntas) + ", \npremio=" + premio
				+ ", \nsuperada=" + superada + "]";
	}
	
	

}
