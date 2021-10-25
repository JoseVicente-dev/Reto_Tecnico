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

	public void configurarJuego() {
		String tipoDePremio;
		do {
			System.out.println("Ingrese el TIPO DE PREMIO que se otorgará en todas las Categorías (PUNTOS o DINERO)");
			tipoDePremio = scan.nextLine();
			if (!tipoDePremio.equalsIgnoreCase("dinero") && !tipoDePremio.equalsIgnoreCase("puntos")) {

				System.out.println("<" + tipoDePremio + "> no es un tipo de premio válido");
			}

		} while (!tipoDePremio.equalsIgnoreCase("dinero") && !tipoDePremio.equalsIgnoreCase("puntos"));
		
		if (tipoDePremio.equalsIgnoreCase("dinero")){
			tipoDePremio="dólares";
		}

		Categoria categoria1 = configurarCategoria(1, tipoDePremio.toLowerCase());
//		Categoria categoria2 = configurarCategoria(2, tipoDePremio.toLowerCase());
//		Categoria categoria3 = configurarCategoria(3, tipoDePremio.toLowerCase());
//		Categoria categoria4 = configurarCategoria(4, tipoDePremio.toLowerCase());
//		Categoria categoria5 = configurarCategoria(5, tipoDePremio.toLowerCase());
//
		categorias[0] = categoria1;
//		categorias[1] = categoria2;
//		categorias[2] = categoria3;
//		categorias[3] = categoria4;
//		categorias[4] = categoria5;
		System.out.println("\nCONCURSO CONFIGURADO. LISTO PARA INICIAR");
		System.out.println("//=========================//");

	}

	public Categoria configurarCategoria(int ronda, String tipoDePremio) {
		int cantidadPremio;
		do {
			System.out.println("Ingrese el premio de la Categoria No: " + ronda + dificultadRonda(ronda) + ":");
			while (!scan.hasNextInt()) {
				String input = scan.next();
				System.out.println("<" + input + "> no es un valor válido.");

			}
			cantidadPremio = scan.nextInt();
		} while (cantidadPremio < 0);

		Premio premio = new Premio(tipoDePremio, cantidadPremio);
		Categoria categoria = new Categoria(ronda, premio);
		categoria.generarPreguntas();
		System.out.println("CATEGORÍA " + ronda + " TERMINADA");
		System.out.println("//=========================//");
		return categoria;
	}

	public String dificultadRonda(int ronda) {
		String dificultad;

		if (ronda == 1) {
			dificultad = " (Muy fácil)";
		} else if (ronda == 2) {
			dificultad = " (Fácil)";
		} else if (ronda == 3) {
			dificultad = " (Moderada)";
		} else if (ronda == 4) {
			dificultad = " (Difícil)";
		} else {
			dificultad = " (Muy difícil)";
		}
		return dificultad;
	}
	
	public void iniciarJuego() {
		
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
				+ Arrays.toString(categorias) + "]";
	}

}
