
package Controlador;

import Modelo.Carrito;
import Modelo.Producto;
import Modelo.Tarjeta;
import Modelo.Ticket;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author dulce
 */

public class CompraController {
    private Carrito carrito;
    private Tarjeta tarjeta;
    private List<Producto> catalogo;

    public CompraController() {
        this.carrito = new Carrito();
        this.catalogo = new ArrayList<>();
        
        // Productos predefinidos
        catalogo.add(new Producto("CLINIQUE Lip Balm #Black Honey", 499.0));
        catalogo.add(new Producto("CLINIQUE Lip Gloss #Black Honey", 499.0));
        catalogo.add(new Producto("GIRLCULT Lip Shine #J79 Desperate", 239.0));
        catalogo.add(new Producto("GIRLCULT Lip Shine #J73 Lethe Water", 239.0));
        catalogo.add(new Producto("JOOYCE Glazed Rouge #539 Chilling Water Hill", 215.0));
        catalogo.add(new Producto("JOOYCE Glazed Rouge 2.0 #561 Naked Tea", 215.0));
        catalogo.add(new Producto("HAUS LABS Triclone Skin Tech Medium Coverage Foundation #070", 1000.0));
        catalogo.add(new Producto("HAUS LABS Triclone Skin Tech Medium Coverage Foundation #190", 1000.0));
        catalogo.add(new Producto("FENTY BEAUTY Gloss Bomb Universal Lip Luminizer #Fuchsia Flex", 490.0));
        catalogo.add(new Producto("FENTY BEAUTY Gloss Bomb Universal Lip Luminizer #Hot Chocolit", 490.0));
    }

    // === Gestión de productos ===
    public void agregarProducto(Producto producto) {
        carrito.agregarProducto(producto);
    }

    public String mostrarCarrito() {
        StringBuilder sb = new StringBuilder();
        for (Producto p : carrito.getProductos()) {
            sb.append(p.getNombre())
              .append(" - $").append(p.getPrecio()).append("\n");
        }
        sb.append("Total: $").append(carrito.getTotal()).append("\n");
        return sb.toString();
    }

    // === Gestión de tarjeta ===
    public void setTarjeta(String numero) {
        this.tarjeta = new Tarjeta(numero);
    }

    public boolean validarTarjeta() {
        if (tarjeta == null) return false;
        return tarjeta.validar();
    }

    public String mostrarDatosTarjeta() {
        if (tarjeta == null) return "No se ha ingresado tarjeta.";
        return "Banco: " + tarjeta.getBanco() + "\n" +
               "Ciudad: " + tarjeta.getCiudad() + "\n" +
               "Número: " + tarjeta.getNumero();
    }

    // === Pago y ticket ===
    public String pagar() {
        if (tarjeta == null || !tarjeta.validar()) {
            return "Error: Tarjeta inválida.";
        }
        Ticket ticket = new Ticket(carrito, tarjeta);
        return ticket.generarComprobante();
    }
    
    public List<Producto> getCatalogo() {
    return catalogo;
}
}

