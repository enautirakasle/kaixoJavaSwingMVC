package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Producto;
import modelo.ProductoModelo;
import vista.ProductoFormulario;

public class ControladorProducto implements ActionListener {

	private Producto producto;
	private ProductoModelo productoM;
	private vista.ProductoFormulario formularioProducto;

	public ControladorProducto(Producto producto, ProductoModelo productoM, ProductoFormulario formularioProducto) {
		this.producto = producto;
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
		formularioProducto.setLocation(null);
		formularioProducto.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == formularioProducto.btnGuardar) {
			Producto producto = new Producto();
			
			producto.setNombre(formularioProducto.textNombre.getText());
			producto.setCantidad(Integer.parseInt(formularioProducto.textCantidad.getText()));
			producto.setCodigo(formularioProducto.textCodigo.getText());
			producto.setPrecio(Double.parseDouble(formularioProducto.textPrecio.getText()));
			
			ProductoModelo pm = new ProductoModelo();
			pm.conectar();
			if(pm.registrar(producto)) {
				JOptionPane.showMessageDialog(formularioProducto, "Producto registrado");
				JOptionPane.showInternalMessageDialog(formularioProducto, "Producto registrado", "Registro", JOptionPane.OK_OPTION);
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
