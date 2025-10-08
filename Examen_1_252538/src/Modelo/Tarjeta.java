
package Modelo;

/**
 *
 * @author dulce
 */
public class Tarjeta {
    private String numero;
    private String banco;
    private String ciudad;

    public Tarjeta(String numero) {
        this.numero = numero;
        this.banco = "HSBC";
        this.ciudad = "Navojoa, Son.";
    }

    public boolean validar() {
        // Validación simple: longitud de 16 dígitos
        return numero != null && numero.length() == 16;
    }

    public String getNumero() { return numero; }
    public String getBanco() { return banco; }
    public String getCiudad() { return ciudad; }
}

