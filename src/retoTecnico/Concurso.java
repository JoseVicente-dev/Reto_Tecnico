package retoTecnico;

import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
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

		if (tipoDePremio.equalsIgnoreCase("dinero")) {
			tipoDePremio = "dólares";
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
		conectarBD();
		insertarBD(jugador);
		
		for (int i = 0; i < 6; ++i) {
			
			
			Categoria categoria = getCategorias()[i];
			Premio premioActual = categoria.getPremio();
			int ronda =categoria.getRonda();
			sleep(3000);
			System.out.println("se muestran las preguntas de la CATEGORIA " + categoria.getRonda() + "\n----------\n");

			System.out.println("En la CATEGORIA No." + categoria.getRonda() + ", por un PREMIO de "
					+ premioActual.getCantidad() + " " + premioActual.getTipo());
			
			boolean finDelJuego = finDelJuegoVoluntario(ronda);
			
			if (finDelJuego) {
				System.out.println("Es una pena que te retires. Mejor suerte para la proxima");
			}
			
			else {
				
				sleep(3000);
				System.out.println("\nResponda la siguente pregunta");
				
				Pregunta preguntaSeleccionada = categoria.getPreguntas()[0];
				preguntaSeleccionada.mostrarEnunciado();
				
				responderPregunta(preguntaSeleccionada);
				preguntaSeleccionada.verificarRespuestaCorrecta();
				sleep(3000);
				
				if (preguntaSeleccionada.verificarRespuestaCorrecta()) {
					System.out.println("Respuesta CORRECTA!");
					aumentarNivel(jugador, premioActual.getCantidad(), categoria.getRonda());
					System.out.println(jugador);
					conectarBD();
					actualizarBD(jugador);
					leerBD();
					
					
				} else {
					System.out.println("¡INCORRECTO! Mejor suerte para la proxima");
					finDelJuegoForzado(ronda);
				}
			}
			
			
		}

	}

	public void crearJugador() {
		
		System.out.println("//-------------------------//");
		System.out.println("Introduzca los datos del JUGADOR");
		System.out.println("//-------------------------//");
		int identificacion;
		String nombres;
		String apellidos;
		do {
			System.out.println("Introduzca NUMERO DE IDENTIFICACION:");
			while (!scan.hasNextInt()) {
				String input = scan.next();
				System.out.println("<" + input + "> no es un valor válido.");

			}
			identificacion = scan.nextInt();
		} while (identificacion < 0);
		
		
		do {
			System.out.println("Introduzca NOMBRES:");
			nombres = scan.nextLine();
			if (nombres.equalsIgnoreCase("") || nombres==null) {

				System.out.println("Los nombres no pueden ser vacíos");
			}

		} while (nombres.equalsIgnoreCase("") || nombres==null);
		
		
		do {
			System.out.println("Introduzca APELLIDOS:");
			apellidos = scan.nextLine();
			if (apellidos.equalsIgnoreCase("") || apellidos==null) {

				System.out.println("Los apellidos no pueden ser vacíos");
			}

		} while (apellidos.equalsIgnoreCase("") || apellidos==null);

		this.jugador = new Jugador(identificacion, nombres.toLowerCase(), apellidos.toLowerCase(), this.fechaInicial);
	}

	public void responderPregunta(Pregunta pregunta) {
		int seleccion;
		do {
			System.out.println("Escoja una RESPUESTA:");
			while (!scan.hasNextInt()) {
				String input = scan.next();
				System.out.println("<" + input + "> no es una opción válida.");

			}
			seleccion = scan.nextInt();
		} while (seleccion < 1 && seleccion > 4);

		pregunta.setSeleccion(seleccion);

	}

	public void aumentarNivel(Jugador jugador, int premio, int nivelMaximoAlcanzado) {
		jugador.aumentarPuntaje(premio);
		jugador.setNivelMaximoAlcanzado(nivelMaximoAlcanzado);
	}

	public boolean finDelJuegoVoluntario(int ronda) {

		boolean finDelJuego = false;

		String respuesta;
		do {
			System.out.println("¿Desea CONTINUAR? SI/NO");
			respuesta = scan.nextLine();
			if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {

				System.out.println("<" + respuesta + "> no es una opción válida");
			}

		} while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("puntos"));

		if (respuesta.equalsIgnoreCase("si")) {
			finDelJuego = true;
			this.fechaFinal = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
			jugador.setEstado("retirado");
			jugador.setNivelMaximoAlcanzado(ronda);
			
			conectarBD();
			actualizarBD(this.jugador);
			leerBD();
			return finDelJuego;
		}

		return finDelJuego;
	}
	
	public boolean finDelJuegoForzado(int ronda) {
		
		boolean finDelJuego= true;
		this.fechaFinal = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		jugador.setEstado("eliminado");
		jugador.setNivelMaximoAlcanzado(ronda);
		
		conectarBD();
		actualizarBD(this.jugador);
		leerBD();
		
		return finDelJuego;
		
		
		
	}

	private static void sleep(long millies) {
		try {
			Thread.sleep(millies);
		} catch (InterruptedException e) {
			System.out.println("Hilo interrumpido");
			Thread.currentThread().interrupt();
		}
	}

	public Connection conectarBD() {
		Connection conexion = null;
		try {
			// Carga del driver de SQLite
			Class.forName("org.sqlite.JDBC");

			// Conexion con la BD usando un relative path
			String url = "jdbc:sqlite:concurso.db";
			conexion = DriverManager.getConnection(url);

		} catch (ClassNotFoundException e) {
			System.out.println("No fue posible cargar el driver.");
		}

		catch (SQLException e) {
			System.out.println("Hubo un error al acceder a la base de datos: " + e.getMessage());
		}

		return conexion;

	}

	public void insertarBD(Jugador jugador) {
		// CREATE
		int identificacion = jugador.getIdentificacion();
		String nombres = jugador.getNombres();
		String apellidos = jugador.getApellidos();
		int puntaje = jugador.getPuntaje();
		String estado = jugador.getEstado();
		String fechaPartipacion = jugador.getFechaParticipacion();
		int nivelMaximo = jugador.getNivelMaximoAlcanzado();

		String sentencia = "INSERT INTO Jugadores (identificacion, nombres, apellidos, puntaje, fecha_participacion, estado, nivel_maximo) VALUES (?,?,?,?,?,?,?);";
		
		try (Connection conexion = this.conectarBD(); PreparedStatement pstmt = conexion.prepareStatement(sentencia)) {
			pstmt.setInt(1, identificacion);
			pstmt.setString(2, nombres);
			pstmt.setString(3, apellidos);
			pstmt.setInt(4, puntaje);
			pstmt.setString(5, estado);
			pstmt.setString(6, fechaPartipacion);
			pstmt.setInt(7, nivelMaximo);
			pstmt.executeUpdate();
			conexion.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
			
		}
		
	}

	public void leerBD() {
		// READ
		String sentencia = "SELECT * FROM jugadores;";

		try (Connection conexion = this.conectarBD();
				Statement consulta = conexion.createStatement();
				ResultSet resultados = consulta.executeQuery(sentencia);) {

			int identificacion;
			String nombres;
			String apellidos;
			int puntaje;
			String estado;
			String fechaParticipacion;
			int nivelMaximo;

			System.out.println("Listado de Jugadores");
			while (resultados.next()) {
				identificacion = resultados.getInt("identificacion");
				nombres = resultados.getString("nombres");
				apellidos = resultados.getString("apellidos");
				puntaje = resultados.getInt("puntaje");
				estado = resultados.getString("estado");
				fechaParticipacion = resultados.getString("fecha_participacion");
				nivelMaximo = resultados.getInt("nivel_maximo");

				System.out.println("identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos="
						+ apellidos + ", puntaje=" + puntaje + ", fechaParticipacion=" + fechaParticipacion
						+ ", estado=" + estado + ", nivelMaximoAlcanzado=" + nivelMaximo);
			}
			// Se cierra la conexion
			conexion.close();
		}

		catch (SQLException e) {
			System.out.println("Hubo un error al acceder a la base de datos: " + e.getMessage());
		}
	}

	public void actualizarBD(Jugador jugador) {
		
		//UPDATE
		int identificacion = jugador.getIdentificacion();
		int puntaje = jugador.getPuntaje();
		String estado = jugador.getEstado();
		int nivelMaximo = jugador.getNivelMaximoAlcanzado();

		String sentencia = "UPDATE jugadores SET puntaje = ?, estado = ?, nivel_maximo=? WHERE identificacion =?;";

		try (Connection conexion = this.conectarBD(); PreparedStatement pstmt = conexion.prepareStatement(sentencia)) {

			pstmt.setInt(1, puntaje);
			pstmt.setString(2, estado);
			pstmt.setInt(3, nivelMaximo);
			pstmt.setInt(4, identificacion);
			pstmt.executeUpdate();
			conexion.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
