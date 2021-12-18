package retoTecnico;

import java.util.Random;

public class ConcursoPrefabricado {

	public Concurso concursoPredisenado() {
		sleep(2000);
		System.out.println("\nCONCURSO PREDISEÑADO PARA PROBAR EL INICIO DEL JUEGO");
		
		System.out.println("NOTA: Todos los enunciados para las preguntas y respuestas son señuelos para probar la funcionalidad");
				
		Concurso concursoPrefabricado = new Concurso();
		Respuesta respCorrecta = new Respuesta("correcta", true);
		Respuesta respIncorrecta1 = new Respuesta("incorrecta", false);
		Respuesta respIncorrecta2 = new Respuesta("incorrecta", false);
		Respuesta respIncorrecta3 = new Respuesta("incorrecta", false);
		Categoria[] categorias = new Categoria[5];
		Pregunta[] preguntas = new Pregunta[5];

		for (int i = 0; i < 5; ++i) {
			Premio premio = new Premio("puntos", 0);
			premio.setCantidad((i + 1) * 100);
			Categoria categoria = new Categoria((i + 1), premio);

			for (int j = 0; j < 5; ++j) {
				Random random = new Random();
				int indiceV = random.nextInt(4);

				Pregunta pregunta = new Pregunta(j, j + 1, "<Aqui va el enunciado de la pregunta>");
				pregunta.getRespuestas()[indiceV] = respCorrecta;
				pregunta.insertarRespuesta(respIncorrecta1);
				pregunta.insertarRespuesta(respIncorrecta2);
				pregunta.insertarRespuesta(respIncorrecta3);

				preguntas[j] = pregunta;
				categoria.setPreguntas(preguntas);

			}
			categorias[i] = categoria;

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
