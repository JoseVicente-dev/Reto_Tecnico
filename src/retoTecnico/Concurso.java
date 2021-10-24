package retoTecnico;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Concurso {

	private String fechaInicial;
	private String fechaFinal;

	/**
	 * @param fechaInicial
	 * @param fechaFinal
	 */
	public Concurso() {
		super();
		this.fechaInicial = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		;

	}

	public void configurarJuego() {
		
		Concurso concurso = new Concurso();
		

	}

	/**
	 * @return the fechaInicial
	 */
	public String getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * @return the fechaFinal
	 */
	public String getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@Override
	public String toString() {
		return "Concurso \n[fechaInicial=" + fechaInicial + ", \nfechaFinal=" + fechaFinal + "]";
	}

}
