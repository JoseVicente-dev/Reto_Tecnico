package retoTecnico;

import java.util.Arrays;

public class Categoria {

	private byte ronda;
	private Pregunta[] preguntas = new Pregunta[5];
	private int premio;
	private boolean superada = false;

	public void generarRespuestas(String enunciadoP1, String enunciadoP2, String enunciadoP3,
			String enunciadoP4, String enunciadoP5) {
		
		
		Pregunta pregunta1 = new Pregunta(this.ronda, enunciadoP1);
		Pregunta pregunta2 = new Pregunta(this.ronda, enunciadoP2);
		Pregunta pregunta3 = new Pregunta(this.ronda, enunciadoP3);
		Pregunta pregunta4 = new Pregunta(this.ronda, enunciadoP4);
		Pregunta pregunta5 = new Pregunta(this.ronda, enunciadoP5);
		
		preguntas[0]=pregunta1;
		preguntas[1]=pregunta2;
		preguntas[2]=pregunta3;
		preguntas[3]=pregunta4;
		preguntas[4]=pregunta5;
				
	}
	
	pp

}
