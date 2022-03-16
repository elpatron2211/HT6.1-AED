
/**
 * Map Factory
 * Objetivo: Clase encargada de hacer el Factory
 * 
 * @author Walter Cruz 
 * @author Paulo Sanchez
 * @version 1.0 finalizado 17/03/2022
 */
package src.main.java;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
class MapFactory<K,V>{
    public Map<K,V> getMap(String entry){
        if(entry.equals("1")){
            return new HashMap<K,V>();
        }
        else if(entry.equals("2")){
            return new TreeMap<K,V>();
        }
        else if(entry.equals("3")){
            return new LinkedHashMap<K,V>();
        }
        return null;
    }
    
}
