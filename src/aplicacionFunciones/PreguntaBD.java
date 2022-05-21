package aplicacionFunciones;

import clases.Pregunta;
import funcionesBD.PreguntaAbstract;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import ConexionBD.conectarBDaJava;

public class PreguntaBD extends PreguntaAbstract{
	static ArrayList<Pregunta> mispreguntas;
	static Pregunta dato;

	public void InsertarPregunta(Pregunta InsPregunta) {
		conectarBDaJava abrirConexion = new conectarBDaJava();
		abrirConexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) abrirConexion.getConnection().prepareStatement
					("INSERT INTO pregunta(Enunciado,IdCategoria,IdDificultad) VALUES(?,?,?)");
			sentencia.setString(1, InsPregunta.getEnunciado());
			sentencia.setInt(2, InsPregunta.getIdCategoria() );
			sentencia.setInt(3, InsPregunta.getIdDicultad());
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		abrirConexion.desconectar();
	}
	

	public void ModificarPregunta(Pregunta modPregunta) {
		conectarBDaJava conexion  = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement
					("UPDATE pregunta SET Enunciado =?,IdCategoria=?,IdDificultad=? WHERE IdPregunta=?");
			sentencia.setString(1,modPregunta.getEnunciado());
			sentencia.setInt(2, modPregunta.getIdCategoria());
			sentencia.setInt(3,modPregunta.getIdDicultad());
			sentencia.setInt(4, modPregunta.getIdPregunta());
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
	}

	public void EliminarPregunta(Pregunta EliPregunta) {
		conectarBDaJava conexion = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement
					("DELETE FROM pregunta WHERE IdPregunta=?");
			sentencia.setInt(1, EliPregunta.getIdPregunta());
			sentencia.execute();
			sentencia.close();
		}catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
	
	}

	
	public ArrayList<Pregunta> ListarPreguntas() {
		conectarBDaJava conexion = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT * FROM pregunta");
			ResultSet resultado = (ResultSet) sentencia.executeQuery();
			
			 mispreguntas = new ArrayList<Pregunta>();
	
			while(resultado.next()) {
				mispreguntas.add(new Pregunta(resultado.getInt("IdPregunta"),resultado.getString("Enunciado"),
						resultado.getInt("IdCategoria"),resultado.getInt("IdDificultad")));	
			}
			
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
		return mispreguntas;
	}

	public Pregunta PregEspecifica(int idPregunta) {
		conectarBDaJava abrirConexion = new conectarBDaJava();
		abrirConexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) abrirConexion.getConnection().prepareStatement
					("SELECT * FROM pregunta WHERE IdPregunta= "+idPregunta);
			ResultSet resultado = (ResultSet) sentencia.executeQuery();
			//sentencia.setInt(1, idPregunta);
			resultado.next();
			dato = new Pregunta(resultado.getInt("IdPregunta"),resultado.getString("Enunciado"),
							resultado.getInt("IdCategoria"),resultado.getInt("IdDificultad"));
			
			sentencia.execute();
			sentencia.close();
		}catch (SQLException e) {
			System.out.println(e);
		}
		abrirConexion.desconectar();
		return dato;
	}


	public Pregunta PregCategoriaDif(int idCategoria, int idDificultad) {
		conectarBDaJava abrirConexion = new conectarBDaJava();
		abrirConexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) abrirConexion.getConnection().prepareStatement
					("SELECT * FROM pregunta WHERE IdDificultad= "+idDificultad+" AND IdCategoria= "+idCategoria);
			ResultSet resultado = (ResultSet) sentencia.executeQuery();
			//sentencia.setInt(1, idPregunta);
			resultado.next();
			dato = new Pregunta(resultado.getInt("IdPregunta"),resultado.getString("Enunciado"),
							resultado.getInt("IdCategoria"),resultado.getInt("IdDificultad"));
			
			sentencia.execute();
			sentencia.close();
		}catch (SQLException e) {
			System.out.println(e);
		}
		abrirConexion.desconectar();
		return dato;
	}
	
}
