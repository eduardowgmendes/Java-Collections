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
