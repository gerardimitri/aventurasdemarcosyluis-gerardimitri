# AventurasdeMarcosyLuis

Paquete de logica de juego para las Aventuras de Marco Y Luis

## Instalación

Descargar Repositorio e ingresar a aventurasdemarcosyluis-gerardimitri/build/classes/java/main/com/example/aventurasdemarcoyluis/ donde se encontraran los distintos paquetes con las clases utilizadas


## Uso

Utilizamos el paquete de Player para referirnos a los jugadores, donde los principales serán Marco Y Luis los cuales son subclases de esta.
Tanto Marco como Luis cuentan con sus respectivos getter y setter de sus estadisticas.
Para acceder a ellos utilizamos las funciones de clase tal que:

```java
	private Marco aMarco = new Marco(ATK:17, DEF:16, HP:100, FP:15, LVL:1);
	aMarco.setdef(15);
	aMarco.getdef;
```

Lo cual nos deja:
```
	15
```

Así mismo, además de acceder a los atributos los jugadores cuentan con armamento, donde para agregar un item este debe ser de algún tipo, los cuales están divididos en una clase distinta para cada uno.
Podemos Agregar items como usarlos con las funciones addItem y aseItem
Por ejemplo:

```java
	ItemRedMushroom aRedMushroom = new ItemRedMushroom;
	aMarco.addItem(Item: aRedMushroom, quantity: 2);
	aMarco.setHP(85);
	aMarco.useItem(Item: aRedMushroom);
	aMarco.getHP():
```
Donde getHP() nos retorna su HP actual, la cual al bajarla a 85 y curarle un 10% de la vida maxima (aMarco.getmaxHP()==100) nos deja:
```
	95
```
Luego, Adicionalmente podemos atacar a un enemigo con la función attackEnemy(Enemies anEnemy)
En cuanto a los enemigos, estos también cuentas con sus propios atributos donde la excepción es el armamento, ya que estos no cuentan con uno y en vez de eso, estos tienen un tipo.
Para acceder a los elementos de los enemigos se utilizan los mismos metodos que para los Jugadores en tanto sus getter como setter.

Se actualizan los metodos de Ataque, además las funciones y los test se mantienen, sin embargo utilizamos un pozo común para los items.

## Controlador

Para el caso del controlador, realizamos una clase "Battle" con metodos determinados para hacer de controlador, la cual en el constructor iniciliaza y crea tanto a los personajes como a los enemigos acorde al número deseado.

En cuanto a los turnos, dejamos los turnos expresados como ints con el formato de: Primero los personajes principales, luego los enemigos. Para instanciar a estos, utilizamos una clase "Entity" que se refiera a cualquier entidad, ya sea un enemigo o un personaje y de este modo poder retornar ambos al consultar el turno.

Se implementan las funciones checkWin() y notOver() para verificar si es que el personaje ganó, o bien terminó el duelo respectivamente.

## Vista

Se implementó una vista para el controlador Battle, la cual utiliza los metodos SelectAction() para pedirle inputs al usuario, así mismo utiliza SelectItem() y SelectAttack() para las interacciones de Items y Ataques respectivamente.

Se implementan excepciones en la Vista, para cuando la opcion solicitada no existe, así mismo para cuando un item no está en el Baúl.

Las anteriores funciones se comunican con el controlador Battle para interactuar con el modelo.

Para el testeo, se utiliza NullOutputStream para no imprimir.

## License
[MIT](https://choosealicense.com/licenses/mit/)
