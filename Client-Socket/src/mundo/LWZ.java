package mundo;

import java.util.HashMap;
import java.util.Map;

/**
 * La clase LWZ implementa un descompresor básico utilizando el algoritmo LZW.
 * Mantiene un diccionario de códigos y cadenas para descomprimir datos recibidos.
 */
public class LWZ {

    private Map<Integer, String> dictionary;
    private int dictSize;
    private String currentString;

    /**
     * Constructor de LWZ.
     * Inicializa el diccionario con los primeros 256 códigos ASCII y establece el tamaño inicial del diccionario.
     */
    public LWZ() {
        dictionary = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dictionary.put(i, String.valueOf((char) i));
        }
        dictSize = 256;
        currentString = "";
    }

    /**
     * Descomprime un código dado en su representación de texto usando el diccionario.
     * Si el código es nuevo, se añade una nueva entrada al diccionario.
     * 
     * @param code El código comprimido que se debe descomprimir.
     * @return La cadena de texto descomprimida.
     * @throws IllegalArgumentException Si el código no es válido o está fuera de los límites del diccionario.
     */
    public String decompress(int code) {
        String entry;

        // Verificar si el código ya está en el diccionario
        if (dictionary.containsKey(code)) {
            entry = dictionary.get(code);
        } 
        // Caso especial para códigos nuevos, genera una entrada combinando el carácter inicial de la cadena actual
        else if (code == dictSize) {
            entry = currentString + currentString.charAt(0);
        } 
        // Código inválido, arroja excepción
        else {
            throw new IllegalArgumentException("Código inválido: " + code);
        }

        // Agregar la nueva entrada al diccionario si la cadena actual no está vacía
        String result = entry;
        if (!currentString.isEmpty()) {
            dictionary.put(dictSize++, currentString + entry.charAt(0));
        }
        
        // Actualizar la cadena actual
        currentString = entry;

        return result;
    }
}
