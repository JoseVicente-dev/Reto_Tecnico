package retoTecnico;
import java.sql.*;


public class PruebaSQlite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
try {
			
			//Se crean las variables donde se guardará cada campo de la tabla
			int documento;
			String nombres, apellidos, ciudad;
			
			//Carga del driver de SQLite
			Class.forName("org.sqlite.JDBC");
			
			//Conexion con la BD usando un relative path
			String url="jdbc:sqlite:concesionario.db";
			Connection conexion = DriverManager.getConnection(url);
			
			/*Creacion de una consulta, en este caso, obtener todos los registros de la tabla vendedores.
			Notese que se usa el lenguaje SQL
			*/
			String sentencia = "SELECT * FROM vendedores;";
			
			//Objeto que representa una consulta a la BD
			Statement consulta = conexion.createStatement();
			
			//Se crea un ResultSet con los resultados de la consulta y se itera sobre el mismo
			ResultSet resultados = consulta.executeQuery(sentencia);
			System.out.println("Listado de Vendedores");
			while (resultados.next()) {
				documento = resultados.getInt("documentovendedor");
				nombres = resultados.getString("nombres");
				apellidos = resultados.getString("apellidos");
				ciudad = resultados.getString("ciudad");
				
				
				System.out.println("Documento: "+documento+" Nombres: "+nombres+" Apellidos: "+apellidos+" Ciudad: "+ciudad);
			}
			//Se cierra la conexion
			conexion.close();
			
		}
		catch (ClassNotFoundException e) {
			System.out.println("No fue posible cargar el driver.");
		}
		
		catch (SQLException e) {
			System.out.println("Hubo un error al acceder a la base de datos: "+e.getMessage());
		}

	}

}
