package retoTecnico;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Concurso {

	private String fechaInicial;
	private String fechaFinal;
	private Categoria [] categorias = new Categoria[5];
	Scanner scan = new Scanner(System.in);
	

	/**
	 * @param fechaInicial
	 * @param fechaFinal
	 */
	public Concurso() {
		super();
		this.fechaInicial = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		

	}

	public Categoria configurarCategoria(byte ronda, int premio) {
		
		Categoria categoria= new Categoria(ronda, premio);
		categoria.generarPreguntas();
		return categoria;
	}
	

	
}
