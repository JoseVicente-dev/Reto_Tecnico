package retoTecnico;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Concurso {

	private String fechaInicial;
	private String fechaFinal;
	private Categoria[] categorias =new Categoria[5];

	/**
	 * @param fechaInicial
	 * @param fechaFinal
	 */
	public Concurso() {
		super();
		this.fechaInicial = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		;

	}

	public void configurarCategoria(byte ronda, int premio) {
		
		Categoria categoriaI= new Categoria(ronda, premio);
	}
	

	
}
