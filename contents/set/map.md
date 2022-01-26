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

