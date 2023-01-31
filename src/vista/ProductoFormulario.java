package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Producto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProductoFormulario extends JFrame {

	private JPanel contentPane;
	public JTextField textNombre;
	public JTextField textPrecio;
	public JTextField textCantidad;
	public JTextField textId;
	public JTextField textCodigo;
	public JButton btnBuscar;
	public JButton btnModificar;
	public JButton btnGuardar;
	public JButton btnEliminar;
	public JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ProductoFormulario frame = new ProductoFormulario();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ProductoFormulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(10, 29, 46, 14);
		contentPane.add(lblCodigo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 52, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 77, 46, 14);
		contentPane.add(lblPrecio);

		textCodigo = new JTextField();
		textCodigo.setBounds(68, 26, 86, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);

		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(66, 49, 86, 20);
		contentPane.add(textNombre);

		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(66, 74, 86, 20);
		contentPane.add(textPrecio);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 115, 46, 14);
		contentPane.add(lblCantidad);

		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(68, 105, 86, 20);
		contentPane.add(textCantidad);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10, 190, 89, 23);
		contentPane.add(btnGuardar);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(132, 190, 89, 23);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(231, 190, 89, 23);
		contentPane.add(btnEliminar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(330, 190, 89, 23);
		contentPane.add(btnLimpiar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(317, 25, 89, 23);
		contentPane.add(btnBuscar);

		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(317, 60, 86, 20);
		contentPane.add(textId);
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void limpiar() {
		textId.setText("");
		textCodigo.setText("");
		textNombre.setText("");
		textCantidad.setText("");
		textPrecio.setText("");
	}

	public Producto getDatosProducto() {
		Producto producto = new Producto();
		producto.setNombre(this.textNombre.getText());
		producto.setCantidad(Integer.parseInt(this.textCantidad.getText()));
		producto.setCodigo(this.textCodigo.getText());
		producto.setPrecio(Double.parseDouble(this.textPrecio.getText()));
		return producto;
	}
}
