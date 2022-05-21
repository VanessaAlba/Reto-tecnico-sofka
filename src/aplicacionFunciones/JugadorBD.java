package aplicacionFunciones;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import ConexionBD.conectarBDaJava;
import clases.Categoria;
import clases.Jugador;
import funcionesBD.JugadorAbstract;

public class JugadorBD extends JugadorAbstract{
	static int IdUltimoJugador;

	public void CrearJugador(Jugador crearJugador) {
		conectarBDaJava abrirConexion = new conectarBDaJava();
		abrirConexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) abrirConexion.getConnection().prepareStatement
					("INSERT INTO jugador(Nombre) VALUES(?)");
			sentencia.setString(1, crearJugador.getNombre());
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		abrirConexion.desconectar();
		
	}

	@Override
	public int ObtenerUltJugador() {
		conectarBDaJava conexion = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement
					("SELECT COUNT(IdJugador)IdJugador FROM `jugador`");
			ResultSet resultado = (ResultSet) sentencia.executeQuery();
			
			resultado.next();
			IdUltimoJugador=resultado.getInt("IdJugador");
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
		return IdUltimoJugador;
	}

}
