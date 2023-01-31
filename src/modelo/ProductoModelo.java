package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoModelo extends Conector {

	public ArrayList<Producto> productos() {
		String sql = "SELECT * FROM productos";
		Statement st;
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			Producto p;
			while(rs.next()) {
				p = new Producto();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setCodigo(rs.getString("codigo"));
				p.setPrecio(rs.getDouble("precio"));
				p.setCantidad(rs.getInt("cantidad"));
				productos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productos;
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
