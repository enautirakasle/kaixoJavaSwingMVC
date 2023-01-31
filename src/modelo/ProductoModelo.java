package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoModelo extends Conector {

	ArrayList<Producto> productos() {
		return null;
	}

	public boolean registrar(Producto producto) {
		PreparedStatement pst = null;
		String sql = "INSERT INTO productos(codigo, nombre, precio, cantidad )VALUES(?, ?, ?, ?)";
		try {
			pst = con.prepareStatement(sql);

			pst.setString(1, producto.getCodigo());
			pst.setString(2, producto.getNombre());
			pst.setDouble(3, producto.getPrecio());
			pst.setInt(4, producto.getCantidad());
			
			pst.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e);
			return false;
		}
	}
	
	public boolean modificar(Producto producto) {
		return false;
	}
	
	/*
	 * producto viene con codigo relleno
	 * elimin el procducto con ese código
	 */
	public boolean eliminar(Producto producto) {
		PreparedStatement pst = null;
		String sql = "DELETE FROM productos WHERE codigo = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, producto.getCodigo());
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean buscar(Producto producto) {
		return false;
	}

	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		
	}
	

	

}
