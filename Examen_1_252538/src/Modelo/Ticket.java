
package Modelo;

/**
 *
 * @author dulce
 */

public class Ticket {
    private Carrito carrito;
    private Tarjeta tarjeta;

    public Ticket(Carrito carrito, Tarjeta tarjeta) {
        this.carrito = carrito;
        this.tarjeta = tarjeta;
    }

    public String generarComprobante() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== TICKET DE COMPRA =====\n");
        sb.append("Productos:\n");
        for (Producto p : carrito.getProductos()) {
            sb.append("- ").append(p.getNombre())
              .append(" $").append(p.getPrecio()).append("\n");
        }
        sb.append("\nTotal: $").append(carrito.getTotal()).append("\n\n");
        sb.append("Pago con tarjeta:\n");
        sb.append("Banco: ").append(tarjeta.getBanco()).append("\n");
        sb.append("Ciudad: ").append(tarjeta.getCiudad()).append("\n");
        sb.append("Número: ").append(tarjeta.getNumero()).append("\n");
        sb.append("============================\n");
        return sb.toString();
    }
}
 

