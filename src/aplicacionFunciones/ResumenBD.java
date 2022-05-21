package aplicacionFunciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ConexionBD.conectarBDaJava;
import clases.Pregunta;
import clases.Resumen;
import funcionesBD.ResumenAbstract;

public class ResumenBD extends ResumenAbstract {

	static ArrayList<Resumen> resumenBD;
	public ArrayList<Resumen> ListarDatos() {
		conectarBDaJava conexion = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement
					("SELECT Nombre,Acumulado,idRonda FROM jugador,historial,rondahistorial "
							+ "WHERE jugador.IdJugador=historial.IdJugador AND historial.IdPartida=rondahistorial.IdPartida;");
			ResultSet resultado = (ResultSet) sentencia.executeQuery();
			
			 resumenBD = new ArrayList<Resumen>();
	
			while(resultado.next()) {
				resumenBD.add(new Resumen(resultado.getString("Nombre"),resultado.getInt("Acumulado"),resultado.getInt("idRonda")));	
			}
			
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
		return resumenBD;
	}

}
