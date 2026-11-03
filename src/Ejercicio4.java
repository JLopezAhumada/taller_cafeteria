// Ejercicio 4 - while
public class Ejercicio4 {
    public static void main(String[] args) {
        int inventario = 50;
        int consumoPorPedido = 3;
        int numeroPedido = 0;

        System.out.println("Inventario inicial de café molido: " + inventario);

        // Se hacen pedidos mientras el inventario no baje de 10
        while (inventario >= 10) {
            numeroPedido++;
            inventario = inventario - consumoPorPedido;
            System.out.println("Pedido " + numeroPedido + " -> inventario restante: " + inventario);
        }

        System.out.println("El inventario bajó de 10 unidades. Hay que reabastecer.");
    }
}
