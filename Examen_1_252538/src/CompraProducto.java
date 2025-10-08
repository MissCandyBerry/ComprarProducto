
import Controlador.CompraController;
import Modelo.Producto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author dulce
 */
public class CompraProducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         CompraController controller = new CompraController();
         
         // Agregar productos
        controller.agregarProducto(new Producto("CLINIQUE Lip Gloss #Black Honey", 499.0));
        controller.agregarProducto(new Producto("CLINIQUE Lip Balm #Black Honey", 499.0));


        System.out.println(controller.mostrarCarrito());

        // Ingresar tarjeta
        controller.setTarjeta("1234567812345678");
        System.out.println(controller.mostrarDatosTarjeta());

        // Pagar
        System.out.println(controller.pagar());
    }
    
}
