package retoTecnico;

import java.util.Arrays;

public class Categoria {
	
	private byte ronda;
	private Pregunta [] preguntas = new Pregunta[5];
	private int premio;
	private boolean superada=false;
	
	
	/**
	 * @param ronda
	 * @param preguntas
	 * @param premio
	 */
	public Categoria(byte ronda, Pregunta[] preguntas, int premio) {
		super();
		this.ronda = ronda;
		this.preguntas = preguntas;
		this.premio = premio;
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
	 * @return the preguntas
	 */
	public Pregunta[] getPreguntas() {
		return preguntas;
	}
	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(Pregunta[] preguntas) {
		this.preguntas = preguntas;
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
	@Override
	public String toString() {
		return "Categoria \n[ronda=" + ronda + ", \npreguntas=" + Arrays.toString(preguntas) + "]";
	}
	
	
}
