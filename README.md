# HQL

**HQL** é a linguaxe de consultas de Hibernate para obter obxectos da base de datos. Características:

- As consultas realízanse sobre os **Obxectos JAVA**, **non** sobre as **táboas** SQL. E dicir, as entidades que persisten en Hibernate.
- Os tipos de datos son os de JAVA.
- As consultas son independentes da linguaxe SQL específica da base de datos.
- Consultas independentes do modelo de táboas da base de datos.
- É posible tratar con coleccións JAVA.
- É posible navegar entre os distintos obxectos da propia consulta.

## Primer exemplo

Imos imprimir os datos de tódolos equipos:

```java
    //Collemos a sesión de Hibernate
    Session session = HibernateUtil.getSessionFactory().openSession();
        
    //Facemos unha consulta en HQL
    Query hql1 = session.createQuery("SELECT e FROM Equipo e");
    List<Equipo> equipos1 = hql1.list();
    for(Equipo eq:equipos1){
        System.out.println(eq.toString());
    }
```

Vamos fixarnos na consulta:

```sql
SELECT e FROM Equipo e;
```

- **Equipo** non é a táboa da base de datos Equipo. Senón que é a **clase Java Equipo**.
- É necesario facer un alias da clase Jave. Neste caso o alias é "e". Senón se utiliza un alias obtemos un erro.
- Para coller tódolos atributos non se utiliza o símbolo "\*" senón que se utiliza o alias.

## Consideracións 

- As palabras clave non son sensibles a maiusculas e minúsculas.
- En cambio, as clases AJVA si que son sensibles.

## Filtrado

Para filtrar datos tamén se utiliza a clausula **WHERE**. A forma de usala é moi parecida a SQL.

Exemplos:

```sql
SELECT e FROM Equipo e WHERE nombre='San Clemente';

SELECT e FROM Equipo e WHERE nombre='San Clemente' AND numeroSocios>10;

```
## Operadores de comparación

- =
- >
- >=
- <=
- <=
- <> ou !=
- between: para rangos.

## Operadores Lóxicos

- AND
- OR
- NOT

## Operadores aritméticos

- +
- \-
- \*
- /

## Funcións de agragación

- AVG()
- SUM()
- MIN()
- MAX()
- COUNT()

##Ordenación

Funciona moi parecido a sql.

```sql
SELECT e FROM Equipo e ORDER BY nombre ASC;

SELECT e FROM Equipo e ORDER BY nombre DESC;

```

## Agrupacións

Tamén existen as palabrar clave **GROUP BY** e **HAVING** que funcionan de xeito similar a SQL.

## Subconsultas

Funciona de xeito similar a SQL.

## Paso de parámetros as consultas

```java
    //Facemos unha consulta en HQL
    Query hql2 = session.createQuery("SELECT e FROM Equipo e WHERE e.nome=:n AND e.numeroSocios>:ns");
    hql2.setParameter("n", "San Clemente");
    hql2.setParameter("ns", 100);
    List<Equipo> equipos2 = hql2.list();
    for(Equipo eq:equipos2){
        System.out.println(eq.toString());
    } 
```





