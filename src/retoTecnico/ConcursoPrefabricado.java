package retoTecnico;

import java.util.Random;

public class ConcursoPrefabricado {

	public Concurso concursoPredisenado() {

		System.out.println("CONCURSO PREDISEÑADO PARA PROBAR EL INICIO DEL JUEGO");
		System.out.println("\nNOTA: Todos los enunciados para las preguntas y respuestas son dummies");

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

				Pregunta pregunta = new Pregunta(j, j + 1, "Este es el enunciado(?)");
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

}
