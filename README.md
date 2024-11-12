# Desafío Películas - Consulta de Películas de Star Wars

Este proyecto permite realizar consultas de información sobre las películas de Star Wars usando la API de [SWAPI](https://swapi.py4e.com/). Los usuarios pueden ingresar el número de un episodio y recibir información detallada sobre la película correspondiente, como el título, director, productor, fecha de estreno, y el famoso texto de apertura. Además, se genera un archivo JSON con la información recopilada.

## Estructura del Proyecto

El código está dividido en diferentes clases, organizadas en el paquete `com.aluracursos.desafiopeliculas`:

### 1. `Main`

La clase principal que ejecuta el programa. Aquí el usuario puede:
- Ingresar el número de un episodio de Star Wars para consultar la información de esa película.
- Escribir `Salir` para finalizar el programa.

### 2. `ConsultaPelicula`

Esta clase se encarga de la consulta HTTP a la API de SWAPI. 
- Valida que el número de episodio esté en el rango válido (1-7).
- Envía una solicitud a la API para recuperar los detalles de la película y convierte la respuesta JSON en un objeto `PeliculaApi`.

### 3. `PeliculaApi`

Esta clase utiliza la estructura de Java Records para almacenar la información básica de la película obtenida de la API, como el título, el director, el productor, la fecha de estreno y el texto de apertura.

### 4. `Pelicula`

Esta clase representa la estructura interna de una película en el sistema.
- Transforma y almacena los datos obtenidos a través de `PeliculaApi` en un formato más manejable.
- Implementa validaciones adicionales, como la verificación del número de episodio.

### 5. `GenerarArchivoJson`

Esta clase permite guardar la lista de películas consultadas en un archivo JSON.
- Utiliza la biblioteca `Gson` para crear un archivo JSON, `peliculasStarWars.json`, con la información de todas las películas consultadas durante la ejecución del programa.

### 6. `ErrorEnConversionEpisodioException`

Una excepción personalizada que se lanza cuando el número de episodio ingresado no es válido (fuera del rango de 1 a 7).

## Ejecución del Programa

Para ejecutar el programa:
1. Compila el proyecto.
2. Ejecuta la clase `Main`.
3. Ingresa un número de episodio de Star Wars (1 a 7) o escribe `Salir` para finalizar.

Al finalizar, el programa guarda la información de las películas consultadas en el archivo `peliculasStarWars.json`, ubicado en el directorio del proyecto.

---

¡Este proyecto es ideal para aprender sobre el manejo de APIs, la manipulación de JSON y la organización de un proyecto modular en Java!
