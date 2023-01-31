package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import modelo.Producto;
import modelo.ProductoModelo;
import vista.ProductoFormulario;

public class ControladorProducto implements ActionListener {

	private ProductoModelo productoM;
	private vista.ProductoFormulario formularioProducto;

	public ControladorProducto(ProductoModelo productoM, ProductoFormulario formularioProducto) {
		this.productoM = productoM;
		this.formularioProducto = formularioProducto;
		this.formularioProducto.btnBuscar.addActionListener(this);
		this.formularioProducto.btnEliminar.addActionListener(this);
		this.formularioProducto.btnGuardar.addActionListener(this);
		this.formularioProducto.btnLimpiar.addActionListener(this);
		this.formularioProducto.btnModificar.addActionListener(this);
		this.formularioProducto.btnBuscarTodos.addActionListener(this);
	}

	public void inicializar() {
		this.formularioProducto.setTitle("Productos");
		formularioProducto.setLocationRelativeTo(null);
		formularioProducto.setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == formularioProducto.btnGuardar) {
			
			Producto producto = formularioProducto.getDatosProducto();
			
			productoM.conectar();
			if(productoM.registrar(producto)) {
				JOptionPane.showMessageDialog(formularioProducto, "Producto registrado", "Ok", JOptionPane.INFORMATION_MESSAGE);
				formularioProducto.limpiar();
			}else {
				JOptionPane.showMessageDialog(formularioProducto, "Error en el registro", "Error", JOptionPane.ERROR_MESSAGE);
			}
			productoM.cerrar();
		}
		
		if (e.getSource() == formularioProducto.btnLimpiar) {
			formularioProducto.limpiar();
		}
		
		if (e.getSource() == formularioProducto.btnEliminar) {
			String codigoProducto = formularioProducto.textCodigo.getText();
			Producto producto = new Producto();
			producto.setCodigo(codigoProducto);
			
			productoM.conectar();
			if(productoM.eliminar(producto)) {
				JOptionPane.showMessageDialog(formularioProducto, "Producto eliminado", "Ok", JOptionPane.INFORMATION_MESSAGE);
				formularioProducto.limpiar();
			}else {
				JOptionPane.showMessageDialog(formularioProducto, "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);

			}
			productoM.cerrar();
		}
		
		if(e.getSource() == formularioProducto.btnBuscarTodos) {
			productoM.conectar();
			ArrayList<Producto> productos = productoM.productos();
			productoM.cerrar();
			
			formularioProducto.rellenarTablaProductos(productos);
		}
		
		if (e.getSource() == formularioProducto.btnModificar) {

		}
		
		if (e.getSource() == formularioProducto.btnBuscar) {

		}
	}
	
	
	
}
