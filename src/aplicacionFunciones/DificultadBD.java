package aplicacionFunciones;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import ConexionBD.conectarBDaJava;
import clases.Dificultad;
import funcionesBD.DificultadAbstract;

public class DificultadBD extends DificultadAbstract {
    static Dificultad[] dificultadBD;
	
	public Dificultad[] ListarDificultad() {
		conectarBDaJava conexion = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT * FROM dificultad");
			ResultSet resultado = (ResultSet) sentencia.executeQuery();
			
			 dificultadBD = new Dificultad[5];
			 int i=0;
			 while(resultado.next()) {
					dificultadBD[i]=new Dificultad(resultado.getInt("IdDificultad"),resultado.getString("NomDificultad"));
					i++;
			}
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
		return dificultadBD;
	}

}
