package aplicacionFunciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ConexionBD.conectarBDaJava;
import clases.Pregunta;
import clases.Respuesta;
import funcionesBD.RespuestaAbstracta;

public class RespuestaBD extends RespuestaAbstracta {
	static Respuesta[] misrespuestas;

	public void InsertarRespuesta(Respuesta InsRespuesta, int idPregunta) {
		conectarBDaJava abrirConexion = new conectarBDaJava();
		abrirConexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) abrirConexion.getConnection().prepareStatement
					("INSERT INTO respuesta(OpcValida,Opciones,idPregunta) VALUES(?,?,?)");
			sentencia.setString(1, InsRespuesta.getopcValida());
			sentencia.setString(2, InsRespuesta.getopciones());
			sentencia.setInt(3, idPregunta);
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		abrirConexion.desconectar();
		
	}

	public void ModificarRespuesta(Respuesta ModRespuesta) {
		conectarBDaJava conexion  = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement
					("UPDATE respuesta SET OpcValida =?,Opciones=? WHERE IdRespuesta=?");
			sentencia.setString(1,ModRespuesta.getopcValida());
			sentencia.setString(2, ModRespuesta.getopciones());
			//sentencia.setInt(3,ModRespuesta.getIdPregunta());
			sentencia.setInt(3,ModRespuesta.getIdRespuesta());
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
		
	}


	public Respuesta[] ListarRespuesta(Pregunta NumPregunta) {
		conectarBDaJava conexion = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement
					("SELECT * FROM respuesta WHERE IdPregunta="+NumPregunta.getIdPregunta());
			ResultSet resultado = (ResultSet) sentencia.executeQuery();
			//sentencia.setInt(1, NumPregunta.getIdPregunta() );
			
			misrespuestas = new Respuesta[4];
			int i=0;
	
			while(resultado.next()) {
				misrespuestas[i]=new Respuesta(resultado.getInt("IdRespuesta"),resultado.getString("OpcValida"),
						resultado.getString("Opciones"),resultado.getInt("IdPregunta"));
				i++;
			}
			
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
		return misrespuestas;
	}


	


}
