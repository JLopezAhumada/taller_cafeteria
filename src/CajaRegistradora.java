// Ejercicio 7 - Debugging (código corregido)
public class CajaRegistradora {
    public static void main(String[] args) {
        int cantidadVendida = 5;                              // Error 1: era "5" (texto)
        double precioUnitario = 4500;
        double total = cantidadVendida * precioUnitario;      // Error 2: faltaba el punto y coma
        boolean aplicaDescuento = (total > 20000);
        if (aplicaDescuento) {                                // Error 3: era = (asignación) en vez de comparar
            total = total - (total * 0.10);
        }
        System.out.println("Total: " + total);
    }
}
