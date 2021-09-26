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

Nota:
Algunos test tienen 85% debido al ataque, sin el ataque tienen coverage del 100%

## License
[MIT](https://choosealicense.com/licenses/mit/)