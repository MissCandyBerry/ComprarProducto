
import Controlador.CompraController;
import Modelo.Producto;
import java.util.Scanner;

/**
 *
 * @author dulce 252538
 */
public class CompraView {

    /**
     * @param args the command line arguments
     */
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CompraController controller = new CompraController();

        System.out.println("=== BIENVENIDO A LA TIENDA ===");

        //Mostrar catalogo
        System.out.println("\nCatalogo de productos:");
        int i = 1;
        for (Producto p : controller.getCatalogo()) {
            System.out.println(i + ". " + p.getNombre() + " - $" + p.getPrecio());
            i++;
        }

        //Seleccionar productos
        String opcion;
        do {
            System.out.print("\nSeleccione el numero del producto (o 0 para terminar): ");
            int seleccion = sc.nextInt();
            if (seleccion > 0 && seleccion <= controller.getCatalogo().size()) {
                Producto elegido = controller.getCatalogo().get(seleccion - 1);

                //Cantidad
                System.out.print("Ingrese cantidad: ");
                int cantidad = sc.nextInt();

                // Agregar el producto la cantidad de veces indicada
                for (int j = 0; j < cantidad; j++) {
                    controller.agregarProducto(elegido);
                }

                System.out.println("Producto agregado: " + elegido.getNombre() + " x" + cantidad);
                System.out.println("\nCarrito actual:");
                System.out.println(controller.mostrarCarrito());
            }
            System.out.print("Desea agregar otro producto? (s/n): ");
            opcion = sc.next();
        } while (opcion.equalsIgnoreCase("s"));

        // Ingresar tarjeta
        System.out.print("\nIngrese numero de tarjeta (16 digitos): ");
        String numeroTarjeta = sc.next();
        controller.setTarjeta(numeroTarjeta);

        if (controller.validarTarjeta()) {
            System.out.println("\nDatos de la tarjeta:");
            System.out.println(controller.mostrarDatosTarjeta());
        } else {
            System.out.println("Numero de tarjeta invalido. Terminando compra...");
            return;
        }

        //Confirmar pago
        System.out.print("\nDesea confirmar la compra? (s/n): ");
        String pagar = sc.next();
        if (pagar.equalsIgnoreCase("s")) {
            String ticket = controller.pagar();
            System.out.println("\n=== COMPRA REALIZADA ===");
            System.out.println(ticket);
        } else {
            System.out.println("COMPRA CANCELADA.");
        }

        sc.close();
    }
}
    

