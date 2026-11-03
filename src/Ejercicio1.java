// Ejercicio 1 - Variables y tipos de dato
public class Ejercicio1 {
    public static void main(String[] args) {
        String nombreProducto = "Café americano";
        double precioUnitario = 3500.50;
        int cantidadInventario = 40;
        boolean disponibleHoy = true;
        char codigoProducto = 'A';

        System.out.println("=== Producto de la cafetería ===");
        System.out.println(String.format("Nombre del producto: %s", nombreProducto));
        System.out.println(String.format("Precio unitario: $%.2f", precioUnitario));
        System.out.println(String.format("Cantidad en inventario: %d", cantidadInventario));
        System.out.println(String.format("Disponible hoy: %b", disponibleHoy));
        System.out.println(String.format("Código del producto: %c", codigoProducto));
    }
}
