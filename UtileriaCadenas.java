import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class UtileriaCadenas {

    /**
     * 2. El Filtro Selectivo
     * Elimina las cadenas que comiencen con la letra indicada o que tengan una longitud menor al parámetro recibido.
     */
    public static void filtrarCadenas(ArrayList<String> cadenas, char letraInicial, int longitudMinima) {
        if (cadenas == null) {
            System.out.println("Advertencia: La lista de cadenas proporcionada es nula.");
            return;
        }
        
        // Se evalúan casos extremos (nulos, vacíos) antes de revisar el carácter inicial
        cadenas.removeIf(s -> 
            s == null || 
            s.length() < longitudMinima || 
            (!s.isEmpty() && s.charAt(0) == letraInicial)
        );
    }

    /**
     * 3. Conversor de Mayúsculas
     * Convierte una lista de palabras a mayúsculas usando Stream y map(), 
     * retornando un nuevo ArrayList.
     */
    public static ArrayList<String> convertirAMayusculas(ArrayList<String> cadenas) {
        if (cadenas == null) {
            System.out.println("Advertencia: La lista de cadenas proporcionada es nula.");
            return new ArrayList<>(); // Retornamos lista vacía para evitar NullPointerException en cascada
        }

        return cadenas.stream()
                .filter(s -> s != null) // Filtramos nulos para que .toUpperCase() no falle
                .map(String::toUpperCase)
                // Usamos toCollection para garantizar que el retorno sea específicamente un ArrayList
                .collect(Collectors.toCollection(ArrayList::new)); 
    }

    /**
     * 5. Mapa de Longitudes
     * Crea un HashMap donde la clave es la palabra y el valor su longitud.
     * Se utiliza .distinct() para evitar colisiones de llaves en el colector.
     */
    public static Map<String, Integer> generarMapaLongitudes(ArrayList<String> palabras) {
        if (palabras == null) {
            System.out.println("Advertencia: La lista de palabras es nula.");
            return new HashMap<>();
        }

        return palabras.stream()
                .filter(p -> p != null)
                .distinct() // Garantiza llaves únicas para Collectors.toMap
                .collect(Collectors.toMap(
                    palabra -> palabra,      // Key: la palabra misma
                    String::length           // Value: su longitud
                ));
    }

    /**
     * 7. Contador de Frecuencias
     * Construye un mapa de frecuencias indicando cuántas veces aparece cada palabra.
     * Utiliza el método merge() para una actualización atómica.
     */
    public static Map<String, Integer> contarFrecuencias(ArrayList<String> palabras) {
        Map<String, Integer> frecuencias = new HashMap<>();
        if (palabras == null) {
            System.out.println("Advertencia: La lista de palabras es nula.");
            return frecuencias;
        }

        for (String palabra : palabras) {
            if (palabra != null) {
                // merge(llave, valor_inicial, funcion_remanejadora)
                // Si no existe, pone 1. Si existe, suma 1 al valor actual (v).
                frecuencias.merge(palabra, 1, (v_actual, v_nuevo) -> v_actual + v_nuevo);
            }
        }
        return frecuencias;
    }

    /**
     * 8. Clasificador de Palabras
     * Filtra un mapa de frecuencias y devuelve un ArrayList con las palabras 
     * cuya frecuencia sea igual o superior al umbral dado.
     */
    public static ArrayList<String> filtrarPorFrecuencia(Map<String, Integer> mapaFrecuencias, int umbralMinimo) {
        if (mapaFrecuencias == null) {
            System.out.println("Advertencia: El mapa de frecuencias es nulo.");
            return new ArrayList<>();
        }

        return mapaFrecuencias.entrySet().stream()
                .filter(entry -> entry.getValue() >= umbralMinimo) // Criterio: frecuencia >= N
                .map(Map.Entry::getKey) // Extraemos solo la palabra (llave)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * 9. Deduplicación de Palabras
     * Toma una frase, la divide en palabras limpiando signos de puntuación, 
     * filtra por longitud mínima, convierte a minúsculas y las guarda en un HashSet.
     */
    public static HashSet<String> deduplicarPalabras(String frase, int longitudMinima) {
        if (frase == null || frase.trim().isEmpty()) {
            System.out.println("Advertencia: La frase proporcionada es nula o está vacía.");
            return new HashSet<>();
        }

        // Dividimos usando \\W+ para ignorar puntos, comas y espacios múltiples
        return Arrays.stream(frase.split("\\W+"))
                .filter(palabra -> !palabra.isEmpty()) // Evitar cadenas vacías generadas por el split
                .filter(palabra -> palabra.length() >= longitudMinima)
                .map(String::toLowerCase)
                .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * 10. El Tope de Frecuencias
     * Limita todas las frecuencias de un mapa a un máximo de N utilizando replaceAll().
     */
    public static void aplicarTopeFrecuencias(Map<String, Integer> frecuencias, int topeMaximo) {
        if (frecuencias == null || frecuencias.isEmpty()) {
            System.out.println("Advertencia: El mapa de frecuencias es nulo o está vacío.");
            return;
        }

        // replaceAll itera sobre todas las entradas y reemplaza el valor con el resultado de la lambda.
        // Usamos Math.min para quedarnos con el valor original o el tope (el que sea menor).
        // Se añade un chequeo de nulos por si el mapa contiene algún valor nulo corrupto.
        frecuencias.replaceAll((palabra, valorActual) -> 
            valorActual == null ? null : Math.min(valorActual, topeMaximo)
        );
    }
}