# Aplicación Viajes Ococho
Esta aplicación busca solucionar un problema que tiene una terminal de transportes determinada para la gestión de los 
viajes de salida desde la misma. 
## Lineamientos
Así, los requerimientos para dar solución al problema son:
- Aplicación que le permita a la terminal de transporte gestionar los horarios de los viajes
- Tiene que existir la posibilidad de registrar los destinos de los viajes y los buses con sus capacidades
- Se debe llevar un registro de los viajes que se han realizado con los pasajeros que han ido a bordo del bus
- Los pasajeros deben poder inscribirse con sus datos personales, para así gestionar quién usa el sistema de transporte
- Usar polimorfismo con mínimo dos *Interface* y dos *Abstract Class*
- Usar la API Stream para recorrer los *Array*
- Aplicar principios SOLID
- Utilizar patrones de diseño
- Debe ser una API REST usando métodos HTTP necesarios para dar solución a todos los requerimientos
- Usar una estructura de proyecto por capas (Uso de paquetes *controller*, *repository*, *service*)
- El lenguaje de implementación debe ser Java con el framework de Spring Boot

***KISS!*** :kiss:
## Solución
### Idea detrás de la solución
Inicialmente, se realizó un desglose de los posibles objetos que a utilizar, resultando en 3, Personas, Viajes y Buses. 
Luego, se consideró el cómo se estructurarían dichos objetos entre sí, para finalmente pensar qué atributos eran 
necesarios en esta interacción. De este modo, existirían personas adultas y menores, que heredarían de una clase 
abstracta Persona con nombre, apellido, identificación y edad. El adulto tendría un teléfono, y el menor debería estar a
cargo de un adulto durante el viaje. Seguidamente, las personas podrían abordar buses. Estos podrían ser buses grandes o
pequeños, donde la diferencia sería su capacidad, ya que la clase abstracta Bus tendría una placa, pasajeros y 
capacidad, además de la posibilidad de hacer abordar una persona, y al tiempo disminuir su capacidad. Finalmente, un 
viaje debería tener un bus asociado, un destino al que llegar, y un horario de salida que cumplir.

La lógica de interacción entre estos objetos se implementa directamente en los servicios y repositorios, los cuales se
explican más adelante.

Además, se implementan patrones como el mediator, al utilizar los servicios y controladores como mediadores entre el 
usuario y el repositorio de datos. También el patrón decorador, al usar las anotaciones (no solo de Spring Boot, sino 
también las de Lombok) para agregar mayores funcionalidades y atributos a las clases creadas.
### Cómo ejecutar las peticiones
Al clonar el repositorio y abrirlo, es necesario habilitar el procesamiento de anotaciones. Esto con el objetivo de que
todas las anotaciones usadas en el código funcionen al compilarlo.
Se utilizaron siguientes dependencias:
- Spring Boot DevTools
- Lombok
- Spring Web

#### 🚧Persona
Todas las peticiones establecidas para manipular personas están funcionales, siendo 4. 2 Peticiones *POST* para 
registrar adultos y menores, 1 petición *GET* para ver las personas registradas en la base de datos de la terminal, y 
1 petición *PUT* para modificar los datos de un adulto en la base de datos.

Para ejecutar las peticiones, es necesario apuntar a la ruta del servidor que inicializa Tomcat en local, además de
agregar la ruta correspondiente a los clientes. Esto es ```localhost:5000/clientes```. Luego, para las peticiones *POST*
se debe añadir a la ruta el indicador de qué tipo de persona se añadirá a la DB. Para un adulto corresponde a 
```localhost:5000/clientes/adulto```, y para un menor se tiene ```localhost:5000/clientes/menor```. En el cuerpo de 
estas peticiones se debe agregar un objeto en formato *JSON*, así:

```localhost:5000/clientes/adulto```
```JSON
{
"nombre": "Rodolfo",
"apellido": "Aicardi",
"id": "1234567892",
"edad": 35,
"telefono": "1234567892"
}
```
```localhost:5000/clientes/menor```
```JSON
{
  "nombre": "Gianni",
  "apellido": "Aicardi",
  "id": "1234567893",
  "edad": 11,
  "adultoResponsable": {
    "nombre": "Rodolfo",
    "apellido": "Aicardi",
    "id": "1234567892",
    "edad": 35,
    "telefono": "1234567892"
  }
}
```
Luego, la petición de tipo *GET* se realiza a la misma ruta para personas (```localhost:5000/clientes```). Esta 
devolverá una lista con todas las personas registradas previamente.

Finalmente, para la petición de tipo *PUT* (igualmente a la misma ruta ```localhost:5000/clientes```) se debe agregar un
cuerpo con una persona en formato *JSON* que debe tener la misma id que una persona existente, pero los otros campos 
pueden ser modificados, así:
```JSON
{
"nombre": "Juan Esteban",
"apellido": "Cruz",
"id": "1234567890",
"edad": 25,
"telefono": "1234567899"
}
```
Cabe aclarar que las funcionalidades para manipular personas siguen estando en construcción, debido a que no funcionan
óptimamente con personas menores.
#### 🚧Bus
Todas las peticiones establecidas para manipular buses están funcionales, siendo 5. 3 Peticiones *POST* para registrar
buses grandes y pequeños, y para abordar una persona a un bus; 2 peticiones *GET* para ver los buses registrados en la
base de datos de la terminal, y para ver un solo bus dada su placa.

Para ejecutar las peticiones, es necesario apuntar a la ruta del servidor que inicializa Tomcat en local, además de
agregar la ruta correspondiente a los buses. Esto es ```localhost:5000/buses```. Luego, para las peticiones *POST*
se debe añadir a la ruta el indicador de qué tipo de bus se añadirá a la DB, o la placa del bus que abordará la persona.
Para un bus grande corresponde a ```localhost:5000/buses/grande```, para uno pequeño se tiene 
```localhost:5000/buses/pequenno```, y para abordar un bus se debe usar ```localhost:5000/buses/AAA111``` donde las 
letras y números son reemplazados por los correspondientes a la placa del bus a abordar. En el cuerpo de estas
peticiones se debe agregar un objeto en formato *JSON*, así:

```localhost:5000/buses/grande```
```JSON
{
  "placa": "AAA113",
  "pasajeros": [],
  "capacidad": 40
}
```
```localhost:5000/buses/pequenno```
```JSON
{
  "placa": "AAA114",
  "pasajeros": [],
  "capacidad": 10
}
```
```localhost:5000/buses/AAA111```
```JSON
{
  "nombre": "Rodolfo",
  "apellido": "Aicardi",
  "id": "1234567892",
  "edad": 35,
  "telefono": "1234567892"
}
```
Luego, la petición de tipo *GET* que se realiza a la misma ruta para buses (```localhost:5000/buses```) devolverá una
lista con todos los buses registrados previamente. Mientras que la otra petición *GET*, que devolverá un bus en 
específico, deberá ser solicitada a la ruta ```localhost:5000/buses/AAA111``` con su correspondiente placa.

Cabe aclarar que las funcionalidades para manipular buses siguen estando en construcción, debido a que no funcionan
óptimamente con buses pequeños y personas menores.
#### 🚧 Viaje
No todas las peticiones establecidas para manipular viajes están funcionales, siendo 6. 1 Petición *POST* para registrar
un viaje, 2 peticiones *GET* para ver los viajes registrados en la base de datos de la terminal, y para ver un solo 
viaje dado su horario, y 3 peticiones *PUT* para modificar el horario, el bus, y el destino que tendrá el viaje.

Para ejecutar las peticiones, es necesario apuntar a la ruta del servidor que inicializa Tomcat en local, además de
agregar la ruta correspondiente a los viajes. Esto es ```localhost:5000/viajes```. Luego, para la petición *POST*
se debe añadir en el cuerpo un objeto en formato *JSON*, así:

```localhost:5000/viajes```
```JSON
{
  "bus": {
    "placa": "AAA114",
    "pasajeros": [],
    "capacidad": 32
  },
  "destino": "Rionegro",
  "horario": "Ene-3-11:59-A.M"
}
```
Luego, la petición de tipo *GET* que se realiza a la misma ruta para viajes (```localhost:5000/viajes```) devolverá una
lista con todos los viajes registrados previamente. Mientras que la otra petición *GET*, que devolverá un viaje en
específico, deberá ser solicitada a la ruta ```localhost:5000/buses/Ene-2-11:59-A.M``` con su correspondiente horario.

Cabe aclarar que las peticiones tipo *PUT* no fueron probadas, y siguen estando en construcción hasta que no pasen las 
pruebas. Además, las funcionalidades ya implementadas y probadas pueden ser optimizadas para dar mejor rendimiento y 
mayor facilidad a la hora de manipular los cuerpos en las peticiones (esto último no solo para las funcionalidades de
viajes, sino dentro de la aplicación en general).