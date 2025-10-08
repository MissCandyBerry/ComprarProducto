
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dulce
 */


public class Carrito {
    private List<Producto> listaProductos;
    private double total;

    public Carrito() {
        listaProductos = new ArrayList<>();
        total = 0.0;
    }

    public void agregarProducto(Producto p) {
        listaProductos.add(p);
        total += p.getPrecio();
    }

    public List<Producto> getProductos() {
        return listaProductos;
    }

    public double getTotal() {
        return total;
    }

    public void mostrarProductos() {
        for (Producto p : listaProductos) {
            System.out.println(p);
        }
        System.out.println("Total: $" + total);
    }
}

