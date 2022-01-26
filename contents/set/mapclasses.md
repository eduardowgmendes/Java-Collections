# As classes de mapas
Várias classes fornecem implementações das interfaces de mapas. A classe abstrata
AbstractMap implementa grande parte da interface Map. Ela é estendida por várias
classes concretas de mapas. Examinaremos as três a seguir:

| Classe | Descrição |
|--------|-----------|
| `HashMap` | Estende **AbstractMap** para usar uma tabela hash. |
| `TreeMap` | Estende **AbstractMap** para usar uma árvore. |
| `LinkedHashMap` | Estende **HashMap** para permitir iterações por ordem de inserção. |

***Nota**: Outras classes de mapas são **WeakHashMap**, **IdentifyHashMap** e **EnumMap**.
Seu uso é especializado e elas não serão examinadas aqui.*

### A classe HashMap
A classe HashMap estende AbstractMap e implementa a interface Map. Ela usa
uma tabela hash para armazenar o mapa. Isso permite que o tempo de execução de
get( ) e put( ) permaneça constante até mesmo para grandes conjuntos de dados.
HashMap é uma classe genérica que tem esta declaração:
```java 
class HashMap<K, V>
```
Aqui, K especifica o tipo das chaves, e V, o tipo dos valores.
Os construtores a seguir são definidos:
```java
HashMap( )
HashMap(Map<? extends K, ? extends V> map)
HashMap(int initialCapacity)
HashMap(int initialCapacity, float fillRate)
```
O primeiro construtor cria um mapa hash vazio. O segundo inicializa o mapa hash usando os elementos de mapa. O terceiro inicializa a capacidade inicial do mapa hash com `initialCapacity`. O quarto inicializa tanto a capacidade inicial quanto a **taxa de preenchimento (fator de carga)** do mapa hash usando seus argumentos.

O significado de **capacidade** e **taxa de preenchimento** é o mesmo usado na classe `HashSet`, descrita anteriormente. A capacidade inicial padrão é **16**. A taxa de preenchimento padrão é **0,75**.

É bom ressaltar que um mapa hash **não armazena elementos em uma ordem específica**. Além disso, a ordem pode mudar durante o tempo de vida do mapa. Portanto, a ordem em que os elementos são adicionados a um mapa hash não é necessariamente aquela em que serão obtidos se percorrermos uma visão de coleção do mapa.

O programa a seguir ilustra `HashMap`. Ele mapeia nomes para saldos de conta. Observe como uma visão de coleção é obtida e usada:

```java
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

```
