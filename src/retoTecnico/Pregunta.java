package retoTecnico;

import java.util.Arrays;
import java.util.Scanner;

public class Pregunta {

	private int nivel;
	private String enunciado;
	private Respuesta[] respuestas = new Respuesta[4];
	private int seleccion;
	private int indice;
	private Scanner scan = new Scanner(System.in);

	/**
	 * @param nivel
	 * @param enunciado
	 */
	public Pregunta(int indice, int nivel, String enunciado) {
		super();
		this.indice = indice;
		this.nivel = nivel;
		this.enunciado = enunciado;
	}

	public void generarRespuestas() {
		int indiceV = (int) (Math.random() * 4);
		System.out.println("Ingrese el enunciado de la respuesta CORRECTA:");
		String enunciadoV = scan.nextLine();		
		Respuesta correcta = new Respuesta(enunciadoV, true);
				
		respuestas[indiceV] = correcta;
		
		Respuesta incorrecta1 = configurarRespuestaIncorrecta(1);
		insertarRespuesta(incorrecta1);
		Respuesta incorrecta2 = configurarRespuestaIncorrecta(2);
		insertarRespuesta(incorrecta2);
		Respuesta incorrecta3 = configurarRespuestaIncorrecta(3);
		insertarRespuesta(incorrecta3);		
		
		

	}

	public Respuesta configurarRespuestaIncorrecta(int i) {
		System.out.println("Ingrese el enunciado de la Respuesta INCORRECTA No. " + i+":");		
		String enunciadoF = scan.nextLine();
		Respuesta respuesta = new Respuesta(enunciadoF, false);
		return respuesta;

	}
	
	public void insertarRespuesta(Respuesta respuesta) {
		for (int i=0;i<5;++i) {			
			if(respuestas[i]==null) {
				respuestas[i]=respuesta;
				return;
			}
		}
	}
	
	public void mostrarEnunciado(Pregunta pregunta) {
		System.out.println(pregunta.enunciado+"\n");
		for (int i=1;i<5;++i) {
		System.out.println(i+". "+pregunta.getRespuestas()[i-1]+"\n");
		}
	}
	
	public void responderPregunta(Pregunta pregunta) {
		int seleccion;
		do {
			System.out.println("Escoja una RESPUESTA:");
			while (!scan.hasNextInt()) {
				String input = scan.next();
				System.out.println("<" + input + "> no es un valor válido.");

			}
			seleccion = scan.nextInt();
		} while (seleccion<1 && seleccion>4);
		
		pregunta.setSeleccion(seleccion);	
		
	}

	public boolean verificarRespuestaCorrecta() {
		return respuestas[this.seleccion].isRespuestaCorrecta();
	}

	/**
	 * @return the nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(int nivel) {
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
	public int getSeleccion() {
		return seleccion;
	}

	/**
	 * @param seleccion the seleccion to set
	 */
	public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
	}

	/**
	 * @return the respuestas
	 */
	public Respuesta[] getRespuestas() {
		return respuestas;
	}

	/**
	 * @return the indice
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}

	@Override
	public String toString() {
		return "Pregunta \n[nivel=" + nivel + ", \nenunciado=" + enunciado + ", \nrespuestas="
				+ Arrays.toString(respuestas) + ", \nseleccion=" + seleccion + "]";
	}

}
