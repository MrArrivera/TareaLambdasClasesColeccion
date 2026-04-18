import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class UtileriaNumeros {
    
    /**
     * 1. El Multiplicador
     * Multiplica cada número de la lista por un factor dado utilizando replaceAll() y una función lambda.
     */
    public static void multiplicarLista(ArrayList<Integer> numeros, int factor) {
        if (numeros == null) {
            System.out.println("Advertencia: La lista de números proporcionada es nula.");
            return;
        }
        
        // Se utiliza un ternario en la lambda para evitar NullPointerException si la lista contiene nulos
        numeros.replaceAll(n -> n == null ? null : n * factor);
    }

    /**
     * 4. Cuadrados Únicos
     * Crea un HashSet con los cuadrados de los números pares únicos de la lista original.
     */
    public static HashSet<Integer> cuadradosUnicosPares(ArrayList<Integer> numeros) {
        if (numeros == null) {
            System.out.println("Advertencia: La lista de números proporcionada es nula.");
            return new HashSet<>(); // Retornamos un HashSet vacío de forma segura
        }

        return numeros.stream()
                .filter(n -> n != null)  // Evitamos nulos
                .filter(n -> n % 2 == 0) // Filtramos solo los números pares
                .map(n -> n * n)         // Elevamos al cuadrado
                // toCollection garantiza que nos devuelva la implementación HashSet exacta solicitada
                .collect(Collectors.toCollection(HashSet::new)); 
    }

    /**
     * 6. Modificador de Inventario
     * Itera sobre un mapa de productos y precios, imprimiendo un catálogo
     * con un descuento del 10%. Maneja valores nulos de forma segura.
     */
    public static void imprimirCatalogoConDescuento(Map<String, Double> inventario) {
        if (inventario == null || inventario.isEmpty()) {
            System.out.println("El inventario está vacío o es nulo.");
            return;
        }

        System.out.println(String.format("%-15s | %-12s | %-12s", "Producto", "Precio Orig.", "Con Desc. (10%)"));
        System.out.println("----------------------------------------------------------");

        // Uso de forEach con Bi-Consumer (llave, valor)
        inventario.forEach((producto, precio) -> {
            String nombreSeguro = (producto != null) ? producto : "Desconocido";
            
            if (precio == null) {
                // Si el precio es nulo, evitamos hacer la operación matemática
                System.out.println(String.format("%-15s | %-12s | %-12s", nombreSeguro, "N/A", "N/A"));
            } else {
                double precioFinal = precio * 0.90;
                System.out.println(String.format("%-15s | $%-11.2f | $%-11.2f", 
                    nombreSeguro, precio, precioFinal));
            }
        });
    }
}