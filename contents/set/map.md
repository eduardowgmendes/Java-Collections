# Trabalahando com Mapas

No que diz respeito ao Collections Framework, um *mapa* armazena associações entre chaves e valores, ou *pares chave/valor*. Dada uma chave, você pode encontrar seu valor. Há um aspecto dos mapas que é importante mencionar desde o início: eles não implementam **Iterable**. Ou seja, você *não* pode percorrer um mapa usando um laço **for** de estilo for-each. Além disso, não pode obter um iterador para um mapa. No entanto, como veremos em breve, pode obter a visão de coleção do mapa, e essa sim permite o uso do laço for ou de um iterador.

### As interfaces de mapas

Já que as interfaces de mapas definem o caráter e a natureza do mapa, esta discussão sobre mapas começará com elas. As interfaces de **java.util** mostradas a seguir dão suporte a mapas:

| Interface | Descrição | 
|-----------|-----------|
| `Map` | Mapeia chaves exclusivas para valores. |
| `Map.Entry` | Encapsula um elemento (um par chave/valor) em um mapa. |
| `NavigableMap` | Estende **SortedMap** para tratar a recuperação de entradas com base em quanto uma chave está próxima de outra. | 
| `SortedMap` | Estende **Map** de tal modo que as chaves são mantidas em ordem crescente. | 

### A interface Map

A interface **Map** mapeia chaves exclusivas para valores. Uma chave é um objeto que usamos para recuperar um valor. Dada uma chave e um valor, podemos armazenar o valor em um **Map**. Após o valor ser armazenado, podemos recuperá-lo usando sua chave. **Map** é genérica e declarada assim: 

```java
interface Map<K, V>
```
Aqui, **K** especifica o tipo das chaves, e **V**, o tipo dos valores. Os métodos declarados por Map estão resumidos na tabela à seguir: 

| Método | Descrição |
|--------|-----------|
| `void clear()` | Esvazia o mapa chamador excluindo todos os pares chave/valor. |
| `boolean containsKey(Object key)` | Retorna **true** se o mapa chamador tiver *k* como chave. Caso contrário, retorna **false** | 
| `boolean containsValue(Object value)` | Retorna **true** se o mapa chamador tiver *v* como valor. Caso contrário, retorna **false** | 
| `Set<Map.Entry<K, V>> entrySet() ` | Retorna um **Set** contendo todas as entradas do mapa chamador como objetos do tipo **Map.Entry**. A coleção resultante é uma visão do mapa chamador. | 
| `boolean equals(Object object)` | Retorna **true** se obj for um Map e tiver as mesmas entradas do Map chamador. Caso contrário, retorna **false**. |
| `V get(Object key)` | Retorna o valor associado à chave k no mapa chamador. Retorna **null** se a chave não for encontrada. |
| `int hashCode()` | Retorna o código hash do mapa chamador. |
| `boolean isEmpty()` | Retorna **true** se o mapa chamador estiver vazio. Caso contrário, retorna **false**. |
| `Set<K> keySet()` | Retorna um Set contendo todas as chaves do mapa chamador. A coleção resultante é uma visão do mapa chamador. |
| `V put(K k, V v)` | Insere uma entrada no mapa chamador, sobrepondo qualquer valor anterior associado à chave. A chave e o valor são k e v, respectivamente. Retorna **null** se a chave não existir. Caso contrário, o valor anterior é retornado. |
| `void putAll(Map< ? extends K, ? extends V> map)` | Insere todas as entradas de *map* no mapa chamador. |
| `V remove(Object k)` | Remove a entrada cuja chave é k no mapa chamador. O valor do elemento removido é retornado. |
| `int size( )` | Retorna o número de entradas do mapa chamador. | 
| `Collection<V> values( )` | Retorna uma coleção contendo todos os valores do mapa. A coleção resultante é uma visão do mapa chamador. |

Duas operações básicas são os principais elementos de **Map**: `get( )` e `put( )`. Para inserir um valor em um mapa, use `put( )`, especificando a chave e o valor. Para obter um valor, chame `get( )`, passando a chave como argumento. O valor será retornado. Esses dois métodos atendem aos aspectos básicos da natureza dos mapas: armazenar um par chave/valor e retornar o valor quando dada a chave.

Como mencionado anteriormente, embora os mapas façam parte do Collections Framework, eles não implementam a interface **Collection**. No entanto, você pode obter a visão de coleção do mapa. Para fazê-lo, pode usar o método `entrySet( )`. Ele retorna um objeto Set contendo os elementos do mapa. Para obter a visão de coleção das chaves, use `keySet( )`, e para obter a visão de coleção dos valores, use `values( )`.

Todas as três visões de coleção referenciam os elementos do mapa original. Se um for alterado, o outro é afetado. Contudo, você não pode adicionar uma entrada ao mapa por intermédio da visão. As visões de coleção são o meio pelo qual os mapas são integrados ao corpo maior do Collections Framework.

Para concluir, observe os métodos `containsKey( )` e `containsValue( )`. Eles permitem a procura de uma chave ou de um valor específico, respectivamente, em um mapa.

### A interface SortedMap
A interface **SortedMap** estende **Map**. Ela armazena entradas em ordem crescente
com base nas chaves. **SortedMap** é genérica e declarada assim:

```java
interface SortedMap<K, V>
```

Aqui, K especifica o tipo das chaves, e V, o tipo dos valores. Os métodos adicionados
por SortedMap estão resumidos na tabela à seguir: 

| Método | Descrição |
|--------|-----------|
|`Comparator<? super K> comparator( )`| Retorna o comparador do mapa classificado chamador. Se nenhum comparador estiver sendo usado, **null** é retornado. |
|`K firstKey( )` | Retorna a chave do menor valor. Já que o mapa é classificado, ela será a primeira chave do mapa chamador. Se chamado em um mapa vazio, uma `NoSuchElementException` será lançada. |
|`SortedMap<K, V> headMap(K end) `| Retorna um **SortedMap** contendo os elementos do mapa chamador com chaves menores do que `end`. O mapa resultante é uma visão do mapa chamador.|
|`K lastKey( )`|Retorna a chave do maior valor. Já que o mapa é classificado, ela será a última chave do mapa chamador. Se chamado em um mapa vazio, uma `NoSuchElementException` será lançada.|
|`SortedMap<K, V> subMap(K start, K end)`| Retorna um **SortedMap** contendo os elementos do mapa chamador que estejam entre `start` e `end`. O mapa resultante é uma visão do mapa chamador.|
|`SortedMap<K, V> tailMap(K start)`|Retorna um **SortedMap** contendo os elementos do mapa chamador maiores ou iguais a início. O mapa resultante é uma visão do mapa chamador.|

Observe que **SortedMap** fornece métodos que permitem o trabalho com *submapas* (em outras palavras, subconjuntos de um mapa). Para obter um submapa, use `headMap( )`, `tailMap( )` ou `subMap( )`. Já que o mapa é classificado, esses métodos permitem a especificação do intervalo de entradas a ser obtido com base nos valores das chaves passadas. Cuidado, porque os submapas retornados são “visões” e estão sujeitos a várias restrições.

Observe também que você pode obter a primeira chave do mapa chamando `firstKey( )`. Para obter a última chave, chame `lastKey( )`. Já que o mapa é classificado, estamos nos referindo, respectivamente, à menor e à maior chave do mapa.

### A interface NavigableMap
A interface **NavigableMap** estende **SortedMap**. Ela declara o comportamento de um mapa que dá suporte à recuperação de uma entrada com base em quanto uma chave está próxima de outra. Em outras palavras, um **NavigableMap** nos permite encontrar uma entrada com base em ocorrências próximas. **NavigableMap** é uma interface genérica que tem esta declaração:

```java
interface NavigableMap<K, V>
```
Aqui, **K** especifica o tipo das chaves, e **V**, o tipo dos valores associados a elas.
Além dos métodos herdados de **SortedMap**, **NavigableMap** adiciona os resumidos na tabela à seguir:

| Método | Descrição |
|--------|-----------|
| `Map.Entry<K,V> ceilingEntry(K object)` | Procura no mapa a menor chave **k** de modo que `k >= object`. Se a chave for encontrada, sua entrada será retornada. Caso contrário, **null** será retornado.
|`K ceilingKey(K object)`| Procura no mapa a menor chave **k** de modo que `k >= object`. Se a chave for encontrada, ela será retornada. Caso contrário, **null** será retornado.|
|`NavigableSet<K> descendingKeySet( )`| Retorna um **NavigableSet** contendo todas as chaves do mapa chamador em ordem inversa. A coleção resultante é uma visão do mapa chamador. |
|`NavigableMap<K,V> descendingMap( )`| Retorna um **NavigableMap** contendo as entradas do mapa chamador em ordem inversa. A coleção resultante é uma visão do mapa chamador. |
|`Map.Entry<K,V> firstEntry( )`| Retorna a primeira entrada. Já que o mapa é classificado, ela será a entrada do menor valor. | 
|`Map.Entry<K,V> floorEntry(K object)`| Procura no mapa a maior chave **k** de modo que `k <= object`. Se a chave for encontrada, sua entrada será retornada. Caso contrário, **null** será retornado. |
|`K floorKey(K object)`| Procura no mapa a maior chave **k** de modo que `k <= object`. Se a chave for encontrada, ela será retornada. Caso contrário, **null** será retornado. | 
|`NavigableMap<K,V> headMap(K superiorThreshold, boolean includes)`| Retorna um **NavigableMap** contendo os elementos do mapa chamador com chaves menores que `superiorThreshold`. Se `includes` for **true**, um elemento igual a `superiorThreshold` será incluído. O mapa resultante é uma visão do mapa chamador.|
|`Map.Entry<K,V> higherEntry(K object)`| Procura no mapa a menor chave **k** de modo que `k > object`. Se a chave for encontrada, sua entrada será retornada. Caso contrário, **null** será retornado.
|`K higherKey(K object)`| Procura no conjunto a menor chave **k** de modo que `k > object`. Se a chave for encontrada, ela será retornada. Caso contrário, **null** será retornado.|
|`Map.Entry<K,V> lastEntry( )`| Retorna a última entrada. Já que o mapa é classificado, ela será a entrada do maior valor.|
|`Map.Entry<K,V> lowerEntry(K object)`|Procura no conjunto a maior chave **k** de modo que `k < object`. Se a chave for encontrada, sua entrada será retornada. Caso contrário, **null** será retornado.|
|`K lowerKey(K object)`|Procura no conjunto a maior chave **k** de modo que `k < object`. Se a chave for encontrada, ela será retornada. Caso contrário, **null** será retornado.|
|`NavigableSet<K> navigableKeySet( )`|Retorna um **NavigableSet** contendo todas as chaves do mapa chamador. O conjunto resultante é uma visão do mapa chamador.|

Preste atenção nos métodos `ceilingX` e `floorX`. Eles procuram no mapa uma chave que esteja próxima de outra. Por exemplo, os métodos `ceilingEntry( )` e `floorEntry( )` encontram uma entrada cuja chave esteja próxima ou seja igual a outra chave. Observe também os métodos `higherX` e `lowerX`. Eles procuram no mapa uma chave que esteja próxima de outra, mas que não seja igual a ela. Você também pode obter vários submapas baseados em ocorrências próximas.





