// Ejercicio 3 - switch
public class Ejercicio3 {
    public static void main(String[] args) {
        char categoria = 'F';

        switch (categoria) {
            case 'B':
                System.out.println("Categoría: Bebida caliente");
                System.out.println("IVA: 0%");
                break;
            case 'F':
                System.out.println("Categoría: Bebida fría");
                System.out.println("IVA: 5%");
                break;
            case 'C':
                System.out.println("Categoría: Comida");
                System.out.println("IVA: 8%");
                break;
            case 'P':
                System.out.println("Categoría: Postre");
                System.out.println("IVA: 8%");
                break;
            default:
                System.out.println("Código de categoría no reconocido: " + categoria);
        }
    }
}
