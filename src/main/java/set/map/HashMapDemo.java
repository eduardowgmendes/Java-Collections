package set.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, Double> hashMap = new HashMap<>();

        hashMap.put("John Doe", 3434.34);
        hashMap.put("Tom Smith", 123.22);
        hashMap.put("Jane Baker", 1378.00);
        hashMap.put("Todd Hall", 99.22);
        hashMap.put("Ralph Smith", -19.08);

        Set<Map.Entry<String, Double>> set = hashMap.entrySet();

        for (Map.Entry<String, Double> mapEntry : set) {
            System.out.print(mapEntry.getKey() + ": ");
            System.out.println(mapEntry.getValue());
        }

        System.out.println();

        double balance = hashMap.get("John Doe");
        hashMap.put("John Doe", balance + 1000);

        System.out.println("John Doe's new Balance: " + hashMap.get("John Doe"));

    }
}
