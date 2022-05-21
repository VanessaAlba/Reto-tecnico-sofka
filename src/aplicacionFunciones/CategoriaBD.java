package aplicacionFunciones;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import ConexionBD.conectarBDaJava;
import clases.Categoria;
import funcionesBD.CategoriaAbstract;

public class CategoriaBD extends CategoriaAbstract{
	static Categoria[] miscategorias;

	public Categoria[] ListarCategorias() {
		conectarBDaJava conexion = new conectarBDaJava();
		conexion.conectarse();
		try {
			PreparedStatement sentencia = (PreparedStatement) conexion.getConnection().prepareStatement("SELECT * FROM categoria");
			ResultSet resultado = (ResultSet) sentencia.executeQuery();
			
			 miscategorias = new Categoria[5];
			 int i=0;
			 while(resultado.next()) {
					miscategorias[i]=new Categoria(resultado.getInt("IdCategoria"),resultado.getString("NomCategoria"));
					i++;
			}
			sentencia.execute();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		conexion.desconectar();
		return miscategorias;
	}

}
