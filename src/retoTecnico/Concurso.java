package retoTecnico;

import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Concurso {

	private String fechaInicial;
	private String fechaFinal;
	private Categoria[] categorias = new Categoria[5];
	private Scanner scan = new Scanner(System.in);
	private Jugador jugador;

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
		
		crearJugador();
		for (int i=0;i<6;++i) {
			
			int ronda = i+1;
			Categoria categoria = getCategorias()[i];
			Premio premioActual = categoria.getPremio();
			sleep(3000);
			System.out.println("se muestran las preguntas de la CATEGORIA "+categoria.getRonda()+"\n----------\n");
			
			
			System.out.println("En la CATEGORIA No." + categoria.getRonda() + ", por un PREMIO de "
					+ premioActual.getCantidad() +" "+ premioActual.getTipo());
			sleep(3000);
			System.out.println("\nResponda la siguente pregunta");
			
			Pregunta preguntaSeleccionada = categoria.getPreguntas()[0];
			preguntaSeleccionada.mostrarEnunciado();
			
			responderPregunta(preguntaSeleccionada);
			preguntaSeleccionada.verificarRespuestaCorrecta();
			sleep(3000);
			
			if(preguntaSeleccionada.verificarRespuestaCorrecta()) {
				System.out.println("Respuesta CORRECTA!");
				aumentarNivel(jugador, premioActual.getCantidad(), categoria.getRonda());
				System.out.println(jugador);
			}
			else {
				System.out.println("¡INCORRECTO! Mejor suerte para la proxima");
				break;
			}
		}
		
		
	}
	
	public void crearJugador() {
		System.out.println("//-------------------------//");
		System.out.println("Introduzca los datos del JUGADOR");
		System.out.println("//-------------------------//");
		int identificacion;
		do {
			System.out.println("Introduzca NUMERO DE IDENTIFICACION:");
			while (!scan.hasNextInt()) {
				String input = scan.next();
				System.out.println("<" + input + "> no es un valor válido.");

			}
			identificacion = scan.nextInt();
		} while (identificacion < 0);
		
		
		System.out.println("Introduzca NOMBRE:");
		String nombres =scan.nextLine();
		System.out.println("Introduzca APELLIDOS:");
		String apellidos =scan.nextLine();
		
		this.jugador = new Jugador(identificacion, nombres, apellidos, this.fechaInicial);
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
	
	public void aumentarNivel(Jugador jugador, int premio, int nivelMaximoAlcanzado) {
		jugador.aumentarPuntaje(premio);
		jugador.setNivelMaximoAlcanzado(nivelMaximoAlcanzado);
	}
	
	private static void sleep(long millies) {
		try {
			Thread.sleep(millies);
		} catch (InterruptedException e) {
			System.out.println("Hilo interrumpido");
			Thread.currentThread().interrupt();
		}
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

	/**
	 * @return the jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}

	/**
	 * @param jugador the jugador to set
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public String toString() {
		return "Concurso \n[fechaInicial=" + fechaInicial + ", \nfechaFinal=" + fechaFinal + ", \njugador=" + jugador
				+ ", \ncategorias=" + Arrays.toString(categorias) + "]";
	}

	

}
