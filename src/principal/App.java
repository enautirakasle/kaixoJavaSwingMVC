package principal;

import controlador.ControladorProducto;
import modelo.ProductoModelo;
import vista.ProductoFormulario;

public class App {

	public static void main(String[] args) {
		ProductoModelo productoM = new ProductoModelo();
		vista.ProductoFormulario productoF = new ProductoFormulario();
		
		ControladorProducto productoC = new ControladorProducto(productoM, productoF);
		productoC.inicializar();
		productoF.setVisible(true);
		
	}

}
