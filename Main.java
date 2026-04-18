import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("    PRUEBAS: UTILERIA NUMEROS");
        System.out.println("=====================================");
        probarMultiplicador();
        probarCuadradosUnicos();

        System.out.println("\n=====================================");
        System.out.println("    PRUEBAS: UTILERIA CADENAS");
        System.out.println("=====================================");
        probarFiltroSelectivo();
        probarConversorMayusculas();

        System.out.println("\n=====================================");
        System.out.println("    PRUEBAS: MAPAS Y DICCIONARIOS");
        System.out.println("=====================================");
        probarMapaLongitudes();
        probarModificadorInventario();

        System.out.println("\n=====================================");
        System.out.println("    PRUEBAS: ANALISIS DE FRECUENCIAS");
        System.out.println("=====================================");
        probarAnalisisFrecuencias();

        System.out.println("\n=====================================");
        System.out.println("    PRUEBAS: OPERACIONES AVANZADAS");
        System.out.println("=====================================");
        probarDeduplicacion();
        probarTopeFrecuencias();
    }

    private static void probarMultiplicador() {
        System.out.println("--- 1. El Multiplicador ---");
        
        // Caso Normal
        ArrayList<Integer> listaNormal = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("[Normal] Antes: " + listaNormal);
        UtileriaNumeros.multiplicarLista(listaNormal, 3);
        System.out.println("[Normal] Después (x3): " + listaNormal);

        // Caso Extremo: Lista Vacía
        ArrayList<Integer> listaVacia = new ArrayList<>();
        System.out.println("\n[Vacía] Antes: " + listaVacia);
        UtileriaNumeros.multiplicarLista(listaVacia, 5);
        System.out.println("[Vacía] Después (x5): " + listaVacia);

        // Caso Extremo: Valores Nulos en la lista
        ArrayList<Integer> listaConNulos = new ArrayList<>(Arrays.asList(10, null, 20));
        System.out.println("\n[Con Nulos] Antes: " + listaConNulos);
        UtileriaNumeros.multiplicarLista(listaConNulos, 2);
        System.out.println("[Con Nulos] Después (x2): " + listaConNulos);
        
        // Caso Extremo: Lista completamente nula
        System.out.println("\n[Lista Nula] Antes: null");
        UtileriaNumeros.multiplicarLista(null, 2);
    }

    private static void probarFiltroSelectivo() {
        System.out.println("--- 2. El Filtro Selectivo ---");
        
        // Caso Normal
        ArrayList<String> listaNormal = new ArrayList<>(Arrays.asList("Manzana", "Pera", "Mango", "Uva", "Melon", "Piñas"));
        System.out.println("[Normal] Antes: " + listaNormal);
        // Filtrar: Elimina si empieza con 'M' o si longitud < 5 ("Uva" y "Pera" se van por longitud, el resto por 'M' menos "Piña")
        UtileriaCadenas.filtrarCadenas(listaNormal, 'M', 5);
        System.out.println("[Normal] Después (Empieza 'M' o len < 5): " + listaNormal); 

        // Caso Extremo: Lista Vacía
        ArrayList<String> listaVacia = new ArrayList<>();
        System.out.println("\n[Vacía] Antes: " + listaVacia);
        UtileriaCadenas.filtrarCadenas(listaVacia, 'A', 3);
        System.out.println("[Vacía] Después: " + listaVacia);

        // Caso Extremo: Valores Nulos y Cadenas Vacías
        ArrayList<String> listaConNulos = new ArrayList<>(Arrays.asList("Hola", null, "", "Adios"));
        System.out.println("\n[Con Nulos/Vacíos] Antes: " + listaConNulos);
        UtileriaCadenas.filtrarCadenas(listaConNulos, 'H', 2);
        System.out.println("[Con Nulos/Vacíos] Después (Empieza 'H' o len < 2): " + listaConNulos); 

        // Caso Extremo: Lista completamente nula
        System.out.println("\n[Lista Nula] Antes: null");
        UtileriaCadenas.filtrarCadenas(null, 'Z', 5);
    }

    private static void probarConversorMayusculas() {
        System.out.println("\n--- 3. Conversor de Mayúsculas ---");
        
        // Caso Normal
        ArrayList<String> listaNormal = new ArrayList<>(Arrays.asList("java", "spring", "linux", "fedora"));
        System.out.println("[Normal] Antes: " + listaNormal);
        ArrayList<String> resultadoNormal = UtileriaCadenas.convertirAMayusculas(listaNormal);
        System.out.println("[Normal] Después: " + resultadoNormal);

        // Caso Extremo: Lista con valores nulos y vacíos
        ArrayList<String> listaConNulos = new ArrayList<>(Arrays.asList("hola", null, "", "mundo"));
        System.out.println("\n[Con Nulos/Vacíos] Antes: " + listaConNulos);
        ArrayList<String> resultadoNulos = UtileriaCadenas.convertirAMayusculas(listaConNulos);
        System.out.println("[Con Nulos/Vacíos] Después: " + resultadoNulos);

        // Caso Extremo: Lista Nula
        System.out.println("\n[Lista Nula] Antes: null");
        ArrayList<String> resultadoNulo = UtileriaCadenas.convertirAMayusculas(null);
        System.out.println("[Lista Nula] Después (Retorna vacía segura): " + resultadoNulo);
    }

    private static void probarCuadradosUnicos() {
        System.out.println("\n--- 4. Cuadrados Únicos ---");
        
        // Caso Normal (Con duplicados, pares e impares)
        ArrayList<Integer> listaNormal = new ArrayList<>(Arrays.asList(2, 2, 3, 4, 4, 5, 6));
        System.out.println("[Normal] Original: " + listaNormal);
        HashSet<Integer> resultadoNormal = UtileriaNumeros.cuadradosUnicosPares(listaNormal);
        // Explicación: Pares únicos son 2, 4, 6. Sus cuadrados: 4, 16, 36.
        System.out.println("[Normal] HashSet de cuadrados pares: " + resultadoNormal);

        // Caso Extremo: Valores nulos
        ArrayList<Integer> listaConNulos = new ArrayList<>(Arrays.asList(8, null, 8, 3, 10));
        System.out.println("\n[Con Nulos] Original: " + listaConNulos);
        HashSet<Integer> resultadoNulos = UtileriaNumeros.cuadradosUnicosPares(listaConNulos);
        System.out.println("[Con Nulos] HashSet resultante: " + resultadoNulos);

        // Caso Extremo: Lista vacía o sin pares
        ArrayList<Integer> listaImpares = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        System.out.println("\n[Solo Impares] Original: " + listaImpares);
        HashSet<Integer> resultadoImpares = UtileriaNumeros.cuadradosUnicosPares(listaImpares);
        System.out.println("[Solo Impares] HashSet resultante: " + resultadoImpares);
    }

    private static void probarMapaLongitudes() {
        System.out.println("\n--- 5. Mapa de Longitudes ---");
        ArrayList<String> palabras = new ArrayList<>(Arrays.asList("Hola", "Mundo", "Java", "Stream", "Hola"));
        System.out.println("[Entrada] Lista (con duplicado 'Hola'): " + palabras);
        
        Map<String, Integer> mapa = UtileriaCadenas.generarMapaLongitudes(palabras);
        System.out.println("[Resultado] Mapa resultante: " + mapa);
    }

    private static void probarModificadorInventario() {
        System.out.println("\n--- 6. Modificador de Inventario ---");
        
        // Caso Normal
        Map<String, Double> inventario = new HashMap<>();
        inventario.put("Laptop", 15000.0);
        inventario.put("Mouse", 500.0);
        inventario.put("Teclado", 1200.0);
        inventario.put("Monitor", 3500.0);

        System.out.println("[Normal] Inventario Original:");
        UtileriaNumeros.imprimirCatalogoConDescuento(inventario);

        // Caso Extremo: Mapa con llaves (productos) o valores (precios) NULOS
        Map<String, Double> inventarioConNulos = new HashMap<>();
        inventarioConNulos.put("Cargador", null); // Precio nulo (causaría error matemático)
        inventarioConNulos.put(null, 800.0);      // Producto nulo
        System.out.println("\n[Con Nulos] Inventario con datos faltantes:");
        UtileriaNumeros.imprimirCatalogoConDescuento(inventarioConNulos);

        // Caso Extremo: Mapa vacío
        System.out.println("\n[Caso Vacío]:");
        UtileriaNumeros.imprimirCatalogoConDescuento(new HashMap<>());

        // Caso Extremo: Mapa nulo
        System.out.println("\n[Caso Nulo]:");
        UtileriaNumeros.imprimirCatalogoConDescuento(null);
    }

    private static void probarAnalisisFrecuencias() {
        System.out.println("--- 7 y 8. Contador y Clasificador ---");
        
        // Caso Normal
        ArrayList<String> palabras = new ArrayList<>(Arrays.asList("java", "fedora", "java", "linux", "java", "linux"));
        System.out.println("[Normal] Lista original: " + palabras);
        
        Map<String, Integer> freqs = UtileriaCadenas.contarFrecuencias(palabras);
        System.out.println("[7. Resultado] Mapa de frecuencias: " + freqs);

        ArrayList<String> filtradas = UtileriaCadenas.filtrarPorFrecuencia(freqs, 2);
        System.out.println("[8. Resultado] Palabras con frecuencia >= 2: " + filtradas);

        // Caso Extremo: Lista con Nulos
        ArrayList<String> conNulos = new ArrayList<>(Arrays.asList("test", null, "test", null, "solo"));
        System.out.println("\n[Con Nulos] Lista original: " + conNulos);
        Map<String, Integer> freqsNulos = UtileriaCadenas.contarFrecuencias(conNulos);
        System.out.println("[7. Resultado] Mapa (ignorando nulos): " + freqsNulos);

        // Caso Extremo: Lista Vacía
        System.out.println("\n[Lista Vacía] Antes: []");
        Map<String, Integer> freqsVacia = UtileriaCadenas.contarFrecuencias(new ArrayList<>());
        System.out.println("[7. Resultado] Mapa resultante: " + freqsVacia);
        
        // Caso Extremo: Mapa nulo en el clasificador
        System.out.println("\n[Mapa Nulo en Filtro] Antes: null");
        ArrayList<String> filtradaNula = UtileriaCadenas.filtrarPorFrecuencia(null, 5);
        System.out.println("[8. Resultado] Lista resultante: " + filtradaNula);
    }

    private static void probarDeduplicacion() {
        System.out.println("--- 9. Deduplicación de Palabras ---");
        
        // Caso Normal (Con mayúsculas, minúsculas, repetidas y puntuación)
        String frase = "Hola mundo. Hola a todos en el mundo de Java, java es genial!";
        System.out.println("[Normal] Frase original: \"" + frase + "\"");
        // Filtramos palabras de 4 o más letras
        HashSet<String> resultado = UtileriaCadenas.deduplicarPalabras(frase, 4);
        System.out.println("[Normal] HashSet (>= 4 letras, sin repetidas): " + resultado);

        // Caso Extremo: String Nulo
        System.out.println("\n[String Nulo] Antes: null");
        HashSet<String> resultadoNulo = UtileriaCadenas.deduplicarPalabras(null, 3);
        System.out.println("[String Nulo] Resultado: " + resultadoNulo);

        // Caso Extremo: String vacío o con puros espacios
        System.out.println("\n[String Vacío] Antes: \"   \"");
        HashSet<String> resultadoVacio = UtileriaCadenas.deduplicarPalabras("   ", 2);
        System.out.println("[String Vacío] Resultado: " + resultadoVacio);
    }

    private static void probarTopeFrecuencias() {
        System.out.println("\n--- 10. El Tope de Frecuencias ---");
        
        // Caso Normal
        Map<String, Integer> frecuencias = new HashMap<>();
        frecuencias.put("el", 15);
        frecuencias.put("java", 8);
        frecuencias.put("codigo", 2);
        
        System.out.println("[Normal] Mapa antes del tope: " + frecuencias);
        // Aplicamos un tope máximo de 5
        UtileriaCadenas.aplicarTopeFrecuencias(frecuencias, 5);
        System.out.println("[Normal] Mapa después (Tope = 5): " + frecuencias);

        // Caso Extremo: Mapa con valores nulos
        Map<String, Integer> frecConNulos = new HashMap<>();
        frecConNulos.put("error", null);
        frecConNulos.put("test", 10);
        System.out.println("\n[Con Nulos] Mapa antes: " + frecConNulos);
        UtileriaCadenas.aplicarTopeFrecuencias(frecConNulos, 3);
        System.out.println("[Con Nulos] Mapa después (Tope = 3, ignora nulls): " + frecConNulos);

        // Caso Extremo: Mapa vacío
        Map<String, Integer> mapVacio = new HashMap<>();
        System.out.println("\n[Mapa Vacío] Antes: " + mapVacio);
        UtileriaCadenas.aplicarTopeFrecuencias(mapVacio, 10);
        System.out.println("[Mapa Vacío] Después: " + mapVacio);
    }
}