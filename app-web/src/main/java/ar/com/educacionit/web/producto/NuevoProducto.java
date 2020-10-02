package ar.com.educacionit.web.producto;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exeptions.DuplicatedException;
import ar.com.educacionit.dao.exeptions.GenericDAOException;
import ar.com.educacionit.domain.Producto;

public class NuevoProducto {

	public static void main(String[] args) throws Exception {
		
		Producto nuevoProducto = new Producto("TERMO LUMILAGRO", 1500f, "0001", 2L);	
		int reintentos = 3;
		boolean success = false;
		while (!success && reintentos > 0) {
			try {
				ProductoDAO.createProducto(nuevoProducto);
				System.out.println(nuevoProducto);
				success = true;
			} catch (DuplicatedException e) {
				System.out.println("No se pudo crear el producto, ya existe el codigo: "+nuevoProducto.getCodigo());
				nuevoProducto.setCodigo("0003");
			} catch (GenericDAOException e) {
				System.out.println("No se pudo crear el producto, error inesperado por favor reintente de nuevo");
			}
			reintentos--;
		}
	}

}
