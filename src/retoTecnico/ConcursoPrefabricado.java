package retoTecnico;

import java.util.Random;

public class ConcursoPrefabricado {

	public Concurso concursoPredisenado() {
		sleep(2000);
		System.out.println("\nCONCURSO PREDISEÑADO PARA PROBAR EL INICIO DEL JUEGO");

		System.out.println(
				"NOTA: Todos los enunciados para las preguntas y respuestas son señuelos para probar la funcionalidad");

		Concurso concursoPrefabricado = new Concurso();
		Respuesta respCorrecta = new Respuesta("correcta", true);
		Respuesta respIncorrecta1 = new Respuesta("incorrecta", false);
		Respuesta respIncorrecta2 = new Respuesta("incorrecta", false);
		Respuesta respIncorrecta3 = new Respuesta("incorrecta", false);
		Categoria[] categorias = new Categoria[5];

		for (int i = 0; i < 5; i++) {
			Premio premio = new Premio("puntos", 0);
			premio.setCantidad((i + 1) * 100);
			categorias[i] = new Categoria((i + 1), premio);
			Pregunta[] preguntas = new Pregunta[5];

			for (int j = 0; j < 5; j++) {
				Random random = new Random();
				int indiceV = random.nextInt(4);
				String enunciado = "<Se seleccionó al azar la PREGUNTA " + (j + 1) + " de la CATEGORIA " + (i + 1)
						+ ">";
				preguntas[j] = new Pregunta(j, i + 1, enunciado);
				preguntas[j].getRespuestas()[indiceV] = respCorrecta;
				preguntas[j].insertarRespuesta(respIncorrecta1);
				preguntas[j].insertarRespuesta(respIncorrecta2);
				preguntas[j].insertarRespuesta(respIncorrecta3);

			}
			categorias[i].setPreguntas(preguntas);
		}
		concursoPrefabricado.setCategorias(categorias);

		return concursoPrefabricado;
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
