package aplicacionFunciones;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import ConexionBD.conectarBDaJava;
import clases.Premio;
import funcionesBD.PremioAbstract;

public class PremioBD extends PremioAbstract {

	static Premio[] premiosBD;
	static int puntaje; 
	
	public Premio[] listarPremio() {
		conectarBDaJava conexion = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT * FROM premio");
			ResultSet resultado = (ResultSet) sentencia.executeQuery();
			
			 premiosBD = new Premio[5];
			 int i=0;
			 while(resultado.next()) {
					premiosBD[i]=new Premio(resultado.getInt("IdPremio"),resultado.getInt("Puntaje"),resultado.getInt("IdRonda"));
					i++;
			}
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
		return premiosBD;
	}

	
	public int ObtenerPremio(int ronda) {
		
		conectarBDaJava conexion = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement
					("SELECT Puntaje FROM premio WHERE IdRonda= "+ronda);
			ResultSet resultado = (ResultSet) sentencia.executeQuery();
			
			resultado.next();
			puntaje=resultado.getInt("Puntaje");
			 
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
		return puntaje;
	}

}
