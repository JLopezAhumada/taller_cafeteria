// Ejercicio 5 - do-while
public class Ejercicio5 {
    public static void main(String[] args) {
        // Valores que "ingresa" el cajero, el primero es inválido
        double[] valoresIngresados = {-20000, 0, 150000};
        int intento = 0;
        double montoApertura;

        do {
            montoApertura = valoresIngresados[intento];
            intento++;
            System.out.println("Intento " + intento + ": el cajero ingresa $" + montoApertura);

            if (montoApertura <= 0) {
                System.out.println("Monto inválido, debe ser mayor a $0. Ingréselo de nuevo.");
            }
        } while (montoApertura <= 0);

        System.out.println("Caja abierta con un monto de $" + montoApertura);
    }
}
