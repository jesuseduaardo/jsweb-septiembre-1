package ar.com.educacionit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import ar.com.educacionit.dao.exeptions.DuplicatedException;
import ar.com.educacionit.dao.exeptions.GenericDAOException;
import ar.com.educacionit.dao.exeptions.NonExistException;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.jdbc.AdministradorConexiones;

//ctrl+shift+o
public class ProductoDAO {

	public static Producto createProducto(Producto producto) throws DuplicatedException, GenericDAOException {

		Connection connection;
		// Se controla la excepcion en caso que exista
		try {
			connection = AdministradorConexiones.obtenerConexion();
		} catch (Exception e) {
			throw new GenericDAOException(e.getMessage(), e);
		}
		// Crear el statement: "SELECT * FROM..."
		String sql = "INSERT INTO `jsweb-septiembre`.`productos` (`titulo`, `precio`, `codigo`, `tipo_producto`) "
				+ "VALUES ('"+ producto.getTitulo() + "', '" + producto.getPrecio() + "', '" + producto.getCodigo() + "', '" + producto.getTipoProducto() + "');";
		
		Statement st;
		try {
			st = connection.createStatement();
			int resultado = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			// Obteniendo resultados
			ResultSet rs = st.getGeneratedKeys();
			Long idGenerado = null;
			if (rs.next()) {
				idGenerado = rs.getLong(1);
			}
			producto.setId(idGenerado);
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new DuplicatedException(e.getMessage(), e);
		} catch (SQLException e) {
			throw new GenericDAOException(e.getMessage(), e);
		} finally {
			// Al final se cierra la conexion
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericDAOException("No se pudo cerrar la conexion, verifique en la db las conexiones posibles", e);
			}
		}

		return null;
	}

	private static Producto Producto(Long idGenerado, String titulo, Float precio, String codigo, Long tipoProducto) {
		// TODO Auto-generated method stub
		return null;
	}


	public static void deleteProducto(Long id) throws NonExistException {

	}

	public Producto get(Long id) throws GenericDAOException {

		return null;
	}

	public Producto[] obtenerTodos() throws GenericDAOException {
		return null;
	}
}
