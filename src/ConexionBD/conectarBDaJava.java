package ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectarBDaJava {
	static String bd = "retosoftka";
	static String login = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost/" + bd;

	Connection conn = null;

	public void conectarse() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, login, password);
			if (conn != null) {
				//System.out.println("Conexion a la base de datos " + bd + " esta lista.");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("error base de datos desconocida o el servidor no esta en ejecucion");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public void desconectar() {
		conn = null;
		//System.out.println("Conexion a la base de datos " + bd + " esta cerrada");
	}

}
