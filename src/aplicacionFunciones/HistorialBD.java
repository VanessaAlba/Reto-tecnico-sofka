package aplicacionFunciones;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import ConexionBD.conectarBDaJava;
import clases.Historial;
import funcionesBD.HistorialAbstract;

public class HistorialBD extends HistorialAbstract{

	static int UltimaPartida;
	public void CrearHistorial(Historial crearHistorial) {
		conectarBDaJava abrirConexion = new conectarBDaJava();
		abrirConexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) abrirConexion.getConnection().prepareStatement
					("INSERT INTO historial(Acumulado,IdJugador) VALUES(?,?)");
			sentencia.setInt(1, crearHistorial.getAcumulado());
			sentencia.setInt(2, crearHistorial.getIdJugador());
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		abrirConexion.desconectar();
		
	}

	
	public int IDPartida() {
		conectarBDaJava conexion = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement
					("SELECT COUNT(IdPartida)IdPartida FROM `historial`");
			ResultSet resultado = (ResultSet) sentencia.executeQuery();
			
			resultado.next();
			UltimaPartida=resultado.getInt("IdPartida");
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
		return UltimaPartida;
	}
}
