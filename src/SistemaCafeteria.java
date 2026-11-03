// Parte 2 - Sistema de turno de cafetería
public class SistemaCafeteria {
    public static void main(String[] args) {
        String[] nombres = {"Café americano", "Capuchino", "Jugo naranja", "Tostada", "Brownie"};
        double[] precios = {3500, 5000, 4000, 4500, 6000};
        char[] categorias = {'B', 'B', 'F', 'C', 'P'}; // B=Bebida caliente, F=Fría, C=Comida, P=Postre
        int[] pedidoProducto = {0, 2, 1, 4, 0, 3}; // índice del producto en cada pedido
        int[] pedidoCantidad = {2, 1, 3, 1, 1, 2}; // unidades por pedido

        int inventarioBrownie = 10;

        // Tarea 4 - Apertura de turno
        System.out.println("===== APERTURA DE TURNO =====");
        double[] valoresIngresados = {-50000, 100000}; // el primero es inválido
        int intento = 0;
        double montoApertura;

        do {
            montoApertura = valoresIngresados[intento];
            intento++;
            System.out.println("Intento " + intento + ": monto de apertura $" + montoApertura);
            if (montoApertura <= 0) {
                System.out.println("Monto inválido, debe ser mayor a $0.");
            }
        } while (montoApertura <= 0);

        System.out.println("Caja abierta con $" + montoApertura);

        // Variables para el reporte de cierre
        int pedidosProcesados = 0;
        double totalRecaudado = 0;
        double mayorValor = 0;
        int pedidoMayorValor = 0;

        // Tarea 1 - Procesamiento de pedidos
        System.out.println();
        System.out.println("===== PEDIDOS DEL TURNO =====");
        for (int i = 0; i < pedidoProducto.length; i++) {
            int producto = pedidoProducto[i];
            int cantidad = pedidoCantidad[i];
            int numeroPedido = i + 1;

            System.out.println("Pedido #" + numeroPedido);
            System.out.println("Producto: " + nombres[producto]);
            System.out.println("Cantidad: " + cantidad);

            String descripcionCategoria;
            switch (categorias[producto]) {
                case 'B':
                    descripcionCategoria = "Bebida caliente";
                    break;
                case 'F':
                    descripcionCategoria = "Bebida fría";
                    break;
                case 'C':
                    descripcionCategoria = "Comida";
                    break;
                case 'P':
                    descripcionCategoria = "Postre";
                    break;
                default:
                    descripcionCategoria = "Categoría desconocida";
            }
            System.out.println("Categoría: " + descripcionCategoria);

            // Tarea 3 - Validación de inventario del Brownie (índice 4)
            if (producto == 4) {
                if (cantidad > inventarioBrownie) {
                    System.out.println("Producto agotado: no hay suficientes Brownies. Este pedido no se cobra.");
                    System.out.println("-----------------------------");
                    continue;
                }
                inventarioBrownie = inventarioBrownie - cantidad;
                System.out.println("Brownies que quedan en inventario: " + inventarioBrownie);
            }

            double subtotal = precios[producto] * cantidad;
            System.out.println("Subtotal: $" + subtotal);

            // Tarea 2 - Descuento por pedido
            double valorFinal = subtotal;
            if (subtotal > 12000) {
                valorFinal = subtotal - (subtotal * 0.10);
                System.out.println("Descuento del 10%: SÍ aplica");
            } else {
                System.out.println("Descuento del 10%: NO aplica");
            }
            System.out.println("Valor final: $" + valorFinal);
            System.out.println("-----------------------------");

            // Datos para el reporte
            pedidosProcesados++;
            totalRecaudado = totalRecaudado + valorFinal;
            if (valorFinal > mayorValor) {
                mayorValor = valorFinal;
                pedidoMayorValor = numeroPedido;
            }
        }

        // Tarea 5 - Reporte de cierre
        System.out.println();
        System.out.println("===== REPORTE DE CIERRE =====");
        System.out.println("Total de pedidos procesados: " + pedidosProcesados);
        System.out.println("Total recaudado: $" + totalRecaudado);
        System.out.println("Pedido con mayor valor: #" + pedidoMayorValor + " ($" + mayorValor + ")");
    }
}
