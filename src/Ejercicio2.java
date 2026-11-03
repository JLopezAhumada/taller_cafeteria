// Ejercicio 2 - Operadores
public class Ejercicio2 {
    public static void main(String[] args) {
        double subtotal = 42500;
        double porcentajeDescuento = 0.15;

        // Si el subtotal es mayor a 30.000 tiene derecho al descuento
        boolean tieneDescuento = subtotal > 30000;

        double valorDescuento = 0;
        if (tieneDescuento) {
            valorDescuento = subtotal * porcentajeDescuento;
        }
        double totalPagar = subtotal - valorDescuento;

        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Valor del descuento: $%.2f%n", valorDescuento);
        System.out.printf("Total a pagar: $%.2f%n", totalPagar);
        System.out.printf("¿Tiene derecho al descuento?: %b%n", tieneDescuento);
    }
}
