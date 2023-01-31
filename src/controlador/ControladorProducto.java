package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			
			ProductoModelo pm = new ProductoModelo();
			pm.conectar();
			if(pm.registrar(producto)) {
				JOptionPane.showMessageDialog(formularioProducto, "Producto registrado", "Ok", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(formularioProducto, "Error en el registro", "Error", JOptionPane.ERROR_MESSAGE);
			}
			pm.cerrar();
		}
		
		if (e.getSource() == formularioProducto.btnLimpiar) {

		}
		
		if (e.getSource() == formularioProducto.btnEliminar) {

		}
		
		if (e.getSource() == formularioProducto.btnModificar) {

		}
		
		if (e.getSource() == formularioProducto.btnBuscar) {

		}
	}
	
	
	
}
