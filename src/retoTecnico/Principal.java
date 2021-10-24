package retoTecnico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		
		Concurso concurso = new Concurso();
		
		System.out.println("Categoría I (Muy fácil)");
		
		byte ronda1 = 1;
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese el premio de la Categoria 1:");
		int premio1 = scan.nextInt();
		
		Categoria categoria1 = new Categoria (ronda1, premio1);
		
		
				
		

		try {

			// Se crean las variables donde se guardará cada campo de la tabla
			int documento;
			String nombres, apellidos, ciudad;

			// Carga del driver de SQLite
			Class.forName("org.sqlite.JDBC");

			// Conexion con la BD usando un relative path
			String url = "jdbc:sqlite:concesionario.db";
			Connection conexion = DriverManager.getConnection(url);

			/*
			 * Creacion de una consulta, en este caso, obtener todos los registros de la
			 * tabla vendedores. Notese que se usa el lenguaje SQL
			 */
			String sentencia = "SELECT * FROM vendedores;";

			// Objeto que representa una consulta a la BD
			Statement consulta = conexion.createStatement();

			// Se crea un ResultSet con los resultados de la consulta y se itera sobre el
			// mismo
			ResultSet resultados = consulta.executeQuery(sentencia);
			System.out.println("Listado de Vendedores");
			while (resultados.next()) {
				documento = resultados.getInt("documentovendedor");
				nombres = resultados.getString("nombres");
				apellidos = resultados.getString("apellidos");
				ciudad = resultados.getString("ciudad");

				System.out.println("Documento: " + documento + " Nombres: " + nombres + " Apellidos: " + apellidos
						+ " Ciudad: " + ciudad);
			}
			// Se cierra la conexion
			conexion.close();

		} catch (ClassNotFoundException e) {
			System.out.println("No fue posible cargar el driver.");
		}

		catch (SQLException e) {
			System.out.println("Hubo un error al acceder a la base de datos: " + e.getMessage());
		}

	}

}
