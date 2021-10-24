package retoTecnico;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Concurso {

	private String fechaInicial;
	private String fechaFinal;
	private Categoria[] categorias = new Categoria[5];
	private Scanner scan = new Scanner(System.in);

	/**
	 * @param fechaInicial
	 * @param fechaFinal
	 */
	public Concurso() {
		super();
		this.fechaInicial = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

	}

	public void generarCategorias() {

		System.out.println("Ingrese el tipo de premio que se otorgará en todas las Categorías (puntos o dinero)");
		String tipoDePremio = scan.nextLine();

		Categoria categoria1 = configurarCategoria(1, tipoDePremio);
//		Categoria categoria2 = configurarCategoria(2, tipoDePremio);
//		Categoria categoria3 = configurarCategoria(3, tipoDePremio);
//		Categoria categoria4 = configurarCategoria(4, tipoDePremio);
//		Categoria categoria5 = configurarCategoria(5, tipoDePremio);
//
		categorias[0] = categoria1;
//		categorias[1] = categoria2;
//		categorias[2] = categoria3;
//		categorias[3] = categoria4;
//		categorias[4] = categoria5;

	}

	public Categoria configurarCategoria(int ronda, String tipoDePremio) {
		int cantidadPremio;
		do {
			System.out.println("Ingrese el premio de la Categoria No: " + ronda +  dificultadRonda(ronda)+  ":");
			while (!scan.hasNextInt()) {
				String input = scan.next();
				System.out.println(input+" no es un valor válido." );
				
			}
			cantidadPremio=scan.nextInt();
		}while (cantidadPremio<0);
		
		
		Premio premio = new Premio(tipoDePremio, cantidadPremio);
		Categoria categoria = new Categoria(ronda, premio);
		categoria.generarPreguntas();
		return categoria;
	}
	
	public String dificultadRonda(int ronda) {
		String dificultad;

		switch (ronda) {
		case 1:
			dificultad = " (Muy fácil)";
		case 2:
			dificultad = " (Fácil)";
		case 3:
			dificultad = " (Moderada)";
		case 4:
			dificultad = " (Difícil)";
		case 5:
			dificultad = " (Muy difícil)";
		default:
			dificultad = "";
		}
		return dificultad;
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

	/**
	 * @return the fechaInicial
	 */
	public String getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @return the categorias
	 */
	public Categoria[] getCategorias() {
		return categorias;
	}

	@Override
	public String toString() {
		return "Concurso \n[fechaInicial=" + fechaInicial + ", \nfechaFinal=" + fechaFinal + ", \ncategorias="
				+ Arrays.toString(categorias) + ", \nscan=" + scan + "]";
	}
	
	

}
