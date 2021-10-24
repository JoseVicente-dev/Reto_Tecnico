package retoTecnico;

import java.util.Arrays;
import java.util.Scanner;

public class Categoria {

	private int ronda;
	private Pregunta[] preguntas = new Pregunta[5];
	private Premio premio;
	private boolean superada = false;
	private Scanner scan = new Scanner(System.in);

	/**
	 * @param ronda
	 * @param premio
	 */
	public Categoria(int ronda, Premio premio) {
		super();
		this.ronda = ronda;
		this.premio = premio;
	}

	public void generarPreguntas() {

		Pregunta pregunta1 = configurarPregunta(0, 1, this.ronda);
//		Pregunta pregunta2 = configurarPregunta(1, 2, this.ronda);
//		Pregunta pregunta3 = configurarPregunta(2, 3, this.ronda);
//		Pregunta pregunta4 = configurarPregunta(3, 4, this.ronda);
//		Pregunta pregunta5 = configurarPregunta(4, 5, this.ronda);

		preguntas[0] = pregunta1;
//		preguntas[1] = pregunta2;
//		preguntas[2] = pregunta3;
//		preguntas[3] = pregunta4;
//		preguntas[4] = pregunta5;

	}

	public Pregunta configurarPregunta(int indiceP, int i, int ronda) {

		System.out.println("Ingrese el enunciado de la Pregunta No. " + i + ":");
		String enunciadoP = scan.nextLine();
		Pregunta pregunta = new Pregunta(indiceP, ronda, enunciadoP);
		pregunta.generarRespuestas();
		return pregunta;

	}

	public Pregunta preguntaAlAzar() {

		int indiceP = (int) (Math.random() * 5);

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
	public int getRonda() {
		return ronda;
	}

	/**
	 * @param ronda the ronda to set
	 */
	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	/**
	 * @return the premio
	 */
	public Premio getPremio() {
		return premio;
	}

	/**
	 * @param premio the premio to set
	 */
	public void setPremio(Premio premio) {
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
