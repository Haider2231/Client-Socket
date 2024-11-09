package mundo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LWZ {

    private Map<Integer, String> dictionary;
    private int dictSize;
    private String currentString;

    public LWZ() {
        // Inicializar el diccionario y variables
        dictionary = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dictionary.put(i, String.valueOf((char) i));
        }
        dictSize = 256;
        currentString = "";
    }

    // Método para descomprimir un solo código
    public String decompress(int code) {
        String entry;
        
        if (dictionary.containsKey(code)) {
            entry = dictionary.get(code);
        } else if (code == dictSize) {
            entry = currentString + currentString.charAt(0);
        } else {
            throw new IllegalArgumentException("Código inválido: " + code);
            }

        String result = entry;
        if (!currentString.isEmpty()) {
            dictionary.put(dictSize++, currentString + entry.charAt(0));
        }
        currentString = entry;
        
        return result;
    }
}
