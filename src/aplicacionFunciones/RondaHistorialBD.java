package aplicacionFunciones;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import ConexionBD.conectarBDaJava;
import clases.RondaHistorial;
import funcionesBD.RondaHistorialAbstract;

public class RondaHistorialBD extends RondaHistorialAbstract {

	public void CrearRondaHistorial(RondaHistorial CrearRonHis) {
		conectarBDaJava abrirConexion = new conectarBDaJava();
		abrirConexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) abrirConexion.getConnection().prepareStatement
					("INSERT INTO rondahistorial(IdRonda,IdPartida) VALUES(?,?)");
			sentencia.setInt(1, CrearRonHis.getIdRonda());
			sentencia.setInt(2, CrearRonHis.getIdPartida());
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		abrirConexion.desconectar();
		
	}

}
