package set.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        // Cria um HashMap
        HashMap<String, Double> hashMap = new HashMap<>();

        // Insere elementos no HashMap
        // Usa put() para inserir entradas
        hashMap.put("John Doe", 3434.34);
        hashMap.put("Tom Smith", 123.22);
        hashMap.put("Jane Baker", 1378.00);
        hashMap.put("Todd Hall", 99.22);
        hashMap.put("Ralph Smith", -19.08);

        // Obtém um conjunto das entradas
        Set<Map.Entry<String, Double>> set = hashMap.entrySet();//Obtém uma visão de conjunto das entradas

        // Exibe o conjunto
        for (Map.Entry<String, Double> mapEntry : set) {
            System.out.print(mapEntry.getKey() + ": ");// Exibe as chaves
            System.out.println(mapEntry.getValue());// Exibe os valores
        }

        System.out.println();

        //Deposita 1000 na conta de John Doe
        double balance = hashMap.get("John Doe");
        hashMap.put("John Doe", balance + 1000);

        System.out.println("John Doe's new Balance: " + hashMap.get("John Doe"));

    }
}
