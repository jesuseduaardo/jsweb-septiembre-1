package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorConexiones {

	public static Connection obtenerConexion() throws Exception {
		
		// Establecer el nombre del driver a utilizar
		String driver = "com.mysql.cj.jdbc.Driver"; // ctrl+shift+t
		
		// Url de conexion a la DB
		String dbConnectionString = "jdbc:mysql://localhost:3306/jsweb-septiembre?serverTimezone=UTC";
		
		// Usuario
		String userName = "root";
		
		// Password
		String password = "root";
		
		// Establecer conexion con la DB
		Class.forName(driver).newInstance();
		
		// Retornar la conexion
		Connection con = DriverManager.getConnection(dbConnectionString, userName, password);
		
		return con;
	}
}
