package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ProductoModelo;
import vista.Principal;
import vista.ProductoFormulario;
/**
 * Escuchara eventos de los componentes del jframe vista.Principal
 * y ejecutará las acciones de los métodos.
 * 
 * @author eñaut a.a.
 *
 */
public class ControladorPrincipal implements ActionListener{
	/**
	 * los atributos del controlador son las ventanas y modelos a las que accede
	 */
	private Principal frmPrincipal;
	
	/**
	 * El controlador recibirá como parametro las vistas y modelos que va a controlar
	 * 
	 * @param principal jFrame que va a ser controlado (escuchado)
	 */
	public ControladorPrincipal(Principal principal) {
		/*
		 * inicializaremos las ventanas y los modelos
		 */
		frmPrincipal = principal;
		
		/*
		 * asignaremos los eventos a los botones
		 */
		frmPrincipal.btnGestionarProductos.addActionListener(this);
	}
	
	/**
	 * Una especie de reset de la vista
	 * aqui tambien se podrá acceder al modelo si se quiere mostrar algún dato
	 * cuando se abra la ventana
	 */
	public void inicializar() {
		frmPrincipal.setTitle("Desktop");
		frmPrincipal.setLocationRelativeTo(null);
		frmPrincipal.setVisible(false);
	}

	/**
	 * Cuando algún elemento de la vista controlada por esta clase es accionada 
	 * por ejemplo clic de boton etc, se ejecutará este método
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//con este if sabremos que boton ha sido clicado
		if(e.getSource() == frmPrincipal.btnGestionarProductos) {
			ProductoModelo productoM = new ProductoModelo();
			vista.ProductoFormulario productoF = new ProductoFormulario(frmPrincipal, true);
			
			ControladorProducto productoC = new ControladorProducto(productoM, productoF);
			productoC.inicializar();
			productoF.setVisible(true);
		}
	}

}
