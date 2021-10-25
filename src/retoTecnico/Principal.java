package retoTecnico;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(
				"BIENVENIDO AL GENERADOR DE CONCURSOS \nA continuación podrá generar un concurso de preguntas y respuestas con 5 rondas."
						+ "\nCada pregunta cuenta con 1 respuesta correcta y 3 respuestas incorrectas."
						+ "\nCada ronda equivale a una Categoría o nivel de dificultad, iniciando con las preguntas de menor dificultad y ascendiendo hasta las más difíciles."
						+ "\nPara cada Categoría debe crear 5 preguntas del mismo nivel. En cada ronda se escogerá una al azar, por tanto debe plantear 25 preguntas en total."
						+ "\n¡Comencemos!");

		Scanner scan = new Scanner(System.in);
		String respuesta;
		Concurso concurso;

		do {
			System.out.println(
					"¿Desea usar un concurso prediseñado con enunciados tipo dummie para probar el juego? SI/NO");
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

		System.out.println("\nA continuacion dará INICIO el concurso\n");

		concurso.iniciarJuego();

	}

}
