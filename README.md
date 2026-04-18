# Tarea de Lambdas y Clases de Colección
# ANDRES RAMIRO RIVERA

## Descripción del Proyecto
Este repositorio contiene una biblioteca de utilidades en Java orientada a la manipulación estructurada de listas (ArrayList). El código está dividido en el procesamiento numérico y el procesamiento de cadenas de texto utilizando características funcionales de Java como expresiones Lambda, `replaceAll()` y `removeIf()`. Se incluyen pruebas rigurosas para casos normales y extremos (edge cases).

## Lista de Métodos (10 en total)

### UtileriaNumeros
1\. **El Multiplicador:** Utiliza `replaceAll()` y una expresión lambda para multiplicar todos los elementos numéricos de un `ArrayList<Integer>` por un factor específico.
4\. **Cuadrados Únicos:** Toma un `ArrayList<Integer>` que puede contener duplicados. Utiliza `stream()`, `filter()` para quedarse únicamente con los números pares válidos, y `map()` para elevarlos al cuadrado. Finalmente, usa `Collectors.toCollection(HashSet::new)` para retornar un conjunto, asegurando que no existan resultados duplicados.
6\. **Modificador de Inventario:** Recibe un `HashMap<String, Double>`. Implementa el método `.forEach()` con una expresión lambda de tipo Bi-Consumer para procesar pares clave-valor y generar una salida formateada con cálculos aritméticos (descuento) en tiempo de ejecución.


### UtileriaCadenas
2\. **El Filtro Selectivo:** Utiliza `removeIf()` para iterar sobre un `ArrayList<String>` y eliminar aquellas cadenas que comiencen con una letra específica o que no alcancen una longitud mínima.
3\. **Conversor de Mayúsculas:** Recibe un `ArrayList<String>`, filtra los valores nulos para evitar errores, y utiliza la API de Streams con el método `map()` para transformar todas las cadenas a mayúsculas, recolectando el resultado en una nueva lista.
5\. **Mapa de Longitudes:** Recibe un `ArrayList<String>` y lo transforma en un `HashMap<String, Integer>`. Utiliza `Collectors.toMap` donde la palabra actúa como llave y su `.length()` como valor. Incluye un filtrado de duplicados para evitar errores de colisión.
7\. **Contador de Frecuencias:** Procesa un `ArrayList<String>` y genera un `HashMap<String, Integer>`. Utiliza el método `.merge()` de la interfaz Map junto con una lambda para incrementar contadores de forma eficiente, evitando verificaciones manuales de existencia de llaves.
8\. **Clasificador de Palabras:** Recibe un mapa de frecuencias y un umbral entero. Emplea `entrySet().stream()` para filtrar las entradas basándose en el valor (frecuencia) y recolecta las llaves resultantes en un nuevo `ArrayList`.
9\. **Deduplicación de Palabras:** Recibe una cadena de texto (frase), la divide en un arreglo de palabras utilizando una expresión regular para ignorar signos de puntuación, y usa un Stream para filtrar por longitud mínima, homogeneizar a minúsculas y recolectar el resultado en un `HashSet`. Esto asegura que el resultado contenga únicamente palabras únicas válidas.
10\. **El Tope de Frecuencias:** Recibe un `HashMap<String, Integer>` que representa conteos o frecuencias. Implementa el método `.replaceAll()` y la función `Math.min()` dentro de una expresión lambda para iterar sobre todas las entradas del mapa y limitar de forma in-place cualquier frecuencia que exceda un umbral máximo definido por el usuario.

## Ejemplos de Salida

A continuación se demuestra el comportamiento estándar de cada método con datos representativos.

### UtileriaNumeros

**1. El Multiplicador**
* **Entrada:** `[1, 2, 3, 4, 5]` | Factor: `3`
* **Salida:** `[3, 6, 9, 12, 15]`

**4. Cuadrados Únicos**
* **Entrada:** `[2, 2, 3, 4, 4, 5, 6]` *(Contiene impares y pares duplicados)*
* **Salida:** `[16, 4, 36]` *(HashSet con los cuadrados solo de los pares)*

**6. Modificador de Inventario**
* **Entrada:** `{"Laptop"=15000.0, "Mouse"=500.0, "Teclado"=1200.0}`
* **Salida (Consola):**
    ```text
    Producto        | Precio Orig. | Con Desc. (10%)
    ----------------------------------------------------------
    Laptop          | $15000.00    | $13500.00    
    Teclado         | $1200.00     | $1080.00     
    Mouse           | $500.00      | $450.00      
    ```

---

### UtileriaCadenas

**2. El Filtro Selectivo**
* **Entrada:** `["Manzana", "Pera", "Mango", "Uva", "Melon", "Piña"]` | Letra: `'M'` | Longitud Min: `5`
* **Salida:** `["Piña"]` *(Se eliminan las que empiezan con M y las de menos de 5 letras)*

**3. Conversor de Mayúsculas**
* **Entrada:** `["java", "spring", "linux", "fedora"]`
* **Salida:** `["JAVA", "SPRING", "LINUX", "FEDORA"]`

**5. Mapa de Longitudes**
* **Entrada:** `["Hola", "Mundo", "Java", "Stream", "Hola"]`
* **Salida:** `{Mundo=5, Java=4, Stream=6, Hola=4}`

**7. Contador de Frecuencias**
* **Entrada:** `["java", "fedora", "java", "linux", "java", "linux"]`
* **Salida:** `{fedora=1, java=3, linux=2}`

**8. Clasificador de Palabras**
* **Entrada:** `{fedora=1, java=3, linux=2}` | Umbral: `2`
* **Salida:** `["java", "linux"]`

**9. Deduplicación de Palabras**
* **Entrada:** `"Hola mundo. Hola a todos en el mundo de Java, java es genial!"` | Longitud Min: `4`
* **Salida:** `[mundo, hola, java, todos, genial]` *(Sin puntuación, en minúsculas y sin repetir)*

**10. El Tope de Frecuencias**
* **Entrada:** `{"el"=15, "java"=8, "codigo"=2}` | Tope: `5`
* **Salida:** `{"el"=5, "java"=5, "codigo"=2}`

## Instrucciones de Compilación y Ejecución
Asegúrate de tener instalado el JDK de Java (versión 8 o superior).

1. Clona este repositorio:
   ```bash
   git clone https://github.com/MrArrivera/TareaLambdasClasesColeccion

2. Navega al directorio
   cd lambdas-clasescollection

3. Compilas archivos:
   javac *.java

4. Corres archivos:
   java Main
