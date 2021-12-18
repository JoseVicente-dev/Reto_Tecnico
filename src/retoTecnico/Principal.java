package retoTecnico;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n*----------------------------------------------------------------------*");
		System.out.println("BIENVENIDO AL GENERADOR DE CONCURSOS");
		System.out.println("*----------------------------------------------------------------------*");
		sleep(3000);
		System.out.println();
		System.out.println("INSTRUCCIONES:");
		sleep(1000);
		System.out.println("A continuación podrá generar un concurso de preguntas y respuestas con 5 Rondas.");
		sleep(3000);
		System.out.println( "Cada Pregunta cuenta con 1 Respuesta correcta y 3 Respuestas incorrectas.");
		sleep(3000);
		System.out.println( "Cada ronda equivale a una Categoría o nivel de dificultad, iniciando con las preguntas de menor dificultad y ascendiendo hasta las más difíciles.");
		sleep(4000);
		System.out.println( "Para cada Categoría debe crear 5 preguntas del mismo nivel. En cada ronda se escogerá una al azar, por tanto debe plantear 25 preguntas en total.");
		sleep(5000);
		System.out.println("¡COMENCEMOS!");
		sleep(3000);

		Scanner scan = new Scanner(System.in);
		String respuesta;
		Concurso concurso;

		do {
			System.out.println(
					"\n¡AVISO! Antes de iniciar,¿desea usar un concurso prediseñado con enunciados explícitos para probar el juego? SI/NO");
			respuesta = scan.nextLine();
			if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {

				System.out.println("<" + respuesta + "> no es una opción válida");
			}

		} while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));

		if (respuesta.equalsIgnoreCase("si")) {
			
			ConcursoPrefabricado concursoPrediPrefabricado = new ConcursoPrefabricado();
			concurso = concursoPrediPrefabricado.concursoPredisenado();
		}

		else {
			concurso = new Concurso();

			concurso.configurarJuego();
		}
		sleep(3000);
		System.out.println("\n*----------------------------------------------------------------------*");
		System.out.println("A continuacion dará INICIO el concurso");
		System.out.println("*----------------------------------------------------------------------*\n");
		sleep(2000);

		concurso.iniciarJuego();

	}
	
	private static void sleep(long millies) {
		try {
			Thread.sleep(millies);
		} catch (InterruptedException e) {
			System.out.println("Hilo interrumpido");
			Thread.currentThread().interrupt();
		}
	}

}
